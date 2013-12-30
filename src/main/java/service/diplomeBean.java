package service;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import dao.diplomeInt;
import dao.diplomeServ;

import model.*;

@ManagedBean(name = "diplomeBean")
@SessionScoped
public class diplomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(diplomeBean.class) ;
	private Diplome diplome;
	diplomeInt dao;
	public diplomeInt getDao() {
		return dao;
	}

	public void setDao(diplomeInt dao) {
		this.dao = dao;
	}

	private List<Diplome> listdiplome;
	
     public diplomeBean() {
		// TODO Auto-generated constructor stub
		diplome = new Diplome();
	}
     
     public void ajoutEventF(ActionEvent actionEvent) {
 		diplome = new Diplome();

 	} 
	
     public void deletMessage(ActionEvent actionEvent) {
 		FacesContext context = FacesContext.getCurrentInstance();
 		context.addMessage(null, new FacesMessage("diplome supprime"));
 	}
     public void editEvent(Integer idDiplome) {
 		System.err.print(idDiplome);
 		dao = new diplomeServ();
 		diplome = dao.getDiplome(idDiplome);
 		System.err.print(diplome.getNiveau());
 	}
	
 	public void edition(ActionEvent actionEvent) {
		dao = new diplomeServ();
		dao.updateDiplome(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome mise a jour"));
	}

 	public void ajoutediplome(ActionEvent actionEvent) {
		dao = new diplomeServ();
		Log.info(diplome.getNiveau() );
		System.out.println("ajout de diplome " );
		dao.addDiplome(diplome);
		System.out.println("ajout de diplome " );
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome ajoute"));
		diplome = new Diplome();
	}
	
 	public void delet(Diplome diplome) {
		dao = new diplomeServ();
		dao.deletDiplome(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("diplome supprime"));

	}

 	public void deletM(Integer diplome) {
		dao = new diplomeServ();
		dao.deletDiplomeM(diplome);
		FacesContext context = FacesContext.getCurrentInstance();
		//context.addMessage(null, new FacesMessage("ville supprim�"));

	}
 	
 	public List<Diplome> getListdiplome() {
		dao = new diplomeServ();
		System.out.println("la liste des diplomes");
		listdiplome = dao.getListDiplome();
		System.out.println("la liste des diplomes");
		return (List<Diplome>) listdiplome;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	public void setListdiplome(List<Diplome> listdiplome) {
		this.listdiplome = listdiplome;
	}
 	

}
