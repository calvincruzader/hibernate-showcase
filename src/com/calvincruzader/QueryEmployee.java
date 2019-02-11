package com.calvincruzader;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.calvincruzader.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class QueryEmployee {

	public static void main(String[] args) {

		// create session factory 		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();
		
		try {

			// start session 
			session.beginTransaction();
//			
//			// create a few employees from different companies
//			Employee emp1 = new Employee("Chris", "Guti", "AISD");
//			Employee emp2 = new Employee("Justin", "Chow", "NYU Film Academy");
//			Employee emp3 = new Employee("Efren", "Cruzada", "Some English Comp");
//			Employee emp4 = new Employee("Karen", "John", "AISD");
//			Employee emp5 = new Employee("Maria", "Cruzada", "AISD");
//			
//			// save them into the db 
//			session.save(emp1);
//			session.save(emp2);
//			session.save(emp3);
//			session.save(emp4);
//			session.save(emp5);

			
			List<Employee> employeesAISD = session.createQuery("from Employee e where e.company='AISD'").getResultList();
			
			System.out.println("Employees working at AISD:");
			displayEmployees(employeesAISD);
			
			// commit transaction
			session.getTransaction().commit();
		} 
		finally { 
			factory.close();
		}
		
	}

	private static void displayEmployees(List<Employee> employees) {
		for(Employee emp : employees) System.out.println(emp);
	}
	
}
