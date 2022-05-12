package com.luv2code.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = sf.getCurrentSession();
		try {
		s.beginTransaction();
		
		List<Student> student = s.createQuery("from Student").getResultList();
		//to update a single value
		for(Student stu:student) {
			
			if(stu.getId()==129) {
				stu.setFname("aman");
				System.out.println("Updated the Student with id "+ stu.getId()+" first name to "+stu.getFname());
			}
		}
		
		
		//to update a multiple values
		
		int stu = s.createQuery("update Student set lname='konkal' where lname='yadav'").executeUpdate();
		s.getTransaction().commit();
		
		}finally{
			sf.close();
		}

	}

}
