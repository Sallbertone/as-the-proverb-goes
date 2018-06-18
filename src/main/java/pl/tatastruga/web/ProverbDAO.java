package pl.tatastruga.web;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProverbDAO
{

	Proverb proverb = new Proverb();
	SessionFactory factory;
	Session session;
	
	List<Integer> idList = new LinkedList<Integer>();

	

	public List<Integer> getIdList()
	{
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Proverb.class)
				.buildSessionFactory();
		
		session = factory.getCurrentSession();
		session.beginTransaction();

		idList = session.createQuery("SELECT id FROM Proverb").getResultList();
		
		session.getTransaction().commit();
		session.close();

		return idList;

	}


	public Proverb getProverb(int id)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();

		proverb = (Proverb) session.createQuery("FROM Proverb P WHERE P.id = " + id).getSingleResult();

		session.getTransaction().commit();
		session.close();
		return proverb;
	}
}