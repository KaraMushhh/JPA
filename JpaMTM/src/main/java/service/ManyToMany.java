package service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Classe;
import entity.Insegnante;

public class ManyToMany {

	public static void main(String[] args) {

		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JpaMTM");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Classe classe1= new Classe("1F", null);
		Classe classe2= new Classe("2F", null);
		Classe classe3= new Classe("5D", null);
		
		em.persist(classe1);
		em.persist(classe2);
		em.persist(classe3);
		
		Set<Classe> setClasse1= new HashSet<>();
		setClasse1.add(classe1);
		setClasse1.add(classe2);
		setClasse1.add(classe3);
		
		Set<Classe> setClasse2= new HashSet<>();
		setClasse2.add(classe1);
		setClasse2.add(classe2);
		
		Insegnante insegnante1= new Insegnante("Maria", "Storia", setClasse1);
		Insegnante insegnante2= new Insegnante("Paola", "Italiano", setClasse2);
		
		em.persist(insegnante1);
		em.persist(insegnante2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}

