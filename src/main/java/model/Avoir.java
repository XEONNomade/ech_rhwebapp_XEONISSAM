package model;

// Generated Jan 2, 2014 6:19:27 PM by Hibernate Tools 4.0.0

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
 * Avoir generated by hbm2java
 */
@Entity
@Table(name = "avoir", catalog = "bddsqli")
public class Avoir implements java.io.Serializable {

	private AvoirId id;
	private Diplome diplome;
	private Ecole ecole;
	private Collaborateur collaborateur;
	private String promotion;

	public Avoir() {
	}

	public Avoir(AvoirId id, Diplome diplome, Ecole ecole,
			Collaborateur collaborateur, String promotion) {
		this.id = id;
		this.diplome = diplome;
		this.ecole = ecole;
		this.collaborateur = collaborateur;
		this.promotion = promotion;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idEcole", column = @Column(name = "id_ecole", nullable = false)),
			@AttributeOverride(name = "matricule", column = @Column(name = "matricule", nullable = false)),
			@AttributeOverride(name = "idDiplome", column = @Column(name = "id_diplome", nullable = false)) })
	public AvoirId getId() {
		return this.id;
	}

	public void setId(AvoirId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_diplome", nullable = false, insertable = false, updatable = false)
	public Diplome getDiplome() {
		return this.diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ecole", nullable = false, insertable = false, updatable = false)
	public Ecole getEcole() {
		return this.ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricule", nullable = false, insertable = false, updatable = false)
	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	@Column(name = "promotion", nullable = false, length = 55)
	public String getPromotion() {
		return this.promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

}
