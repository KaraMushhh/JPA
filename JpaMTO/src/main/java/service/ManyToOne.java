package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Department;
import entity.Employee;

public class ManyToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JpaMTO");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Department department= new Department();
		department.setName("Development");
		em.persist(department);
		
		Department department2= new Department();
		department2.setName("Analysis");
		em.persist(department2);
		
		Employee employee1= new Employee("Marco", 2000, "Tecnical Writer");
		employee1.setDepartment(department);
		
		Employee employee2= new Employee("Luca", 1500, "Manager");
		employee2.setDepartment(department);
		
		Employee employee3= new Employee("Antonio", 3000, "Analyst");
		employee3.setDepartment(department2);
		
		em.persist(employee1);
		em.persist(employee2);
		em.persist(employee3);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}

    
