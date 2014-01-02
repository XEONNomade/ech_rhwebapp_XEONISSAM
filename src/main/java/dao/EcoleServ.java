package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;

@Service("ecoleInt")
@Transactional
public class EcoleServ implements EcoleInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(EcoleServ.class) ;
    
	/*
	 * Ajouter un ecole
	 */
	@Override
	public void addEcole(Ecole ecole) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Log.info("ecole bien ajoute");
		try {
			session.beginTransaction();
			session.save(ecole);
				session.getTransaction().commit();
				Log.info("ecole bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion ecole :" + e.getMessage());
		}	
	}
    
	/*
	 * Modifier un ecole
	 */
	@Override
	public void updateEcole(Ecole ecole) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(ecole);
			session.getTransaction().commit();
			Log.info("ecole mise à jour");
		} catch (Exception e) {
			System.out.print("erreur update ecole :" + e.getMessage());
		}
	}

	/*
	 * Supprimer un ecole en spécifiant le ecole
	 */
	@Override
	public void deletEcole(Ecole ecole) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(ecole);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.print(" erreur suppression  ecole :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	/*
	 * get ecole en spécifiant l'Id de ecole
	 */
	@Override
	public Ecole getEcole(Integer id) {
		// TODO Auto-generated method stub
		Ecole ecole = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			ecole = (Ecole) session.get(Ecole.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getecole " + e.getMessage());
			session.beginTransaction().rollback();
			return ecole;
		}
		return ecole;
	}
    
	/*
	 * get de la liste des ecoles
	 */
	@Override
	public List<Ecole> getListEcole() {
		// TODO Auto-generated method stub
		
		
		List<Ecole> listEcole = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			List<Ecole> list = session.createQuery("from Ecole").list();
			listEcole = list;
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur getListEcole " + e.getMessage());
			session.beginTransaction().rollback();
			return listEcole;
		}
		return listEcole;
	}
     
	/*
	 * Supprimer un ecole en spécifiant l'Id
	 */
	@Override
	public void deletEcoleM(Integer ecole) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			Ecole p = (Ecole) session.load(Ecole.class, ecole);
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("erreur deleteecoleM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
