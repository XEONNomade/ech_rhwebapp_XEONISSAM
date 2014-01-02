package dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.*;

@Service("responsableInt")
@Transactional
public class ResponsableServ implements ResponsableInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger Log = Logger.getLogger(ResponsableServ.class) ;
	
	
//	la fonction qui s'occupe d'ajouter des objets responsables a la base de données
	public void addResponsable(Responsable responsable) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(responsable);
				session.getTransaction().commit();
				Log.info("Responsable bien ajouté");
		} catch (Exception e) {
			Log.info("erreur insertion :" + e.getMessage());
		}
	}

//	la mise a jour d'un objet Responsable dans la base de données
	public void updateResponsable(Responsable responsable) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(responsable);
			session.getTransaction().commit();
			Log.info("bien ajouté");
		} catch (Exception e) {
			Log.info("erreur updateResponsable" + e.getMessage());
		}
	}
	
	/* findById Trouver un objet par son identifiant dans  la base de donnée */
	public Responsable findById(Integer responsable ,Session ses){
		ses.beginTransaction();
		Responsable per = (Responsable) ses.load(Responsable.class, responsable);
		return per;
	}
	
//	la supprission d'un responsable 

	// @Override
	public void deletresponsable(Responsable responsable) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(responsable);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.error(" erreur suppression deletpersonn" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
//	l'extraction d'un responsable a l'aide de son identifiant
	public Responsable getResponsable(Integer id) {

		Responsable responsable = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			responsable = (Responsable) session.get(Responsable.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur getResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return responsable;
		}
		return responsable;
	}


//	la fonction qui renvoie la liste des responsables de la base de données
	@SuppressWarnings("unchecked")
	public List<Responsable> getListResponsable() {
		List<Responsable> listResponsable = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Log.error("debut de select * from");
			List<Responsable> list = session.createQuery("from Responsable").list();
			listResponsable = list;
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur getListResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return listResponsable;
		}
		return listResponsable;
	}
//	la supprission d'un responsable a l'aide de son identifiant
	public void deletresponsableId(Integer responsable) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			session.delete(this.findById(responsable, session));
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur deletresponsable " + e.getMessage());
			session.beginTransaction().rollback();
		}
		
	}
	
}
