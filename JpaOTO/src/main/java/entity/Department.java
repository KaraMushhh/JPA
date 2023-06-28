package entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sede")   /* Attenzione: Il nome della tabella sarà sede, ma il nome dell'entità è Department
						   e questo può portare a degli errori. Quindi è buona convenzione far corrispondere
						   il nome dell'entità con quello della tabella */ 
public class Department {
	
	@Id
	@SequenceGenerator(name = "mySeqGenDep", sequenceName = "mySeqDep", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "mySeqGenDep")
	private int dId;
	private String name;
	
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

   
