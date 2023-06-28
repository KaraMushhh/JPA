package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lavoratore")   /* Attenzione: Il nome della tabella sarà lavoratore, ma il nome dell'entità è Employee
								 e questo può portare a degli errori. Quindi è buona convenzione far corrispondere
								 il nome dell'entità con quello della tabella */ 
public class Employee {
	
	@Id
	@SequenceGenerator(name = "mySeqGenImp", sequenceName = "mySeqImp", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenImp")
	private int eId;
	private String name;
	private double salary;
	private String deg;
	
	@OneToOne
	private Department department;
	
	public Employee() {}
	
	public Employee(String name, double salary, String deg, Department department) {
		
		this.name = name;
		this.salary = salary;
		this.deg = deg;
		this.department= department;
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

