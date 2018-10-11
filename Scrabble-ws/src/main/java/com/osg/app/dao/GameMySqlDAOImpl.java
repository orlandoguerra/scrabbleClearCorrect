package com.osg.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;

import com.osg.app.dto.GameDTO;
import com.osg.app.entities.GameEntity;
import com.osg.app.utils.HibernateUtils;

public class GameMySqlDAOImpl implements GameDAO {

	@Override
	public List<GameDTO> getGames() {
		List<GameDTO> dtos = new ArrayList<>();
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<GameEntity> criteria = cb.createQuery(GameEntity.class);
		Root<GameEntity> profileRoot = criteria.from(GameEntity.class);
		criteria.select(profileRoot);
		List<GameEntity> searchResults = session.createQuery(criteria).getResultList();
		
		for (GameEntity gameEntity : searchResults) {
			GameDTO gamDto = new GameDTO();
			BeanUtils.copyProperties(gameEntity, gamDto);
			dtos.add(gamDto);
		}
		if(session != null) {
			session.close();
		}
		return dtos;
	}

	@Override
	public GameDTO getGame(int id) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<GameEntity> criteria = cb.createQuery(GameEntity.class);
        Root<GameEntity> profileRoot = criteria.from(GameEntity.class);
        criteria.select(profileRoot);
        criteria.where(cb.equal(profileRoot.get("id"), id));
        GameEntity gameEntity = session.createQuery(criteria).getSingleResult();
        GameDTO gamDto = new GameDTO();
        BeanUtils.copyProperties(gameEntity, gamDto);
        if(session != null) {
			session.close();
		}
        return gamDto;
	}
	

	@Override
	public int createGame(GameDTO game) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		GameEntity gameEntity = new GameEntity(0, game.getSizex(), game.getSizey(), game.getGamename());
		session.save(gameEntity);
		session.getTransaction().commit();
		
		if(session != null) {
			session.close();
		}
		return gameEntity.getId();
	}

	@Override
	public void updateGame(GameDTO game) {
		GameEntity entity = new GameEntity();
		BeanUtils.copyProperties(game, entity);
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.update(entity);
	    session.getTransaction().commit();
	    
	    if(session != null) {
			session.close();
		}
	}

	@Override
	public void deleteGame(int id) {
		GameEntity entity = new GameEntity();
		entity.setId(id);
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.delete(entity);
	    session.getTransaction().commit();
	    
	    if(session != null) {
			session.close();
		}
		
	}


}
