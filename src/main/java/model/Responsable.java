package model;

// Generated Jan 2, 2014 6:19:27 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Responsable generated by hbm2java
 */
@Entity
@Table(name = "responsable", catalog = "bddsqli", uniqueConstraints = @UniqueConstraint(columnNames = "id_compte"))
public class Responsable implements java.io.Serializable {

	private Integer idResponsable;
	private Compte compte;
	private String role;
	private String nom;
	private String prenom;
	private String email;
	private Set<Compte> comptes = new HashSet<Compte>(0);
	private Set<Compte> comptes_1 = new HashSet<Compte>(0);

	public Responsable() {
	}

	public Responsable(String role, String nom, String prenom, String email) {
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Responsable(Compte compte, String role, String nom, String prenom,
			String email, Set<Compte> comptes, Set<Compte> comptes_1) {
		this.compte = compte;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.comptes = comptes;
		this.comptes_1 = comptes_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_responsable", unique = true, nullable = false)
	public Integer getIdResponsable() {
		return this.idResponsable;
	}

	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_compte", unique = true)
	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Column(name = "role", nullable = false, length = 55)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "Nom", nullable = false)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Prenom", nullable = false)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsable")
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsable")
	public Set<Compte> getComptes_1() {
		return this.comptes_1;
	}

	public void setComptes_1(Set<Compte> comptes_1) {
		this.comptes_1 = comptes_1;
	}

}
