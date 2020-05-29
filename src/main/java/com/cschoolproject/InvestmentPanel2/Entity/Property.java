package com.cschoolproject.InvestmentPanel2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Properties")
public class Property {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "property_id", nullable = false)
	private Long id;
	
	@Column(name = "owner_id", nullable = false)
	private Long owner;
	
	@Column(name = "property_name", nullable = false)
	private String name;
	
	@Column(name = "property_voivodeship", nullable = false)
	private String voivodeship;
	
	@Column(name = "property_city", nullable = false)
	private String city;
	
	@Column(name = "property_address", nullable = false)
	private String address;
	
	@Column(name = "num_of_bedrooms", nullable = false)
	private int bedrooms;
	
	@Column(name = "num_of_bathrooms", nullable = false)
	private int bathrooms;
	
	@Column(name = "year_built", nullable = false)
	private int yearBuilt;
	
	@Column(name = "property_area", nullable = false)
	private float area;
	
	@Column(name = "purchase_price", nullable = false)
	private int purchasePrice;
	
	@Column(name = "purchase_costs", nullable = false)
	private int purchaseCosts;
	
	

	public Property() {
		super();
	}



	public Property(Long owner, String name, String voivodeship, String city, String address, int bedrooms,
			int bathrooms, int yearBuilt, float area, int purchasePrice, int purchaseCosts) {
		super();
		this.owner = owner;
		this.name = name;
		this.voivodeship = voivodeship;
		this.city = city;
		this.address = address;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.yearBuilt = yearBuilt;
		this.area = area;
		this.purchasePrice = purchasePrice;
		this.purchaseCosts = purchaseCosts;
	}

	public Long getId() {
		return id;
	}

	public Long getOwner() {
		return owner;
	}

	public String getName() {
		return name;
	}

	public String getVoivodeship() {
		return voivodeship;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public float getArea() {
		return area;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getPurchaseCosts() {
		return purchaseCosts;
	}
	

}