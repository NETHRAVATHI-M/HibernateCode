package com.luv2code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sf.getCurrentSession();

		try {
			session.beginTransaction();

			// method 1: to delete the required ID by using get method to get object and
			// delete function to delete
			Student stu = session.get(Student.class, 1);

			System.out.println("Deleting the student " + stu);

			session.delete(stu);
			System.out.println("done");

			// method 2: use create Query

			session.createQuery("delete from Student where id=100").executeUpdate();
			System.out.println("second method is successfull");
			session.getTransaction().commit();

		} finally {
			sf.close();
		}

	}

}
