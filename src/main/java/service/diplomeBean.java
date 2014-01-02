package service;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.diplomeInt;
import dao.diplomeServ;
import model.*;

@ManagedBean(name = "diplomeBean")
@SessionScoped

/*
 * diplomebean est un Bean qui permet de gérer le panneau de diplome
 */
public class diplomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Diplome diplome;
	diplomeInt dao;
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
	public diplomeInt getDao() {
		return dao;
	}

	public void setDao(diplomeInt dao) {
		this.dao = dao;
	}

	private List<Diplome> listdiplome;
	
	/*
	 * Constructeur de diplome permet d'instancier un objet diplome
	 */
     public diplomeBean() {
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
 		dao = new diplomeServ();
 		diplome = dao.getDiplome(idDiplome);
 	}
	
     /*
   	 * Fonction edition(ActionEvent actionEvent) permet de modier l'objet diplome  qu'on a recuperer
   	 */
 	public void edition() {
		dao = new diplomeServ();
		dao.updateDiplome(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome mise a jour"));
	}

 	/*
   	 * Fonction ajoutF(ActionEvent actionEvent) permet d'ajouter l'objet diplome  qu'on a preparer
   	 */
 	public void ajoutF() {
		dao = new diplomeServ();
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
		dao = new diplomeServ();
		dao.deletDiplome(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome supprime"));

	}
    
 	/*
   	 * variante de Fonction deletM(Integer diplome) qui permet de supprimer l'objet diplome  qu'on a recuperer
   	 */
 	public void deletM(Integer diplome) {
		dao = new diplomeServ();
		dao.deletDiplomeM(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome supprime"));

	}
 	
 	/*
   	 *  Fonction  getter de listdiplome qui permet de recuperer la liste de diplomes 
   	 */
 	public List<Diplome> getListdiplome() {
		dao = new diplomeServ();
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
