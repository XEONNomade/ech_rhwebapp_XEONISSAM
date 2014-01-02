package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;

@Service("posteInt")
@Transactional
public class posteServ implements posteInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(posteServ.class) ;
    
	/*
	 * Ajouter un poste
	 */
	@Override
	public void addPoste(Poste poste) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(poste);
				session.getTransaction().commit();
				Log.info("poste bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion poste :" + e.getMessage());
		}	
	}
    
	/*
	 * Modifier un poste
	 */
	@Override
	public void updatePoste(Poste poste) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(poste);
			session.getTransaction().commit();
			Log.info("poste mise à jour");
		} catch (Exception e) {
			System.out.print("erreur update poste :" + e.getMessage());
		}
	}

	/*
	 * Supprimer un poste en spécifiant le poste
	 */
	@Override
	public void deletPoste(Poste poste) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(poste);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.print(" erreur suppression  poste :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	/*
	 * get poste en spécifiant l'Id de poste
	 */
	@Override
	public Poste getPoste(Integer id) {
		// TODO Auto-generated method stub
		Poste poste = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			poste = (Poste) session.get(Poste.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getposte " + e.getMessage());
			session.beginTransaction().rollback();
			return poste;
		}
		return poste;
	}
    
	/*
	 * get de la liste des postes
	 */
	@Override
	public List<Poste> getListPoste() {
		// TODO Auto-generated method stub
		
		
		List<Poste> listPoste = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Poste> list = session.createQuery("from Poste").list();
			listPoste = list;
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getListPoste " + e.getMessage());
			session.beginTransaction().rollback();
			return listPoste;
		}
		return listPoste;
	}
     
	/*
	 * Supprimer un poste en spécifiant l'Id
	 */
	@Override
	public void deletPosteM(Integer poste) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			Poste p = (Poste) session.load(Poste.class, poste);
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur deleteposteM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
