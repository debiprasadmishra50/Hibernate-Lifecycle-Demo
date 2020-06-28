package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Employee;

public class EmployeeDemo 
{
	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			
			// Transient State (emp)
			Employee emp = new Employee("Rog");
			emp.setEmpName("Debi");
			
			// Persistent State (emp)
			session.save(emp);
			emp.setEmpName("Debi Vicky");
			emp.setEmpName("Debi Prasad");
			
			tx.commit();
			session.close();
			// after this emp is a Detached object, no link between Entity and session
			
			emp.setEmpName("Vicky"); //won't be reflected in database
			
			
			emp.finalize(); //Calling explicitly the finalize method
			emp = null;
			System.gc(); //Requesting JVM to call garbage collector
			// emp is in Removed State
		
		}finally {
			factory.close();
		}
	}
}
