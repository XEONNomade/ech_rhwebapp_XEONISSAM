package model;

// Generated Jan 2, 2014 6:19:27 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * ManagerRh generated by hbm2java
 */
@Entity
@Table(name = "manager_rh", catalog = "bddsqli", uniqueConstraints = @UniqueConstraint(columnNames = "id_compte"))
public class ManagerRh implements java.io.Serializable {

	private Integer matricule;
	private Collaborateur collaborateur;
	private Compte compte;
	private String statue;
	private Set<Compte> comptes = new HashSet<Compte>(0);
	private Set<Compte> comptes_1 = new HashSet<Compte>(0);
	private Set<Collaborateur> collaborateursForManagerRhActuel = new HashSet<Collaborateur>(
			0);
	private Set<Collaborateur> collaborateursForAncienManagerRh = new HashSet<Collaborateur>(
			0);

	public ManagerRh() {
	}

	public ManagerRh(Collaborateur collaborateur, Compte compte, String statue) {
		this.collaborateur = collaborateur;
		this.compte = compte;
		this.statue = statue;
	}

	public ManagerRh(Collaborateur collaborateur, Compte compte, String statue,
			Set<Compte> comptes, Set<Compte> comptes_1,
			Set<Collaborateur> collaborateursForManagerRhActuel,
			Set<Collaborateur> collaborateursForAncienManagerRh) {
		this.collaborateur = collaborateur;
		this.compte = compte;
		this.statue = statue;
		this.comptes = comptes;
		this.comptes_1 = comptes_1;
		this.collaborateursForManagerRhActuel = collaborateursForManagerRhActuel;
		this.collaborateursForAncienManagerRh = collaborateursForAncienManagerRh;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "collaborateur"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "matricule", unique = true, nullable = false)
	public Integer getMatricule() {
		return this.matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_compte", unique = true, nullable = false)
	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Column(name = "statue", nullable = false, length = 55)
	public String getStatue() {
		return this.statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "managerRh")
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "managerRh")
	public Set<Compte> getComptes_1() {
		return this.comptes_1;
	}

	public void setComptes_1(Set<Compte> comptes_1) {
		this.comptes_1 = comptes_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "managerRhByManagerRhActuel")
	public Set<Collaborateur> getCollaborateursForManagerRhActuel() {
		return this.collaborateursForManagerRhActuel;
	}

	public void setCollaborateursForManagerRhActuel(
			Set<Collaborateur> collaborateursForManagerRhActuel) {
		this.collaborateursForManagerRhActuel = collaborateursForManagerRhActuel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "managerRhByAncienManagerRh")
	public Set<Collaborateur> getCollaborateursForAncienManagerRh() {
		return this.collaborateursForAncienManagerRh;
	}

	public void setCollaborateursForAncienManagerRh(
			Set<Collaborateur> collaborateursForAncienManagerRh) {
		this.collaborateursForAncienManagerRh = collaborateursForAncienManagerRh;
	}

}
