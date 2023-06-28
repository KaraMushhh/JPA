package entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "impiegato")
public class Employee {
	
	@Id
	@SequenceGenerator(name = "mySeqGenImp", sequenceName = "mySeqImp", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenImp")
	private int eId;
	
	@Column(name= "nome")
	private String name;
	
	@Column(name= "salario")
	private double salary;
	
	@Column(name= "ruolo")
	private String deg;

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
}

    