package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filiere  implements  Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	private String code;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Filiere(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public Filiere() {
		super();
	}

	
	
}
