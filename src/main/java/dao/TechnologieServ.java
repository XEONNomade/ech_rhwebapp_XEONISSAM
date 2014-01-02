package dao;

import java.io.Serializable;
import java.util.List;

import model.Technolgie;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ResponsableBean;


@Service("technologieInt")
@Transactional
public class TechnologieServ implements TechnologieInt, Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(TechnologieServ.class) ;
	
	/* findById Trouver un objet par son identifiant dans  la base de donnée */
	public Technolgie findById(Integer idTechnolgie,Session ses){
		Technolgie technologie = (Technolgie) ses.load(Object.class,idTechnolgie);
		return technologie;
	}

//	la fonction qui s'occupe d'ajouter des objets technologies a la base de donnée
	@Override
	public void addTechnolgie(Technolgie technologie) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(technologie);
				session.getTransaction().commit();
				Log.info("Technologie bien ajoute");
		} catch (Exception e) {
			Log.error("erreur insertion technologie :" + e.getMessage());
		}
		
		
		
	}

//	la mise a jour d'un objet Technologie dans la base de donnée
	@Override
	public void updateTechnolgie(Technolgie technologie) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(technologie);
			session.getTransaction().commit();
			Log.info("technologie mise a jour");
		} catch (Exception e) {
			Log.info("erreur update technologie :" + e.getMessage());
		}
	}

//	la supprission d'une technologie 
	@Override
	public void deletTechnolgie(Technolgie technologie) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(technologie);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.error(" erreur suppression  technologie :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

//	l'extraction d'une technologie a l'aide de son identifiant
	@Override
	public Technolgie getTechnolgie(Integer id) {
		// TODO Auto-generated method stub
		Technolgie technologie = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			technologie = (Technolgie) session.get(Technolgie.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur gettechnologie " + e.getMessage());
			session.beginTransaction().rollback();
			return technologie;
		}
		return technologie;
	}

	
//	la fonction qui renvoie la liste des technologie de la base de données
	@Override
	public List<Technolgie> getListTechnolgie() {
		// TODO Auto-generated method stub
		
		List<Technolgie> listTechnolgie = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Log.error("debut de select * from Technologie");
			List<Technolgie> list = session.createQuery("from Technolgie").list();
			listTechnolgie = list;
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur getListTechnolgie " + e.getMessage());
			session.beginTransaction().rollback();
			return listTechnolgie;
		}
		return listTechnolgie;
	}

//	la supprission d'une technologie a l'aide de son identifiant
	@Override
	public void deletTechnolgieM(Integer technologie) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			Technolgie p = (Technolgie) session.load(Technolgie.class, technologie);
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			Log.info("erreur deletetechnologieM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
