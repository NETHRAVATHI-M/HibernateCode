package com.luv2code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//to add a student details
public class CreateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new studnet objects");
			
			Student st = new Student("nethra","vathi","nethra.gmail.com");
			Student st1 = new Student("nayana","yadav","nethra.gmail.com");
			Student st2 = new Student("siddu","yadav","nethra.gmail.com");
			session.beginTransaction();
			session.save(st);
			session.save(st1);
			session.save(st2);
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally{
			factory.close();
		}
	}

}
