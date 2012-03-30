package de.akquinet.jpabuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@Entity
@GeneratePojoBuilder(intoPackage = "de.akquinet.jpabuilder")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	// @OneToOne(optional = false, cascade = CascadeType.ALL)
	// private Profile profile;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public long getId() {
		return id;
	}
}