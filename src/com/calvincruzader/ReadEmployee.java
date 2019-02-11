package com.calvincruzader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.calvincruzader.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class ReadEmployee {

	public static void main(String[] args) {

		// create session factory 		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object 
			System.out.println("Creating a new employee object.");
			Employee tempEmployee = new Employee("Donnie", "Howell", "Nationwide");
			
			// start a transaction 
			session.beginTransaction();
			
			// save the student object 
			System.out.println("Saving the employee...");
			session.save(tempEmployee);
			
			// commit transaction 
			session.getTransaction().commit();
			
			// grab the employee out of the database
			System.out.println("Grab the employee with this id: " + tempEmployee.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			tempEmployee = session.get(Employee.class, tempEmployee.getId());
			
			session.getTransaction().commit();
			
			System.out.println("Grabbed this employee from the database: " + tempEmployee);
			
			
		} 
		finally { 
			factory.close();
		}
		
	}
	
}
