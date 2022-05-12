package com.luv2code.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			//To retrive a single student
			Student s  = session.get(Student.class, st.getId());
			System.out.println("the student details are "+s);
			
			//To Retrive a list of students
			
			List<Student> students = session.createQuery("from Student").getResultList();
			DisplayStudent(students);
			
			students = session.createQuery("from Student where fname='nethra' OR lname='yadav' OR"
					+  " email LIKE '%gmail.com'").getResultList();
			
			
			DisplayStudent(students);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally{
			factory.close();
		}
		
		
	}

	private static void DisplayStudent(List<Student> students) {
		for(Student student:students) {
			System.out.println(student);
		}
	}

}
