package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("technologieInt")
@Transactional
public class technologieServ implements technologieInt, Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Technolgie findById(Integer idTechnolgie,Session ses){
		//ses.beginTransaction();
		Technolgie technologie = (Technolgie) ses.load(Object.class,idTechnolgie);
		return technologie;
	}

	
	@Override
	public void addTechnolgie(Technolgie technologie) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(technologie);
				session.getTransaction().commit();
				//session.close();
				System.out.print("theme bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion technologie :" + e.getMessage());
		}
		
		
		
	}

	@Override
	public void updateTechnolgie(Technolgie technologie) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(technologie);
			session.getTransaction().commit();
			//session.close();
			System.out.print("technologie mise a jour");
		} catch (Exception e) {
			System.out.print("erreur update technologie :" + e.getMessage());
		}
	}

	@Override
	public void deletTechnolgie(Technolgie technologie) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(technologie);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.err.print(" erreur suppression  technologie :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	@Override
	public Technolgie getTechnolgie(Integer id) {
		// TODO Auto-generated method stub
		Technolgie technologie = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			technologie = (Technolgie) session.get(Technolgie.class, id);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur gettechnologie " + e.getMessage());
			session.beginTransaction().rollback();
			return technologie;
		}
		return technologie;
	}

	@Override
	public List<Technolgie> getListTechnolgie() {
		// TODO Auto-generated method stub
		
		
		List<Technolgie> listTechnolgie = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
			List<Technolgie> list = session.createQuery("from Technolgie").list();
			listTechnolgie = list;
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListTechnolgie " + e.getMessage());
			session.beginTransaction().rollback();
			return listTechnolgie;
		}
		return listTechnolgie;
	}

	@Override
	public void deletTechnolgieM(Integer technologie) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			
			Technolgie p = (Technolgie) session.load(Technolgie.class, technologie);
			session.delete(p);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur deletetechnologieM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
