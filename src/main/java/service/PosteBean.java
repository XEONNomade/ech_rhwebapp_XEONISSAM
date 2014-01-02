package service;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.PosteInt;
import dao.PosteServ;
import model.*;

@ManagedBean(name = "posteBean")
@SessionScoped

/*
 * postebean est un Bean qui permet de gérer le panneau de poste
 */
public class PosteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Poste poste;
	PosteInt dao;
	
	
	
	/*
	 * getter et setter de type
	 */
	
   
	/*
	 * getter et setter de dao
	 */
	public PosteInt getDao() {
		return dao;
	}


	public void setDao(PosteInt dao) {
		this.dao = dao;
	}

	private List<Poste> listposte;
	
	/*
	 * Constructeur de poste permet d'instancier un objet poste
	 */
     public PosteBean() {
		// TODO Auto-generated constructor stub
    	 
    	
		poste = new Poste();
	}
     
     /*
 	 * Fonction ajoutEventF(ActionEvent actionEvent) permet de preparer un objet poste pour le remplir aprés
 	 */
     public void ajoutEventF() {
 		poste = new Poste();

 	} 
	
     /*
  	 * Fonction editEvent(Integer idPoste) permet de recuperer un objet poste  pour le modifier aprés
  	 */
     public void editEvent(Integer idPoste) {
 		System.err.print(idPoste);
 		dao = new PosteServ();
 		poste = dao.getPoste(idPoste);
 	}
	
     /*
   	 * Fonction edition(ActionEvent actionEvent) permet de modier l'objet poste  qu'on a recuperer
   	 */
 	public void edition() {
		dao = new PosteServ();
		if((poste.getLibellePoste().length()<4) && (poste.getFposte().length()<5)){
		dao.updatePoste(poste);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("poste mise a jour"));
		}
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Attention poste pas mise a jour!!!"));
			
		}
		
	}

 	/*
   	 * Fonction ajoutF(ActionEvent actionEvent) permet d'ajouter l'objet poste  qu'on a preparer
   	 */
 	public void ajoutF() {
		dao = new PosteServ();
		System.out.println(poste.getLibellePoste() );
		System.out.println("ajout de poste " );
		if((poste.getLibellePoste().length()<4) && (poste.getFposte().length()<5)){
		dao.addPoste(poste);
		System.out.println("ajout de poste " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("poste ajoute"));
		poste = new Poste();
		}
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Attention poste pas mise a jour!!!"));
			poste = new Poste();
		}
		
	}
	
 	/*
   	 * Fonction delet(Poste poste) permet de supprimer l'objet poste  qu'on a recuperer
   	 */
 	public void delet(Poste poste) {
		dao = new PosteServ();
		dao.deletPoste(poste);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("poste supprime"));

	}
    
 	/*
   	 * variante de Fonction deletM(Integer poste) qui permet de supprimer l'objet poste  qu'on a recuperer
   	 */
 	public void deletM(Integer poste) {
		dao = new PosteServ();
		dao.deletPosteM(poste);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("poste supprime"));

	}
 	
 	/*
   	 *  Fonction  getter de listposte qui permet de recuperer la liste de postes 
   	 */
 	public List<Poste> getListposte() {
		dao = new PosteServ();
		listposte = dao.getListPoste();
		return (List<Poste>) listposte;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}
  
	/*
   	 *  Fonction  setter de listposte
   	 */
	public void setListposte(List<Poste> listposte) {
		this.listposte = listposte;
	}
 	

}
