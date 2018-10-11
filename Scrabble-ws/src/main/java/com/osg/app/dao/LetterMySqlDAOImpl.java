package com.osg.app.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

import com.osg.app.dto.LetterDTO;
import com.osg.app.entities.GameEntity;
import com.osg.app.entities.LetterEntity;
import com.osg.app.utils.HibernateUtils;

public class LetterMySqlDAOImpl implements LetterDAO{

	@Override
	public List<LetterDTO> getGameLetters(int gameId) {
		List<LetterDTO> dtos = new ArrayList<>();
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
        
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<LetterEntity> criteria = cb.createQuery(LetterEntity.class);
		
		Root<LetterEntity> root = criteria.from(LetterEntity.class);
		criteria.select(root);
		
		criteria.where(cb.equal(root.get("idgame"), gameId));
		
		Query<LetterEntity> query = session.createQuery(criteria);
		List<LetterEntity> results =  query.getResultList();
		
		for (LetterEntity letterEntity : results) {
			LetterDTO ldto = new LetterDTO();
			BeanUtils.copyProperties(letterEntity, ldto);
			dtos.add(ldto);
		}
		if(session != null) {
			session.close();
		}
		return dtos;
	}

	@Override
	public int saveLetter(LetterDTO dto) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		LetterEntity letterEntity = new LetterEntity();
		BeanUtils.copyProperties(dto, letterEntity);
		
		session.save(letterEntity);
		session.getTransaction().commit();
		
		if(session != null) {
			session.close();
		}
		return letterEntity.getId();
		
	}

}
