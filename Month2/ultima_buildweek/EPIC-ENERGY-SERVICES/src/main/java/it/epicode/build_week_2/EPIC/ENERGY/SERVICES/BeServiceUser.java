package it.epicode.build_week_2.EPIC.ENERGY.SERVICES;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the be_service_users database table.
 * 
 */
@Entity
@Table(name="be_service_users")
@NamedQuery(name="BeServiceUser.findAll", query="SELECT b FROM BeServiceUser b")
@AllArgsConstructor
public class BeServiceUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=50)
	private String cognome;

	@Column(length=50)
	private String email;

	@Column(length=50)
	private String nome;

	@Column(length=120)
	private String password;

	@Column(length=20)
	private String username;

	//bi-directional many-to-many association to BeServiceRole
	@ManyToMany
	@JoinTable(
		name="be_service_user_roles"
		, joinColumns={
			@JoinColumn(name="user_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id", nullable=false)
			}
		)
	//private List<BeServiceRole> beServiceRoles;
	private Set<BeServiceRole> beServiceRoles = new HashSet<>();
	
	public BeServiceUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<BeServiceRole> getBeServiceRole() {
		return beServiceRoles;
	}

	public void setBeServiceRole(Set<BeServiceRole> beServiceRoles) {
		this.beServiceRoles = beServiceRoles;
	}

	/*public List<BeServiceRole> getBeServiceRoles() {
		return this.beServiceRoles;
	}

	public void setBeServiceRoles(List<BeServiceRole> beServiceRoles) {
		this.beServiceRoles = beServiceRoles;
	}*/
	

}