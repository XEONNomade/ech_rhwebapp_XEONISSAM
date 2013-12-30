package dao;

import java.io.Serializable;
import java.util.List;

import model.*;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("diplomeInt")
@Transactional
public class diplomeServ implements diplomeInt, Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Diplome findById(Integer idDiplome,Session ses){
		//ses.beginTransaction();
		Diplome diplome = (Diplome) ses.load(Object.class,idDiplome);
		return diplome;
	}

	
	@Override
	public void addDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(diplome);
				session.getTransaction().commit();
				//session.close();
				System.out.print("theme bien ajoute");
		} catch (Exception e) {
			System.err.print("erreur insertion diplome :" + e.getMessage());
		}
		
		
		
	}

	@Override
	public void updateDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(diplome);
			session.getTransaction().commit();
			//session.close();
			System.out.print("diplome mise a jour");
		} catch (Exception e) {
			System.out.print("erreur update diplome :" + e.getMessage());
		}
	}

	@Override
	public void deletDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(diplome);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.err.print(" erreur suppression  diplome :" + e.getMessage());
			session.beginTransaction().rollback();
		}
	}

	@Override
	public Diplome getDiplome(Integer id) {
		// TODO Auto-generated method stub
		Diplome diplome = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			diplome = (Diplome) session.get(Diplome.class, id);
			session.getTransaction().commit();
			//session.close();
		} catch (Exception e) {
			System.out.print("erreur getdiplome " + e.getMessage());
			session.beginTransaction().rollback();
			return diplome;
		}
		return diplome;
	}

	@Override
	public List<Diplome> getListDiplome() {
		// TODO Auto-generated method stub
		
		
		List<Diplome> listDiplome = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			System.err.println("debut de select * from");
			List<Diplome> list = session.createQuery("from Diplome").list();
			listDiplome = list;
			for (Diplome diplome : list) {
				System.out.println(diplome.getNiveau()+ "  "
						+ diplome.getIdDiplome()+"  ");
			}
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur getListDiplome " + e.getMessage());
			session.beginTransaction().rollback();
			return listDiplome;
		}
		return listDiplome;
	}

	@Override
	public void deletDiplomeM(Integer diplome) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			
			Diplome p = (Diplome) session.load(Diplome.class, diplome);
			session.delete(p);
			session.getTransaction().commit();
			// session.close();
		} catch (Exception e) {
			System.out.print("erreur deletediplomeM " + e.getMessage());
			session.beginTransaction().rollback();
		}
	}
	

}
