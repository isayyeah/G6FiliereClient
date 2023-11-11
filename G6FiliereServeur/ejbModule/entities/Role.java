package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role implements  Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(mappedBy = "role")
    private List<User> user;
	
	
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role(int id, String name, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}
	public Role() {
		super();
	}
	
	
	
}