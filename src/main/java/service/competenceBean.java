package service;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import dao.competenceInt;
import dao.competenceServ;

import model.*;

@ManagedBean(name = "competenceBean")
@SessionScoped
public class competenceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1673083797866023326L;
	/**
	 * 
	 */
	private static final Logger Log = Logger.getLogger(competenceBean.class) ;
	private Competence competence;
	competenceInt dao;
	public competenceInt getDao() {
		return dao;
	}

	public void setDao(competenceInt dao) {
		this.dao = dao;
	}

	private List<Competence> listcompetence;
	
     public competenceBean() {
		// TODO Auto-generated constructor stub
		competence = new Competence();
	}
     
     public void ajoutCompetenceEvent() {
    	 System.out.println("competence créer");
 		competence = new Competence();

 	} 
	
     public void deletMessage(ActionEvent actionEvent) {
 		FacesContext context = FacesContext.getCurrentInstance();
 		context.addMessage(null, new FacesMessage("competence supprime"));
 	}
     public void editCompetenceEvent(Integer idCompetence) {
 		System.err.print(idCompetence);
 		dao = new competenceServ();
 		competence = dao.getCompetence(idCompetence);
 	}
	
 	public void editionCompetence() {
		dao = new competenceServ();
		dao.updateCompetence(competence);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("competence mise a jour"));
	}

 	public void addCompetence() {
 		System.out.println("ajout de competence " );
		dao = new competenceServ();
		System.out.println("ajout de competence " );
		dao.addCompetence(competence);
		System.out.println("ajout de competence " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("competence ajoute"));
		competence = new Competence();
	}
 	
 	
	
 	public void deletCompetence(Competence competence) {
		dao = new competenceServ();
		dao.deletCompetence(competence);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("competence supprime"));

	}

 	public void deletCompetenceId(Integer competence) {
		dao = new competenceServ();
		dao.deletCompetenceM(competence);
		FacesContext context = FacesContext.getCurrentInstance();
		//context.addMessage(null, new FacesMessage("ville supprimï¿½"));

	}
 	
 	public List<Competence> getListcompetence() {
		dao = new competenceServ();
		System.out.println("la liste des competences");
		listcompetence = dao.getListCompetence();
		System.out.println("la liste des competences");
		return (List<Competence>) listcompetence;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public void setListcompetence(List<Competence> listcompetence) {
		this.listcompetence = listcompetence;
	}
 	

}
