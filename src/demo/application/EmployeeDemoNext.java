package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Employee;

public class EmployeeDemoNext 
{
	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		try {
			Session session1 = factory.openSession();
			Transaction tx = session1.beginTransaction();
			
			Employee emp = session1.get(Employee.class, 1); // emp in persistent state
			
			tx.commit();
			session1.close(); // emp in Detached state
			
			emp.setEmpName("Vicky");

			Session session2 = factory.openSession();
			Transaction tx2 = session2.beginTransaction();
			
			session2.merge(emp); // emp in Persistent state
//			emp.setEmpName("Vickysh");
			
			
			tx2.commit();
			session2.close(); // emp in Detached state
			
			
			emp.finalize(); //Calling explicitly the finalize method
			emp = null;
			System.gc(); //Requesting JVM to call garbage collector
			// emp is in Removed State
		
		}finally {
			factory.close();
		}
	}
}
