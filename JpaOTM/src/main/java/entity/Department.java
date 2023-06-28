package entity;
	import java.util.List;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToMany;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;

	@Entity
	@Table(name= "dipartimento")
	public class Department {
		
		@Id
		@SequenceGenerator(name = "mySeqGenDep", sequenceName = "mySeqDep", initialValue = 1, allocationSize = 10)
		@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenDep")
		private int dId;
		
		@Column(name= "nome_dip", nullable = false, length = 255)
		private String nome;
		
		@OneToMany(targetEntity = Employee.class)
		@JoinColumn(name = "DipId")
		private List<Employee> EmployeeList;

		public int getdId() {
			return dId;
		}

		public void setdId(int dId) {
			this.dId = dId;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Employee> getEmployeeList() {
			return EmployeeList;
		}

		public void setEmployeeList(List<Employee> employeeList) {
			EmployeeList = employeeList;
		}
	}


