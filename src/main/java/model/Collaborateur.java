package model;

// Generated Jan 2, 2014 6:19:27 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Collaborateur generated by hbm2java
 */
@Entity
@Table(name = "collaborateur", catalog = "bddsqli")
public class Collaborateur implements java.io.Serializable {

	private int matricule;
	private ManagerRh managerRhByManagerRhActuel;
	private ManagerRh managerRhByAncienManagerRh;
	private String site;
	private String nomCollaborateur;
	private String prenomCollaborateur;
	private String abreviCollaborateur;
	private String businessUnit;
	private String sexe;
	private Date dateEmbauche;
	private String moisBap;
	private Date dateDepart;
	private Boolean ancienCollab;
	private Boolean participationSeminIntegr;
	private Date dateParticipation;
	private String email;
	private Set<Affecter> affecters = new HashSet<Affecter>(0);
	private Set<Avoir> avoirs = new HashSet<Avoir>(0);
	private Set<Metriser> metrisers = new HashSet<Metriser>(0);
	private ManagerRh managerRh;

	public Collaborateur() {
	}

	public Collaborateur(int matricule, String site, String nomCollaborateur,
			String prenomCollaborateur, String abreviCollaborateur,
			String businessUnit, String sexe, Date dateEmbauche, String email) {
		this.matricule = matricule;
		this.site = site;
		this.nomCollaborateur = nomCollaborateur;
		this.prenomCollaborateur = prenomCollaborateur;
		this.abreviCollaborateur = abreviCollaborateur;
		this.businessUnit = businessUnit;
		this.sexe = sexe;
		this.dateEmbauche = dateEmbauche;
		this.email = email;
	}

	public Collaborateur(int matricule, ManagerRh managerRhByManagerRhActuel,
			ManagerRh managerRhByAncienManagerRh, String site,
			String nomCollaborateur, String prenomCollaborateur,
			String abreviCollaborateur, String businessUnit, String sexe,
			Date dateEmbauche, String moisBap, Date dateDepart,
			Boolean ancienCollab, Boolean participationSeminIntegr,
			Date dateParticipation, String email, Set<Affecter> affecters,
			Set<Avoir> avoirs, Set<Metriser> metrisers, ManagerRh managerRh) {
		this.matricule = matricule;
		this.managerRhByManagerRhActuel = managerRhByManagerRhActuel;
		this.managerRhByAncienManagerRh = managerRhByAncienManagerRh;
		this.site = site;
		this.nomCollaborateur = nomCollaborateur;
		this.prenomCollaborateur = prenomCollaborateur;
		this.abreviCollaborateur = abreviCollaborateur;
		this.businessUnit = businessUnit;
		this.sexe = sexe;
		this.dateEmbauche = dateEmbauche;
		this.moisBap = moisBap;
		this.dateDepart = dateDepart;
		this.ancienCollab = ancienCollab;
		this.participationSeminIntegr = participationSeminIntegr;
		this.dateParticipation = dateParticipation;
		this.email = email;
		this.affecters = affecters;
		this.avoirs = avoirs;
		this.metrisers = metrisers;
		this.managerRh = managerRh;
	}

	@Id
	@Column(name = "matricule", unique = true, nullable = false)
	public int getMatricule() {
		return this.matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_rh_actuel")
	public ManagerRh getManagerRhByManagerRhActuel() {
		return this.managerRhByManagerRhActuel;
	}

	public void setManagerRhByManagerRhActuel(
			ManagerRh managerRhByManagerRhActuel) {
		this.managerRhByManagerRhActuel = managerRhByManagerRhActuel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ancien_manager_rh")
	public ManagerRh getManagerRhByAncienManagerRh() {
		return this.managerRhByAncienManagerRh;
	}

	public void setManagerRhByAncienManagerRh(
			ManagerRh managerRhByAncienManagerRh) {
		this.managerRhByAncienManagerRh = managerRhByAncienManagerRh;
	}

	@Column(name = "site", nullable = false)
	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "nom_collaborateur", nullable = false)
	public String getNomCollaborateur() {
		return this.nomCollaborateur;
	}

	public void setNomCollaborateur(String nomCollaborateur) {
		this.nomCollaborateur = nomCollaborateur;
	}

	@Column(name = "prenom_collaborateur", nullable = false)
	public String getPrenomCollaborateur() {
		return this.prenomCollaborateur;
	}

	public void setPrenomCollaborateur(String prenomCollaborateur) {
		this.prenomCollaborateur = prenomCollaborateur;
	}

	@Column(name = "abrevi_collaborateur", nullable = false, length = 3)
	public String getAbreviCollaborateur() {
		return this.abreviCollaborateur;
	}

	public void setAbreviCollaborateur(String abreviCollaborateur) {
		this.abreviCollaborateur = abreviCollaborateur;
	}

	@Column(name = "business_unit", nullable = false, length = 4)
	public String getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	@Column(name = "Sexe", nullable = false, length = 1)
	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_embauche", nullable = false, length = 10)
	public Date getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Column(name = "mois_bap")
	public String getMoisBap() {
		return this.moisBap;
	}

	public void setMoisBap(String moisBap) {
		this.moisBap = moisBap;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_depart", length = 10)
	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Column(name = "ancien_collab")
	public Boolean getAncienCollab() {
		return this.ancienCollab;
	}

	public void setAncienCollab(Boolean ancienCollab) {
		this.ancienCollab = ancienCollab;
	}

	@Column(name = "participation_semin__integr")
	public Boolean getParticipationSeminIntegr() {
		return this.participationSeminIntegr;
	}

	public void setParticipationSeminIntegr(Boolean participationSeminIntegr) {
		this.participationSeminIntegr = participationSeminIntegr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_participation", length = 10)
	public Date getDateParticipation() {
		return this.dateParticipation;
	}

	public void setDateParticipation(Date dateParticipation) {
		this.dateParticipation = dateParticipation;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collaborateur")
	public Set<Affecter> getAffecters() {
		return this.affecters;
	}

	public void setAffecters(Set<Affecter> affecters) {
		this.affecters = affecters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collaborateur")
	public Set<Avoir> getAvoirs() {
		return this.avoirs;
	}

	public void setAvoirs(Set<Avoir> avoirs) {
		this.avoirs = avoirs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collaborateur")
	public Set<Metriser> getMetrisers() {
		return this.metrisers;
	}

	public void setMetrisers(Set<Metriser> metrisers) {
		this.metrisers = metrisers;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "collaborateur")
	public ManagerRh getManagerRh() {
		return this.managerRh;
	}

	public void setManagerRh(ManagerRh managerRh) {
		this.managerRh = managerRh;
	}

}
