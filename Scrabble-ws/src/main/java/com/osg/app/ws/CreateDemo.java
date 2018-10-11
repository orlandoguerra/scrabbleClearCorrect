package com.osg.app.ws;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.osg.app.entities.GameEntity;
import com.osg.app.entities.LetterEntity;


public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory sessionFact = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(GameEntity.class)
								.addAnnotatedClass(LetterEntity.class)
								.buildSessionFactory();
		
		Session session = sessionFact.getCurrentSession();
		
		try {
			session.beginTransaction();
			LetterEntity letter = new LetterEntity(0, 1, "A", 12, 2);
			//GameEntity game = new GameEntity(0, 15, 15, "Orlas1");
			session.save(letter);
			session.getTransaction().commit();
		}finally {
			session.close();
			sessionFact.close();
		}
		
		

	}

}
