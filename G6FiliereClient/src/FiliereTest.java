import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Filiere;
import entities.Student;
import entities.User;

public class FiliereTest {

	public static IDao<User> lookUpUserRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<User>) context.lookup("ejb:/G6FiliereServeur/userS!dao.IDao");

	}
	
	public static IDao<Filiere> lookUpFiliereRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Filiere>) context.lookup("ejb:/G6FiliereServeur/filiereS!dao.IDao");

	}
	
	
	public static IDao<Student> lookUpStudentRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Student>) context.lookup("ejb:/G6FiliereServeur/studentS!dao.IDao");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//*********************************************************users*************************************************** 
			IDao<User> dao = lookUpUserRemote();
			dao.create(new User("Sabt", "Hajar"));
			dao.create(new User("Badia", "Ahmed"));
			dao.create(new User("Saleh", "Fati"));

			
			System.out.println("List of users"); 
			
			for(User e : dao.findAll())
				System.out.println(e.getLogin());
			
			
			
			
			 // Mise à jour d'un user
            User userToUpdate = dao.findById(1); 
            if (userToUpdate != null) {
            	userToUpdate.setLogin("Hajar");
                dao.update(userToUpdate);
                System.out.println("User modifie avec succés ");
            }

            // Suppression d'un user
            User userToDelete = dao.findById(5); 
            if (userToDelete != null) {
                dao.delete(userToDelete);
                System.out.println("User supprime avec succés ");
            }
            
            System.out.println("List of users after update"); 
			
			for(User e : dao.findAll())
				System.out.println(e.getLogin());
			

			//	*********************************************************************Filieres**************************************************************** 
			IDao<Filiere> daoF = lookUpFiliereRemote();
			daoF.create(new Filiere("F1", "MIAGE"));
			daoF.create(new Filiere("F2", "GC"));
			daoF.create(new Filiere("F3", "GI"));

			
			System.out.println("List of FILIERE"); 
			
			for(Filiere e : daoF.findAll())
				System.out.println(e.getName());
			
			
			
			
			 // Mise à jour d'un étudiant
            Filiere filiereToUpdate = daoF.findById(1); 
            if (filiereToUpdate != null) {
            	filiereToUpdate.setName("Hajar");
                daoF.update(filiereToUpdate);
                System.out.println("Filiere modifie avec succés ");
            }

            // Suppression d'un étudiant
            Filiere filiereToDelete = daoF.findById(4); 
            if (filiereToDelete != null) {
                daoF.delete(filiereToDelete);
                System.out.println("Filiere supprime avec succés ");
            }
            
            System.out.println("List of filiere after update"); 
			
			for(Filiere e : daoF.findAll())
				System.out.println(e.getName());
			//******************************************************************students******************************************************************* 
			/*IDao<Student> daoS = lookUpStudentRemote();
			daoS.create(new Student(1,"Hajar","Sabt","0643103194"));
			daoS.create(new Student(1,"Hind","Sabiri","0661232311"));
			daoS.create(new Student(1,"Khalid","Berrada","0656453411"));

			
			System.out.println("List of Stuents"); 
			
			for(Student e : daoS.findAll())
				System.out.println(e.getFirstName());
			
			
			
			
			 // Mise à jour d'un étudiant
            Student studentToUpdate = daoS.findById(1); 
            if (studentToUpdate != null) {
            	studentToUpdate.setFirstName("Hajar");
                daoS.update(studentToUpdate);
                System.out.println("Student modifie avec succés ");
            }

            // Suppression d'un étudiant
            Student studentToDelete = daoS.findById(4); 
            if (studentToDelete != null) {
                daoS.delete(studentToDelete);
                System.out.println("Student supprime avec succés ");
            }
            
            System.out.println("List of Student after update"); 
			
			for(Student e : daoS.findAll())
				System.out.println(e.getFirstName());
			 
			
			
			
			
			 */

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
