package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Collaborateur;


@Service("collaborateurInt")
@Transactional
public class collaborateurServ implements collaborateurInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
/*	public Set<Question> getQuestionList(Integer id) {
		Set<Question> listQuestion = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
			Collaborateur par=(Collaborateur)session.load(Collaborateur.class,id);
			//Collaborateur dmformation = (Collaborateur) session.load(Collaborateur.class,Iddmd);
			//Iddmd.getObjectifs().add(objectif);
			System.err.println("afiichage des question d'une demande");
			listQuestion=(Set<Question>) par.getQuestions();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListCollaborateur " + e.getMessage());
			session.beginTransaction().rollback();
			return listQuestion;
		}
		return listQuestion;
	}
*/

/*	
public void addObjectifToDmdF(Integer objectif,Integer Iddmd) {
	    
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Objectif obj=(Objectif)session.load(Objectif.class,objectif);
			Collaborateur dmformation = (Collaborateur) session.load(Collaborateur.class,Iddmd);
			//Objectif obj=(Objectif)session.load(Objectif.class,objectif);
			System.err.print("dmformation en train hihihihihihihih suspence");
			
			//Iddmd.getObjectifs().add(obj);
			dmformation.getObjectifs().add(obj);
			session.getTransaction().commit();
			System.out.print("objet dmd bien ajout�");
				System.err.print("objet dmd bien ajout�");
				//session.close();
		} catch (Exception e) {
			System.err.print("erreur insertion dmformation :" + e.getMessage());
		}
	}

public List<Objectif> getListobjectif(Integer Iddmd) {
	List<Objectif> listeobject = null;
	Session session = HibernateUtil.getSession();
	try {
		session.beginTransaction();
		System.err.print("dmformation en train hihihihihihihih suspence////////////////");
		Collaborateur dmformation = (Collaborateur) session.load(Collaborateur.class,Iddmd);
		System.err.print("//////////demande id est "+dmformation.getRaison());
	
		System.err.print("dmformation en train hihihihihihihih suspence================");
      
		
		 listeobject =new ArrayList<Objectif> (dmformation.getObjectifs());
		 session.getTransaction().commit();
		System.out.print("objectif bien lie");
			System.err.print("objectif dmd lie");
			
			//session.close();
	} catch (Exception e) {
		System.err.print("erreur get dmformation :" + e.getMessage());
	}
	return listeobject;
}
*/

	@Override
	public void addcollaborateur(Collaborateur collaborateur) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(collaborateur);
				session.getTransaction().commit();
				System.out.print("collaborateur bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion demande :" + e.getMessage());
		}
		
	}

	@Override
	public void updatecollaborateur(Collaborateur collaborateur) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(collaborateur);
			session.getTransaction().commit();
			System.out.print("collaborateur mise a jour");
		} catch (Exception e) {
			System.out.print("erreur update collaborateur :" + e.getMessage());
		}
	}

	@Override
	public void deletcollaborateur(Collaborateur collaborateur) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(collaborateur);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.err.print(" erreur suppression  collaborateur :" + e.getMessage());
			session.beginTransaction().rollback();
		}
		
	}

	@Override
	public Collaborateur getcollaborateur(Integer idCollaborateur) {
		// TODO Auto-generated method stub
		Collaborateur collaborateur = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			collaborateur = (Collaborateur) session.load(Collaborateur.class,idCollaborateur);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.print("erreur getPersonne " + e.getMessage());
			session.beginTransaction().rollback();
			return collaborateur;
		}
		return collaborateur;
	}

	@Override
	public List<Collaborateur> getListcollaborateur() {
		// TODO Auto-generated method stub
		List<Collaborateur> listCollaborateur = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
			List<Collaborateur> list = session.createQuery("from Collaborateur").list();
			listCollaborateur = list;
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getListCollaborateur " + e.getMessage());
			session.beginTransaction().rollback();
			return listCollaborateur;
		}
		return listCollaborateur;
	}

	@Override
	public void deletcollaborateurM(Integer idCollaborateur) {
		// TODO Auto-generated method stub
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			Collaborateur collaborateur = (Collaborateur) session.load(Collaborateur.class,idCollaborateur);
			session.delete(collaborateur);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur deletpersonneM " + e.getMessage());
			session.beginTransaction().rollback();
		}
		
	}
}
