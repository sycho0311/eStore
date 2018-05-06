package kr.ac.hansung.cse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ShippingAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shippingAddressId")
	private int id;
	
	private String address;
	
	private String country;
	
	private String zipCode;
	
}
