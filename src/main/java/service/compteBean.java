package service;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import dao.compteInt;
import dao.compteServ;
import dao.responsableInt;
import dao.responsableServ;
import model.Compte;
import model.Responsable;

@ManagedBean(name = "compteBean")
@SessionScoped
public class compteBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	responsableInt daop;
	compteInt dao;
	Responsable responsable;
    

	public Compte compte;
    private List<Compte> listcompte;
    
    public compteBean() {
        compte = new Compte();
        System.err.println("comptebean est instancié :");
    }
 
    public void ajoutCompteEvent() {
        compte= new Compte();
        System.out.println("instantiation d'objet compte Opt°1: "+compte.getLogin()+" "+compte.getResponsable().getNom());
    }
    public void deletMessage(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("compte supprimé"));
    }
 
    public void editCompteEvent(Integer id) {
        System.out.print(id);
        dao = new compteServ();
        compte = dao.getCompte(id);
     }
    public void editEventCompteId(Integer id) {
		System.err.print(id);
		compte = new Compte();
		daop = new responsableServ();
		responsable = daop.getResponsable(id);
	}
 
    public void editionCompte() {
    	dao = new compteServ();
        dao.updateCompte(compte);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("compte mise à jour"));
    }
 
    public void ajoutCompte() {
    	System.out.println("Ajout d'objet compte Opt°1: "+compte.getLogin()+" "+ responsable.getNom());
    	System.err.println("appel de  ajoutc");
    	dao = new compteServ();
        dao.addCompte(compte,responsable);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("compte ajouté"));
        compte = new Compte();
    }
 
    public void deletCompte(Compte compte) {
        dao = new compteServ();
        dao.deletcompte(compte);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("compte supprimé"));
         
    }
 
    public List<Compte> getListcompte() {
    	dao = new compteServ();
        System.out.println("la liste des comptes");
        listcompte = dao.listCompte();
        System.out.println("la liste des comptes");
        return (List<Compte>)listcompte;
    }
 
    public void setListCompte(List<Compte> listcompte) {
        this.listcompte = listcompte;
    }
 
    public Compte getCompte() {
        return compte;
    }
 
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
}
