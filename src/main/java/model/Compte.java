package model;

// Generated Jan 1, 2014 9:04:01 PM by Hibernate Tools 4.0.0

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
 * Compte generated by hbm2java
 */
@Entity
@Table(name = "compte", catalog = "bddsqli", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ref_manager_rh"),
		@UniqueConstraint(columnNames = "ref_responsable") })
public class Compte implements java.io.Serializable {

	private Integer idCompte;
	private ManagerRh managerRh;
	private Responsable responsable;
	private String login;
	private String pword;
	private Set<ManagerRh> managerRhs = new HashSet<ManagerRh>(0);
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	private Set<ManagerRh> managerRhs_1 = new HashSet<ManagerRh>(0);

	public Compte() {
	}

	public Compte(String login, String pword) {
		this.login = login;
		this.pword = pword;
	}

	public Compte(ManagerRh managerRh, Responsable responsable, String login,
			String pword, Set<ManagerRh> managerRhs,
			Set<Responsable> responsables, Set<ManagerRh> managerRhs_1) {
		this.managerRh = managerRh;
		this.responsable = responsable;
		this.login = login;
		this.pword = pword;
		this.managerRhs = managerRhs;
		this.responsables = responsables;
		this.managerRhs_1 = managerRhs_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_compte", unique = true, nullable = false)
	public Integer getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ref_manager_rh", unique = true)
	public ManagerRh getManagerRh() {
		return this.managerRh;
	}

	public void setManagerRh(ManagerRh managerRh) {
		this.managerRh = managerRh;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ref_responsable", unique = true)
	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	@Column(name = "login", nullable = false)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "pword", nullable = false)
	public String getPword() {
		return this.pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte")
	public Set<ManagerRh> getManagerRhs() {
		return this.managerRhs;
	}

	public void setManagerRhs(Set<ManagerRh> managerRhs) {
		this.managerRhs = managerRhs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte")
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte")
	public Set<ManagerRh> getManagerRhs_1() {
		return this.managerRhs_1;
	}

	public void setManagerRhs_1(Set<ManagerRh> managerRhs_1) {
		this.managerRhs_1 = managerRhs_1;
	}

}
