package service;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.DiplomeInt;
import dao.DiplomeServ;
import model.*;

@ManagedBean(name = "diplomeBean")
@SessionScoped

/*
 * diplomebean est un Bean qui permet de gérer le panneau de diplome
 */
public class DiplomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Diplome diplome;
	DiplomeInt dao;
	private  List<String> type ;
	
	
	/*
	 * getter et setter de type
	 */
	public List<String> getType() {
		return type;
	}

	
	public void setType(List<String> type) {
		this.type = type;
	}
   
	/*
	 * getter et setter de dao
	 */
	public DiplomeInt getDao() {
		return dao;
	}

	public void setDao(DiplomeInt dao) {
		this.dao = dao;
	}

	private List<Diplome> listdiplome;
	
	/*
	 * Constructeur de diplome permet d'instancier un objet diplome
	 */
     public DiplomeBean() {
		// TODO Auto-generated constructor stub
    	 type = new ArrayList<String>();
 		type.add("etatique");
 		type.add("Prive");
		diplome = new Diplome();
	}
     
     /*
 	 * Fonction ajoutEventF(ActionEvent actionEvent) permet de preparer un objet diplome pour le remplir aprés
 	 */
     public void ajoutEventF() {
 		diplome = new Diplome();

 	} 
	
     /*
  	 * Fonction editEvent(Integer idDiplome) permet de recuperer un objet diplome  pour le modifier aprés
  	 */
     public void editEvent(Integer idDiplome) {
 		System.err.print(idDiplome);
 		dao = new DiplomeServ();
 		diplome = dao.getDiplome(idDiplome);
 	}
	
     /*
   	 * Fonction edition(ActionEvent actionEvent) permet de modier l'objet diplome  qu'on a recuperer
   	 */
 	public void edition() {
		dao = new DiplomeServ();
		dao.updateDiplome(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome mise a jour"));
	}

 	/*
   	 * Fonction ajoutF(ActionEvent actionEvent) permet d'ajouter l'objet diplome  qu'on a preparer
   	 */
 	public void ajoutF() {
		dao = new DiplomeServ();
		System.out.println(diplome.getNiveau() );
		System.out.println("ajout de diplome " );
		dao.addDiplome(diplome);
		System.out.println("ajout de diplome " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome ajoute"));
		diplome = new Diplome();
	}
	
 	/*
   	 * Fonction delet(Diplome diplome) permet de supprimer l'objet diplome  qu'on a recuperer
   	 */
 	public void delet(Diplome diplome) {
		dao = new DiplomeServ();
		dao.deletDiplome(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome supprime"));

	}
    
 	/*
   	 * variante de Fonction deletM(Integer diplome) qui permet de supprimer l'objet diplome  qu'on a recuperer
   	 */
 	public void deletM(Integer diplome) {
		dao = new DiplomeServ();
		dao.deletDiplomeM(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome supprime"));

	}
 	
 	/*
   	 *  Fonction  getter de listdiplome qui permet de recuperer la liste de diplomes 
   	 */
 	public List<Diplome> getListdiplome() {
		dao = new DiplomeServ();
		listdiplome = dao.getListDiplome();
		return (List<Diplome>) listdiplome;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
  
	/*
   	 *  Fonction  setter de listdiplome
   	 */
	public void setListdiplome(List<Diplome> listdiplome) {
		this.listdiplome = listdiplome;
	}
 	

}
