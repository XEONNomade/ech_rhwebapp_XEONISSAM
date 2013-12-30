package model;

// Generated 29 d�c. 2013 02:33:39 by Hibernate Tools 3.4.0.CR1


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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Date generated by hbm2java
 */
@Entity
@Table(name = "date", catalog = "bddsqli")
public class Date implements java.io.Serializable {

	private Integer idDate;
	private java.util.Date date;
	private Set<Affecter> affecters = new HashSet<Affecter>(0);

	public Date() {
	}

	public Date(java.util.Date date) {
		this.date = date;
	}

	public Date(java.util.Date date, Set<Affecter> affecters) {
		this.date = date;
		this.affecters = affecters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_date", unique = true, nullable = false)
	public Integer getIdDate() {
		return this.idDate;
	}

	public void setIdDate(Integer idDate) {
		this.idDate = idDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public java.util.Date getDate() {
		return this.date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "date")
	public Set<Affecter> getAffecters() {
		return this.affecters;
	}

	public void setAffecters(Set<Affecter> affecters) {
		this.affecters = affecters;
	}

}