package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("competenceInt")
@Transactional
public class CompetenceServ implements CompetenceInt, Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(ResponsableServ.class) ;
//	la fonction qui s'occupe d'ajouter des objets responsables a la base de données
//	la mise a jour d'un objet Responsable dans la base de données
/* findById Trouver un objet par son identifiant dans  la base de donnée */
//	la supprission d'un responsable 
//	l'extraction d'un responsable a l'aide de son identifiant
//	la fonction qui renvoie la liste des responsables de la base de données
//	la supprission d'un responsable a l'aide de son identifiant

	public Competence findById(Integer idCompetence,Session ses){
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
		} catch (Exception e) {
			System.out.print("erreur deletecompetenceM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
