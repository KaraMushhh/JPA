package entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Insegnante {
	
	@Id
	@SequenceGenerator(name = "mySeqGenIns", sequenceName = "mySeqIns", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenIns")
	private int tId;
	private String name;
	private String materia;
	
	@ManyToMany(targetEntity = Classe.class)
	@JoinTable( name = "insegnante_classe", joinColumns = @JoinColumn(name = "tId"), inverseJoinColumns = @JoinColumn(name = "cId"))
	private Set classeSet;
	
	public Insegnante() {}
	
	public Insegnante(String name, String materia, Set classeSet) {
		
		this.name = name;
		this.materia = materia;
		this.classeSet = classeSet;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Set getClasseSet() {
		return classeSet;
	}

	public void setClasseSet(Set classeSet) {
		this.classeSet = classeSet;
	}
}

