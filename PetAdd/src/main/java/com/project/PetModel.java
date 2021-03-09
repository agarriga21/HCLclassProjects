package com.project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class PetModel {

	protected SessionFactory sessionFactory = Hibernate.getSessionFactory();

	public boolean update(Product pet) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(pet);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println(e);
			}
			result = false;
		} finally {
			session.close();
		}
		return result;
	}
}
