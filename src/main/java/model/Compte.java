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

/**
 * Compte generated by hbm2java
 */
@Entity
@Table(name = "compte", catalog = "bddsqli")
public class Compte implements java.io.Serializable {

	private Integer idCompte;
	private String login;
	private String pword;
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	private Set<ManagerRh> managerRhs = new HashSet<ManagerRh>(0);

	public Compte() {
	}

	public Compte(String login, String pword) {
		this.login = login;
		this.pword = pword;
	}

	public Compte(String login, String pword, Set<Responsable> responsables,
			Set<ManagerRh> managerRhs) {
		this.login = login;
		this.pword = pword;
		this.responsables = responsables;
		this.managerRhs = managerRhs;
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
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte")
	public Set<ManagerRh> getManagerRhs() {
		return this.managerRhs;
	}

	public void setManagerRhs(Set<ManagerRh> managerRhs) {
		this.managerRhs = managerRhs;
	}

}
