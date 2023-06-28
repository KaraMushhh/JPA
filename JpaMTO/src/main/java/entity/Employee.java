package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	
	@Id
	@SequenceGenerator(name = "mySeqGenEmp", sequenceName = "mySeqEmp", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenEmp")
	private int eId;
	private String name;
	private double salary;
	private String deg;
	
	@ManyToOne
	private Department department;
	
	public Employee() {}

	public Employee(String name, double salary, String deg) {
		
		this.name = name;
		this.salary = salary;
		this.deg = deg;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}


