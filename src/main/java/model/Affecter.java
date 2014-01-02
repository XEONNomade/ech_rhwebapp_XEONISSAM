package model;

// Generated Jan 1, 2014 9:04:01 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Affecter generated by hbm2java
 */
@Entity
@Table(name = "affecter", catalog = "bddsqli")
public class Affecter implements java.io.Serializable {

	private AffecterId id;
	private Date date;
	private Collaborateur collaborateur;
	private Poste poste;
	private double salaire;

	public Affecter() {
	}

	public Affecter(AffecterId id, Date date, Collaborateur collaborateur,
			Poste poste, double salaire) {
		this.id = id;
		this.date = date;
		this.collaborateur = collaborateur;
		this.poste = poste;
		this.salaire = salaire;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "matricule", column = @Column(name = "matricule", nullable = false)),
			@AttributeOverride(name = "idPoste", column = @Column(name = "id_poste", nullable = false)),
			@AttributeOverride(name = "date", column = @Column(name = "date", nullable = false)) })
	public AffecterId getId() {
		return this.id;
	}

	public void setId(AffecterId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "date", nullable = false, insertable = false, updatable = false)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricule", nullable = false, insertable = false, updatable = false)
	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poste", nullable = false, insertable = false, updatable = false)
	public Poste getPoste() {
		return this.poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	@Column(name = "salaire", nullable = false, precision = 22, scale = 0)
	public double getSalaire() {
		return this.salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

}
