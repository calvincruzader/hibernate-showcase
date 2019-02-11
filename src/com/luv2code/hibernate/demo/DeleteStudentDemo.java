package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			
			// get a new session and start a transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId); // object deletion through Java sessions
//			System.out.println(myStudent);
			System.out.println("Deleting student: " + myStudent);
			if(myStudent != null) {
				session.delete(myStudent);
			} 
				
			System.out.println("Using HQL: ");
			session.createQuery("delete from Student as s where s.id=2").executeUpdate(); // query delete using HQL
			
			// commit transaction 
			session.getTransaction().commit();

			
		} 
		finally { 
			factory.close();
		}
		
	}

}
