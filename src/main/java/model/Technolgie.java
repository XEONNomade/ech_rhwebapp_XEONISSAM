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
 * Technolgie generated by hbm2java
 */
@Entity
@Table(name = "technolgie", catalog = "bddsqli")
public class Technolgie implements java.io.Serializable {

	private Integer idTechnolgie;
	private String libelleTechnolgie;
	private Set<Competence> competences = new HashSet<Competence>(0);

	public Technolgie() {
	}

	public Technolgie(String libelleTechnolgie) {
		this.libelleTechnolgie = libelleTechnolgie;
	}

	public Technolgie(String libelleTechnolgie, Set<Competence> competences) {
		this.libelleTechnolgie = libelleTechnolgie;
		this.competences = competences;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_technolgie", unique = true, nullable = false)
	public Integer getIdTechnolgie() {
		return this.idTechnolgie;
	}

	public void setIdTechnolgie(Integer idTechnolgie) {
		this.idTechnolgie = idTechnolgie;
	}

	@Column(name = "libelle_technolgie", nullable = false)
	public String getLibelleTechnolgie() {
		return this.libelleTechnolgie;
	}

	public void setLibelleTechnolgie(String libelleTechnolgie) {
		this.libelleTechnolgie = libelleTechnolgie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "technolgie")
	public Set<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

}
