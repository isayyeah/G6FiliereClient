package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless(name = "studentS")
public class StudentService implements IDao<Student> {

	@PersistenceContext 
	private EntityManager em;
	
	@Override
	@PermitAll
	public Student create(Student o) {
		em.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Student delete(Student o) {
		Student student = em.find(Student.class, o.getId());
		if(student != null) {
			em.remove(student);
		}
		return student;
	}

	@Override
	@PermitAll
	public Student update(Student o) {
		Student student = em.find(Student.class, o.getId());
		if(student != null) {
			student.setFiliere(student.getFiliere());
			student.setFirstName(student.getFirstName());
			student.setLastName(student.getLastName());
			student.setLogin(student.getLogin());
			student.setPassword(student.getPassword());
			student.setRole(student.getRole());
			student.setTelephone(student.getTelephone());
			em.merge(student);
			return student;
		}
		return null;
	}

	@Override
	@PermitAll
	public Student findById(int id) {
		Student student = em.find(Student.class, id);
		if(student == null) throw new RuntimeException("Student introuvable");
		return student;
	}

	@Override
	@PermitAll
	public List<Student> findAll() {
		Query query = em.createQuery("select s from Student s");
		return query.getResultList();
	}
	
	public List<Student> getStudentsByFiliere(Filiere filiere) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.filiere = :filiere");
        query.setParameter("filiere", filiere);

        return query.getResultList();
    }
	
}
