package service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Department;
import entity.Employee;

public class OneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JpaOTO");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Department department= new Department();
		department.setName("Development");
		
		em.persist(department);
		
		Employee employee= new Employee("Davide", 2000, "Developer", department);
		
		em.persist(employee);
		
		Department department2= new Department();
		department2.setName("Maintenance");
		
		em.persist(department2);
		
		Employee employee2= new Employee("Luigi", 1000, "Janitor", department2);
		
		em.persist(employee2);
		
		em.getTransaction().commit();
		
		/*
		 * Query query= em.createQuery("select e.name from Employee e");
		 * 
		 * List<String> list= query.getResultList();
		 * 
		 * for(String name: list) System.out.println("Employee name= " + name);
		 */
		
		em.close();
		emf.close();
	}
}

