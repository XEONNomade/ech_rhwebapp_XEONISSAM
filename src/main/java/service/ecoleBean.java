package service;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.ecoleInt;
import dao.ecoleServ;
import model.*;

@ManagedBean(name = "ecoleBean")
@SessionScoped

/*
 * ecolebean est un Bean qui permet de gérer le panneau de ecole
 */
public class ecoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ecole ecole;
	ecoleInt dao;
	
	
	
	/*
	 * getter et setter de type
	 */
	
   
	/*
	 * getter et setter de dao
	 */
	public ecoleInt getDao() {
		return dao;
	}


	public void setDao(ecoleInt dao) {
		this.dao = dao;
	}

	private List<Ecole> listecole;
	
	/*
	 * Constructeur de ecole permet d'instancier un objet ecole
	 */
     public ecoleBean() {
		// TODO Auto-generated constructor stub
    	 
    	
		ecole = new Ecole();
	}
     
     /*
 	 * Fonction ajoutEventF(ActionEvent actionEvent) permet de preparer un objet ecole pour le remplir aprés
 	 */
     public void ajoutEventF() {
 		ecole = new Ecole();

 	} 
	
     /*
  	 * Fonction editEvent(Integer idEcole) permet de recuperer un objet ecole  pour le modifier aprés
  	 */
     public void editEvent(Integer idEcole) {
 		System.err.print(idEcole);
 		dao = new ecoleServ();
 		ecole = dao.getEcole(idEcole);
 	}
	
     /*
   	 * Fonction edition(ActionEvent actionEvent) permet de modier l'objet ecole  qu'on a recuperer
   	 */
 	public void edition() {
 		System.err.println("test");
		dao = new ecoleServ();
		dao.updateEcole(ecole);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("ecole mise a jour"));
	}

 	/*
   	 * Fonction ajoutF(ActionEvent actionEvent) permet d'ajouter l'objet ecole  qu'on a preparer
   	 */
 	public void ajoutF() {
 		System.out.println(ecole.getNomEcole() );
		dao = new ecoleServ();
		System.out.println(ecole.getNomEcole() );
		System.out.println("ajout de ecole " );
		dao.addEcole(ecole);
		System.out.println("ajout de ecole " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("ecole ajoute"));
		ecole = new Ecole();
	}
	
 	/*
   	 * Fonction delet(Ecole ecole) permet de supprimer l'objet ecole  qu'on a recuperer
   	 */
 	public void delet(Ecole ecole) {
		dao = new ecoleServ();
		dao.deletEcole(ecole);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("ecole supprime"));

	}
    
 	/*
   	 * variante de Fonction deletM(Integer ecole) qui permet de supprimer l'objet ecole  qu'on a recuperer
   	 */
 	public void deletM(Integer ecole) {
		dao = new ecoleServ();
		dao.deletEcoleM(ecole);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("ecole supprime"));

	}
 	
 	/*
   	 *  Fonction  getter de listecole qui permet de recuperer la liste de ecoles 
   	 */
 	public List<Ecole> getListecole() {
		dao = new ecoleServ();
		listecole = dao.getListEcole();
		return (List<Ecole>) listecole;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
  
	/*
   	 *  Fonction  setter de listecole
   	 */
	public void setListecole(List<Ecole> listecole) {
		this.listecole = listecole;
	}
 	

}
