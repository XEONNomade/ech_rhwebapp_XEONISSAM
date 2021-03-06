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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Poste generated by hbm2java
 */
@Entity
@Table(name = "poste", catalog = "bddsqli")
public class Poste implements java.io.Serializable {

	private Integer idPoste;
	private String libellePoste;
	private String fposte;
	private Set<Affecter> affecters = new HashSet<Affecter>(0);

	public Poste() {
	}

	public Poste(String libellePoste, String fposte) {
		this.libellePoste = libellePoste;
		this.fposte = fposte;
	}

	public Poste(String libellePoste, String fposte, Set<Affecter> affecters) {
		this.libellePoste = libellePoste;
		this.fposte = fposte;
		this.affecters = affecters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_poste", unique = true, nullable = false)
	public Integer getIdPoste() {
		return this.idPoste;
	}

	public void setIdPoste(Integer idPoste) {
		this.idPoste = idPoste;
	}

	@Column(name = "libelle_poste", nullable = false, length = 3)
	public String getLibellePoste() {
		return this.libellePoste;
	}

	public void setLibellePoste(String libellePoste) {
		this.libellePoste = libellePoste;
	}

	@Column(name = "fposte", nullable = false, length = 4)
	public String getFposte() {
		return this.fposte;
	}

	public void setFposte(String fposte) {
		this.fposte = fposte;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poste")
	public Set<Affecter> getAffecters() {
		return this.affecters;
	}

	public void setAffecters(Set<Affecter> affecters) {
		this.affecters = affecters;
	}

}
