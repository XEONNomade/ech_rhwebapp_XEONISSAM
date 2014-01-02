package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import model.Compte;
import model.Responsable;

@Transactional
public class compteServ implements compteInt,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public compteServ(){
		System.err.println("Instanciation de compteServ");
	}

	public void addCompte(Compte compte, Responsable p){
		System.err.println("appel de addCompte");
		Session ses = HibernateUtil.getSession();
		compte.setResponsable(p);
		try {
		ses.beginTransaction();
		ses.save(compte);
		ses.getTransaction().commit();
		//ses.close();
		System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
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
		System.out.print("erreur suppression " + e.getMessage());
		ses.beginTransaction().rollback();
		return l;
	}
	return l;
}

	// @Override
	public void updateCompte(Compte compte) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(compte);
			session.getTransaction().commit();
			//session.close();
			System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
		}
	}

	// @Override
	public void deletcompte(Compte compte) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(compte);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	// @Override
	public Compte getCompte(Integer id) {

		Compte compte= null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			compte = (Compte) session.get(Compte.class, id);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
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
			System.out.println( " /////////// hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh////////"+id);
			session.beginTransaction();
		//	compte = (Compte) session.get(Compte.class, id);
			listobject=listCompte();
			for (Compte cmt : listobject ) {
				if(cmt.getLogin().equals(id)){
					System.out.println( "  compte de password "+cmt.getPword());
					compte=cmt;
					
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
	public Compte getCompteO(Object object) {
		Compte compte= null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			compte = (Compte) session.get(Compte.class, (Serializable) object);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur suppression" + e.getMessage());
			session.beginTransaction().rollback();
			return compte;
		}
		return compte;
	}
}
