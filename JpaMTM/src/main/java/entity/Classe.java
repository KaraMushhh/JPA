package entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Classe {
	
	@Id
	@SequenceGenerator(name = "mySeqGenCls", sequenceName = "mySeqCls", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenCls")
	private int cId;
	
	private String name;
	
	@ManyToMany(targetEntity = Insegnante.class, mappedBy = "classeSet")
	private Set insegnanteSet;

	public Classe() {}
	
	public Classe(String name, Set insegnanteSet) {
		
		this.name = name;
		this.insegnanteSet = insegnanteSet;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTeacherSet() {
		return insegnanteSet;
	}

	public void setTeacherSet(Set insegnanteSet) {
		this.insegnanteSet = insegnanteSet;
	}
}


