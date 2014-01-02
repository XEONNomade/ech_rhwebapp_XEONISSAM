package service;

import java.io.Serializable;


import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.collaborateurInt;
import dao.collaborateurServ;

//import dao.emettreServ;
//import dao.formateurServ;
import model.*;

@ManagedBean(name = "collaborateurBean")
@SessionScoped
public class collaborateurBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	collaborateurInt dao;
	Integer id;
    String tab[]={"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","September","October","November","Décember"};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public collaborateurInt getDao() {
		return dao;
	}

	public void setDao(collaborateurInt dao) {
		this.dao = dao;
	}

	private Collaborateur collaborateur;
	private List<Collaborateur> listcollaborateur;
	
 

	public collaborateurBean() {
		collaborateur = new Collaborateur();

	}
 



	
	public void ajoutEventF(ActionEvent actionEvent) {
		collaborateur = new Collaborateur();
	}

	public void deletMessage(ActionEvent actionEvent) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("collaborateur supprimé"));
	}

	public void editEvent(Integer idCollaborateur) {
		System.err.print(idCollaborateur);
		dao = new collaborateurServ();
		collaborateur = dao.getcollaborateur(idCollaborateur);
	}
	

	public Collaborateur getCollaborateurById(Integer idCollaborateur) {
		dao = new collaborateurServ();
		collaborateur = dao.getcollaborateur(idCollaborateur);
		return collaborateur;
	}

	
	public void edition(ActionEvent actionEvent) {
		dao = new collaborateurServ();
		dao.updatecollaborateur(collaborateur);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("collaborateur mise a jour"));
	}

	
	public void ajoutF(ActionEvent actionEvent) {
		dao = new collaborateurServ();
		String abriviation=new String("");
		abriviation=abriviation+collaborateur.getPrenomCollaborateur().substring(0,1)+collaborateur.getNomCollaborateur().substring(0,2);
		collaborateur.setAbreviCollaborateur(abriviation);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(collaborateur.getDateEmbauche());
		int jour = calendar.get(calendar.DAY_OF_MONTH);
		if(collaborateur.getDateParticipation()==null)
			collaborateur.setParticipationSeminIntegr(false);
		else
			collaborateur.setParticipationSeminIntegr(true);
		System.out.println("jour  : "+jour);
		if(jour<15)
			collaborateur.setMoisBap(tab[collaborateur.getDateEmbauche().getMonth()]);
		else{
			if(collaborateur.getDateEmbauche().getMonth()==11)
			collaborateur.setMoisBap(tab[0]);
			else
		    collaborateur.setMoisBap(tab[collaborateur.getDateEmbauche().getMonth()+1]);
		}
			
			if(collaborateur.getBusinessUnit().length()<5){
			dao.addcollaborateur(collaborateur);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("collaborateur ajoute"));
			 collaborateur=new Collaborateur();
			}
			else{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Attention le Business unit ne doit pas depasser 4 caractéres!!!"));
				collaborateur=new Collaborateur();
			}
	}
	

	public String transform(Date d){
		
		return DateFormat.getDateInstance( DateFormat.MEDIUM ).format( d );
	}
	
	public String registre(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
			return "collaborateurlisteadmin";
		}
		

	public void delet(Collaborateur collaborateur) {
		dao = new collaborateurServ();
		dao.deletcollaborateur(collaborateur);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("collaborateur supprime"));

	}

	public void deletM(Integer collaborateur) {
		dao = new collaborateurServ();
		dao.deletcollaborateurM(collaborateur);
		FacesContext context = FacesContext.getCurrentInstance();
		 context.addMessage(null, new FacesMessage("collaborateur supprime"));

	}

	public List<Collaborateur> getListcollaborateur() {
		dao = new collaborateurServ();
		System.out.println("la liste des collaborateurs");
		listcollaborateur = dao.getListcollaborateur();
		System.out.println("la liste des collaborateurs");
		return (List<Collaborateur>) listcollaborateur;
	}
	
	public void setListcollaborateur(List<Collaborateur> listcollaborateur) {
		this.listcollaborateur = listcollaborateur;
	}

	public Collaborateur getcollaborateur() {
		if (this.collaborateur == null) {
			this.collaborateur = new Collaborateur();
		}

		return collaborateur;
	}

	public void setcollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
}