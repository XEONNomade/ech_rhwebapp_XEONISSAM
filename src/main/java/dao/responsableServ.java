package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.*;

@Service("responsableInt")
@Transactional
public class responsableServ implements responsableInt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addResponsable(Responsable responsable) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(responsable);
				session.getTransaction().commit();
				//session.close();
				System.out.print("Technicien bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion :" + e.getMessage());
		}
	}

	public void updateResponsable(Responsable responsable) {

		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(responsable);
			session.getTransaction().commit();
			//session.close();
			System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur updateResponsable" + e.getMessage());
		}
	}
	public Responsable findById(Integer responsable ,Session ses){
		ses.beginTransaction();
		Responsable per = (Responsable) ses.load(Responsable.class, responsable);
		return per;
	}

	// @Override
	public void deletresponsable(Responsable responsable) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(responsable);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.err.print(" erreur suppression deletpersonn" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	public Responsable getResponsable(Integer id) {

		Responsable responsable = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			responsable = (Responsable) session.get(Responsable.class, id);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur getResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return responsable;
		}
		return responsable;
	}

	// @Override
	@SuppressWarnings("unchecked")
	public List<Responsable> getListResponsable() {
		List<Responsable> listResponsable = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
			List<Responsable> list = session.createQuery("from Responsable").list();
			listResponsable = list;
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return listResponsable;
		}
		return listResponsable;
	}

	public void deletresponsableId(Integer responsable) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			session.delete(this.findById(responsable, session));
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur deletresponsable " + e.getMessage());
			session.beginTransaction().rollback();
		}
		
	}
	public List<Responsable> getListTechnicien() {
		List<Responsable> listTechnicien = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
		    listTechnicien = session.createQuery("from Responsable where grade='Technicien'").list();
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return listTechnicien;
		}
		return listTechnicien;
	}
	public List<Responsable> getListCad() {
		List<Responsable> list = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
		    list = session.createQuery("from Responsable where grade='Cadre'").list();
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return list;
		}
		return list;
	}
	public List<Responsable> getListAdm() {
		List<Responsable> list = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
		    list = session.createQuery("from Responsable where grade='Administratif'").list();
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListResponsable " + e.getMessage());
			session.beginTransaction().rollback();
			return list;
		}
		return list;
	}

}
