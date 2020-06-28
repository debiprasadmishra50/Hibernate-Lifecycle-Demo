package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

//@SuppressWarnings("deprecation")
@Entity
//@org.hibernate.annotations.Entity(selectBeforeUpdate = true) //Optional, if there is any update before next session / if any setter method is called with Entity class object
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int Id;
	
	@Column(name="empname")
	private String empName;
	
	public Employee() {
	}
	
	public Employee(String empName) {
		super();
		this.empName = empName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", empName=" + empName + "]";
	}
	
	@Override
	public void finalize() {
		
	}
}
