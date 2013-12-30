package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("competenceInt")
@Transactional
public class competenceServ implements competenceInt, Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Competence findById(Integer idCompetence,Session ses){
		//ses.beginTransaction();
		Competence competence = (Competence) ses.load(Object.class,idCompetence);
		return competence;
	}

	
	@Override
	public void addCompetence(Competence competence) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(competence);
				session.getTransaction().commit();
				//session.close();
				System.out.print("theme bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion competence :" + e.getMessage());
		}
		
		
		
	}

	@Override
	public void updateCompetence(Competence competence) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(competence);
			session.getTransaction().commit();
			//session.close();
			System.out.print("competence mise a jour");
		} catch (Exception e) {
			System.out.print("erreur update competence :" + e.getMessage());
		}
	}

	@Override
	public void deletCompetence(Competence competence) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(competence);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.err.print(" erreur suppression  competence :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	@Override
	public Competence getCompetence(Integer id) {
		// TODO Auto-generated method stub
		Competence competence = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			competence = (Competence) session.get(Competence.class, id);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur getcompetence " + e.getMessage());
			session.beginTransaction().rollback();
			return competence;
		}
		return competence;
	}

	@Override
	public List<Competence> getListCompetence() {
		// TODO Auto-generated method stub
		
		
		List<Competence> listCompetence = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
			List<Competence> list = session.createQuery("from Competence").list();
			listCompetence = list;
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListCompetence " + e.getMessage());
			session.beginTransaction().rollback();
			return listCompetence;
		}
		return listCompetence;
	}

	@Override
	public void deletCompetenceM(Integer competence) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			
			Competence p = (Competence) session.load(Competence.class, competence);
			session.delete(p);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur deletecompetenceM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
