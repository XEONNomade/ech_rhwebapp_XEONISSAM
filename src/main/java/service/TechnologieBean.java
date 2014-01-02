package service;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import dao.TechnologieInt;
import dao.TechnologieServ;

import model.*;

@ManagedBean(name = "technologieBean")
@SessionScoped
public class TechnologieBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(TechnologieBean.class) ;
	private Technolgie technologie;
	TechnologieInt dao;
	public TechnologieInt getDao() {
		return dao;
	}

	public void setDao(TechnologieInt dao) {
		this.dao = dao;
	}

	private List<Technolgie> listtechnologie;
	
     public TechnologieBean() {
		// TODO Auto-generated constructor stub
		technologie = new Technolgie();
	}
     
     public void ajoutTechnologieEvent(ActionEvent actionEvent) {
 		technologie = new Technolgie();

 	} 
	
     public void deletMessage(ActionEvent actionEvent) {
 		FacesContext context = FacesContext.getCurrentInstance();
 		context.addMessage(null, new FacesMessage("technologie supprime"));
 	}
     public void editTechnologieEvent(Integer idTechnolgie) {
 		System.err.print(idTechnolgie);
 		dao = new TechnologieServ();
 		technologie = dao.getTechnolgie(idTechnolgie);
 	}
	
 	public void editionTechnologie() {
		dao = new TechnologieServ();
		dao.updateTechnolgie(technologie);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("technologie mise a jour"));
	}

 	public void ajouteTechnologie() {
 		System.out.println("ajout de technologie .... " );
		dao = new TechnologieServ();
		Log.info(technologie.getLibelleTechnolgie());
		System.out.println("ajout de technologie " );
		dao.addTechnolgie(technologie);
		System.out.println("ajout de technologie " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("technologie ajoute"));
		technologie = new Technolgie();
	}
	
 	public void deletTechnologie(Technolgie technologie) {
		dao = new TechnologieServ();
		dao.deletTechnolgie(technologie);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("technologie supprime"));

	}

 	public void deletTechnologieId(Integer technologie) {
		dao = new TechnologieServ();
		dao.deletTechnolgieM(technologie);
		FacesContext context = FacesContext.getCurrentInstance();
		//context.addMessage(null, new FacesMessage("ville supprim�"));

	}
 	
 	public List<Technolgie> getListtechnologie() {
		dao = new TechnologieServ();
		System.out.println("la liste des technologies");
		listtechnologie = dao.getListTechnolgie();
		System.out.println("la liste des technologies");
		return (List<Technolgie>) listtechnologie;
	}

	public Technolgie getTechnolgie() {
		return technologie;
	}

	public void setTechnolgie(Technolgie technologie) {
		this.technologie = technologie;
	}

	public void setListtechnologie(List<Technolgie> listtechnologie) {
		this.listtechnologie = listtechnologie;
	}
 	

}
