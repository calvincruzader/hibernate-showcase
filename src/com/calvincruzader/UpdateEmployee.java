package com.calvincruzader;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.calvincruzader.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class UpdateEmployee {

	public static void main(String[] args) {

		// create session factory 		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction 
			session.beginTransaction();
			
			// get employees by id 
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			// hibernate query (HQL) syntax is based on how they are defined in Java, then translated over to the appropriate SQL
			
//			theStudents = session.createQuery("from Student s where s.lastName='Odiyo'").getResultList();
			
			// change company 
			for(Employee tempEmployee : employees) { 
				System.out.println(tempEmployee);
				tempEmployee.setCompany("Yahoo");
			}
			
			// get transaction and commit
			session.getTransaction().commit();
			
		} 
		finally { 
			factory.close();
		}
		
	}
	
}
