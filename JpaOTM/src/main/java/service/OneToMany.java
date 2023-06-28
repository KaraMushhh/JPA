package service;


	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

	import entity.Department;
	import entity.Employee;

	public class OneToMany {

		public static void main(String[] args) {
			
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("JpaOTM");
			EntityManager em= emf.createEntityManager();
			
			em.getTransaction().begin();
			
			Employee employee1= new Employee("Marco", 2000, "Tecnical Writer");
			Employee employee2= new Employee("Luca", 1500, "Manager");
			Employee employee3= new Employee("Antonio", 3000, "Analyst");
			
			em.persist(employee1);
			em.persist(employee2);
			em.persist(employee3);
			
			List<Employee> employeeList= new ArrayList<>();
			employeeList.add(employee1);
			employeeList.add(employee2);
			employeeList.add(employee3);
			
			Department department= new Department();
			department.setNome("Development");
			
			department.setEmployeeList(employeeList);
			
			em.persist(department);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
		}
	}


