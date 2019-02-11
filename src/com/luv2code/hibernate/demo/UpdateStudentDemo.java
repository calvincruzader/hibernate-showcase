package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			
			// get a new session and start a transaction 
		
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId); // a persistent object 
			
			System.out.println("\nUpdating student: " + myStudent);
			myStudent.setFirstName("Garfunkel"); 
			
			// commit transaction 
			session.getTransaction().commit();
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update everyone's email: ");
			
			session.createQuery("update Student set email='foooo@gmail.com'").executeUpdate();

			// commit transaction 
			session.getTransaction().commit();
			
		} 
		finally { 
			factory.close();
		}
		
	}

}
