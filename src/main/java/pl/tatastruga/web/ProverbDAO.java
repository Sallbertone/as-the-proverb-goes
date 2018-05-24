package pl.tatastruga.web;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProverbDAO
{

	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Proverb.class)
								.buildSessionFactory();

	Session session = null;

	
	public List<Integer> getIdList()
	{

		List<Integer> idList = new LinkedList<Integer>();

		session = factory.getCurrentSession();
		session.beginTransaction();

		idList = session.createQuery("SELECT id FROM Proverb").getResultList();
		
		System.out.println(idList.get(10));

		session.getTransaction().commit();
		session.close();

		return idList;

	}


	public Proverb getProverb(int id)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();

		Proverb proverb = (Proverb) session.createQuery("FROM Proverb p WHERE p.id =" + id);

		session.getTransaction().commit();
		session.close();
		return proverb;
	}
}