package kr.ac.hansung.cse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private int id;
	
	@NotEmpty(message="The username must not be null")
	private String username;
	
	@NotEmpty(message="The password must not be null")
	private String password;
	
	@NotEmpty(message="The email must not be null")
	private String email;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(unique=true)
	private ShippingAddress shippingAddress;
	
	private boolean enabled = false;
	
	private String authority;
}
