package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;

@Service("diplomeInt")
@Transactional
public class DiplomeServ implements DiplomeInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(DiplomeServ.class) ;
    
	/*
	 * Ajouter un diplome
	 */
	@Override
	public void addDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(diplome);
				session.getTransaction().commit();
				Log.info("diplome bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion diplome :" + e.getMessage());
		}	
	}
    
	/*
	 * Modifier un diplome
	 */
	@Override
	public void updateDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(diplome);
			session.getTransaction().commit();
			Log.info("diplome mise à jour");
		} catch (Exception e) {
			System.out.print("erreur update diplome :" + e.getMessage());
		}
	}

	/*
	 * Supprimer un diplome en spécifiant le diplome
	 */
	@Override
	public void deletDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(diplome);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.print(" erreur suppression  diplome :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	/*
	 * get diplome en spécifiant l'Id de diplome
	 */
	@Override
	public Diplome getDiplome(Integer id) {
		// TODO Auto-generated method stub
		Diplome diplome = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			diplome = (Diplome) session.get(Diplome.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getdiplome " + e.getMessage());
			session.beginTransaction().rollback();
			return diplome;
		}
		return diplome;
	}
    
	/*
	 * get de la liste des diplomes
	 */
	@Override
	public List<Diplome> getListDiplome() {
		// TODO Auto-generated method stub
		
		
		List<Diplome> listDiplome = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Diplome> list = session.createQuery("from Diplome").list();
			listDiplome = list;
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getListDiplome " + e.getMessage());
			session.beginTransaction().rollback();
			return listDiplome;
		}
		return listDiplome;
	}
     
	/*
	 * Supprimer un diplome en spécifiant l'Id
	 */
	@Override
	public void deletDiplomeM(Integer diplome) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			Diplome p = (Diplome) session.load(Diplome.class, diplome);
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur deletediplomeM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
