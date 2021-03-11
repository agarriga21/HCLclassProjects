package project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.HibernateUtil;
import project.User;

public class UserModel {

	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public boolean save(User user) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(user);
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
