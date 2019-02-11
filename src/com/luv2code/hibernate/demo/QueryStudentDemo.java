package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction 
			session.beginTransaction();
			
			// query students 
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display results 
			displayStudents(theStudents);
			
			// get last name Odiyo
			theStudents = session.createQuery("from Student s where s.lastName='Odiyo'").getResultList();
			
			// display students with last name Odiyo
			System.out.println("Student with last name Odiyo:");
			displayStudents(theStudents);
			
			// query with last name Odiyo or first name Dolan 
			theStudents = session.createQuery("from Student s where s.lastName='Odiyo' or s.firstName='Dolan'").getResultList();
			System.out.println("Students with last name Odiyo or first name Dolan:");
			displayStudents(theStudents);
			
			// query if email includes fakegemail.com
			theStudents = session.createQuery("from Student s where s.email like '%yahoomail.com'").getResultList();
			System.out.println("Students with email yahoomail.com:");
			displayStudents(theStudents);
			
			// commit transaction 
			session.getTransaction().commit();
			
		} 
		finally { 
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) System.out.println(tempStudent);
	}

}
