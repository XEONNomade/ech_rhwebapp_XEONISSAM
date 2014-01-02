package dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import model.Compte;
import model.Responsable;

@Transactional
public class CompteServ implements CompteInt,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(ResponsableServ.class) ;

	
	public CompteServ(){
		Log.error("Instanciation de compteServ");
	}

//	la fonction qui s'occupe d'ajouter des objets comptes a la base de données

	
	public void addCompte(Compte compte, Responsable p){
		Log.error("appel de addCompte");
		Session ses = HibernateUtil.getSession();
		compte.setResponsable(p);
		try {
		ses.beginTransaction();
		ses.save(compte);
		ses.getTransaction().commit();
		//ses.close();
		Log.info("bien ajouté");
		} catch (Exception e) {
			Log.info("erreur insertion" + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Compte> listCompte(){
		List<Compte> l =null;
		Session ses = HibernateUtil.getSession();
		try {
		ses.beginTransaction();
		l= ses.createQuery("from Compte").list(); 
		ses.getTransaction().commit();
		//ses.close();
	} catch (Exception e) {
		Log.info("erreur suppression " + e.getMessage());
		ses.beginTransaction().rollback();
		return l;
	}
	return l;
}

//	la mise a jour d'un objet Responsable dans la base de données

	// @Override
	public void updateCompte(Compte compte) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(compte);
			session.getTransaction().commit();
			//session.close();
			Log.info("bien ajouté");
		} catch (Exception e) {
			Log.info("erreur insertion" + e.getMessage());
		}
	}

//	la supprission d'un compte 

	// @Override
	public void deletcompte(Compte compte) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(compte);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			Log.info("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	/* findById Trouver un objet par son identifiant dans  la base de donnée */

	// @Override
	public Compte getCompte(Integer id) {

		Compte compte= null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			compte = (Compte) session.get(Compte.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
	
	public Compte getCompteS(String id) {
		Compte compte= null;
		List<Compte> listobject=null;
	
		Session session = HibernateUtil.getSession();
		try {
			Log.info( " /////////// hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh////////"+id);
			session.beginTransaction();
			listobject=listCompte();
			for (Compte cmt : listobject ) {
				if(cmt.getLogin().equals(id)){
					Log.info( "  compte de password "+cmt.getPword());
					compte=cmt;
					
				}
				
			}
			
			
		} catch (Exception e) {
			Log.info("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
	
//	l'extraction d'un compte a l'aide de son identifiant

	public Compte getCompteO(Object object) {
		Compte compte= null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			compte = (Compte) session.get(Compte.class, (Serializable) object);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
}
