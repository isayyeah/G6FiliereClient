package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless(name = "userS")
public class UserService implements IDao<User>  , IDaoLocal<User>{
	
	@PersistenceContext 
	private EntityManager em;
	@Override
	@PermitAll
	public User create(User o) {
		em.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public User delete(User o) {
		User user = em.find(User.class, o.getId());
		if(user != null) {
			em.remove(user);
		}
		return user;
	}

	@Override
	@PermitAll
	public User update(User o) {
		User user = em.find(User.class, o.getId());
		if(user != null) {
			user.setLogin(user.getLogin());
			user.setPassword(user.getPassword());
			user.setRole(user.getRole());
			em.merge(user);
			return user;
		}
		return null;
	}

	@Override
	@PermitAll
	public User findById(int id) {
		User user = em.find(User.class, id);
		if(user == null) throw new RuntimeException("User introuvable");
		return user;
	}

	@Override
	@PermitAll
	public List<User> findAll() {
		Query query = em.createQuery("select u from User u");
		return query.getResultList();
	}
	
}
