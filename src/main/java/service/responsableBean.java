package service;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;

import dao.responsableInt;
import dao.responsableServ;

import model.*;

@ManagedBean(name = "responsableBean")
@SessionScoped
public class responsableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	responsableInt dao;
	
	@Autowired
	private transient String login;
	@Autowired
	private transient String motp;
	 
	private Responsable responsable;
	private List<Responsable> listresponsable;
	private Responsable[] selectedResponsables;
	public Responsable[] getSelectedResponsables() {
		return selectedResponsables;
	}

	public void setSelectedResponsables(Responsable[] selectedResponsables) {
		this.selectedResponsables = selectedResponsables;
	}

	public responsableBean() {
		responsable = new Responsable();
	}

	public void ajoutResponsableEvent() {
		responsable = new Responsable();
	}

	public void deletMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("responsable supprimé"));
	}

	public void editResponsableEvent(Integer id) {
		System.out.print(id);
		dao = new responsableServ();
		responsable = dao.getResponsable(id);
	}

	public void editionResponsable() {
		dao = new responsableServ();
		dao.updateResponsable(responsable);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("responsable mise à jour"));
	}

	public void ajouteResponsable() {
		dao = new responsableServ();
		dao.addResponsable(responsable);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("responsable ajouté"));
		responsable = new Responsable();
	}

	public void deletResponsable(Responsable responsable) {
		dao = new responsableServ();
		dao.deletresponsable(responsable);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("responsable supprimé"));

	}
	public void deletResponsableId(Integer responsable) {
		dao = new responsableServ();
		dao.deletresponsableId(responsable);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("responsable supprimé"));

	}

	public List<Responsable> getListresponsable() {
		dao = new responsableServ();
		System.out.println("la liste des responsables");
		listresponsable = dao.getListResponsable();
		System.out.println("la liste des responsables");
		return (List<Responsable>) listresponsable;
	}

	public void setListresponsable(List<Responsable> listresponsable) {
		this.listresponsable = listresponsable;
	}

	public Responsable getresponsable() {
		return responsable;
	}

	public void setresponsable(Responsable responsable) {
		this.responsable = responsable;
	}
		
	public responsableInt getDao() {
		return dao;
	}

	public void setDao(responsableInt dao) {
		this.dao = dao;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotp() {
		return motp;
	}

	public void setMotp(String motp) {
		this.motp = motp;
	}
}