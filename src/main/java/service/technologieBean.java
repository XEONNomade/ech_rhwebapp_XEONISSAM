package service;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import dao.technologieInt;
import dao.technologieServ;

import model.*;

@ManagedBean(name = "technologieBean")
@SessionScoped
public class technologieBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(technologieBean.class) ;
	private Technolgie technologie;
	technologieInt dao;
	public technologieInt getDao() {
		return dao;
	}

	public void setDao(technologieInt dao) {
		this.dao = dao;
	}

	private List<Technolgie> listtechnologie;
	
     public technologieBean() {
		// TODO Auto-generated constructor stub
		technologie = new Technolgie();
	}
     
     public void ajoutEventF(ActionEvent actionEvent) {
 		technologie = new Technolgie();

 	} 
	
     public void deletMessage(ActionEvent actionEvent) {
 		FacesContext context = FacesContext.getCurrentInstance();
 		context.addMessage(null, new FacesMessage("technologie supprime"));
 	}
     public void editEvent(Integer idTechnolgie) {
 		System.err.print(idTechnolgie);
 		dao = new technologieServ();
 		technologie = dao.getTechnolgie(idTechnolgie);
 	}
	
 	public void edition() {
		dao = new technologieServ();
		dao.updateTechnolgie(technologie);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("technologie mise a jour"));
	}

 	public void ajoutetechnologie() {
 		System.out.println("ajout de technologie .... " );
		dao = new technologieServ();
		Log.info(technologie.getLibelleTechnolgie());
		System.out.println("ajout de technologie " );
		dao.addTechnolgie(technologie);
		System.out.println("ajout de technologie " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("technologie ajoute"));
		technologie = new Technolgie();
	}
	
 	public void delet(Technolgie technologie) {
		dao = new technologieServ();
		dao.deletTechnolgie(technologie);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("technologie supprime"));

	}

 	public void deletM(Integer technologie) {
		dao = new technologieServ();
		dao.deletTechnolgieM(technologie);
		FacesContext context = FacesContext.getCurrentInstance();
		//context.addMessage(null, new FacesMessage("ville supprim�"));

	}
 	
 	public List<Technolgie> getListtechnologie() {
		dao = new technologieServ();
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
