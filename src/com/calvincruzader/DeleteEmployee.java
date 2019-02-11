package com.calvincruzader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.calvincruzader.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteEmployee {

	public static void main(String[] args) {

		// create session factory 		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 8;
			
			// get current session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get the employee
			Employee tempEmp = session.get(Employee.class, employeeId);
			
			if(tempEmp != null) session.delete(tempEmp);

			
			
			// commit transaction 
			session.getTransaction().commit();
			
		} 
		finally { 
			factory.close();
		}
		
	}

}
