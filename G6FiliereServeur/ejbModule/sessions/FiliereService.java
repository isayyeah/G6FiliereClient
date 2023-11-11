package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;


@Stateless(name = "filiereS")
public class FiliereService  implements IDao<Filiere> {
	
	@PersistenceContext 
	private EntityManager em;
	
	@Override
	@PermitAll
	public Filiere create(Filiere o) {
		em.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Filiere delete(Filiere o) {
		Filiere filiere = em.find(Filiere.class, o.getId());
		if(filiere != null) {
			em.remove(filiere);
		}
		return filiere;
	}

	@Override
	@PermitAll
	public Filiere update(Filiere o) {
		Filiere filiere = em.find(Filiere.class, o.getId());
		if(filiere != null) {
			filiere.setCode(filiere.getCode());
			filiere.setName(filiere.getName());
			em.merge(filiere);
			return filiere;
		}
		return null;
	}

	@Override
	@PermitAll
	public Filiere findById(int id) {
		Filiere filiere = em.find(Filiere.class, id);
		if(filiere == null) throw new RuntimeException("Role introuvable");
		return filiere;
	}

	@Override
	@PermitAll
	public List<Filiere> findAll() {
		Query query = em.createQuery("select f from Filiere f");
		return query.getResultList();
	}


}
