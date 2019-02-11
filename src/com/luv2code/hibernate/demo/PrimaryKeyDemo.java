package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object 
			System.out.println("Creating 3 student objects.");
			Student tempStudent1 = new Student("Kiran", "Karki", "kkarki@fakegmail.com");
			Student tempStudent2 = new Student("Linzi", "Odiyo", "lodiyo@fakegmail.com");
			Student tempStudent3 = new Student("Aggrey", "Nunes", "ANunes@fakegmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			// save the student object 
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction 
			session.getTransaction().commit();
			
		} 
		finally { 
			factory.close();
		}

	}

}
