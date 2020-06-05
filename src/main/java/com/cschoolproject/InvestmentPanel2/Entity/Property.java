package com.cschoolproject.InvestmentPanel2.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Properties")
public class Property {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "property_id", nullable = false)
	private Long id;
	
	@Column(name = "owner_id", nullable = false)
	private Long owner;
	
	@Column(name = "property_name", nullable = false, unique = true)
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

	@Column(name = "monthly_property_rental", nullable = false)
	private int propertyRental;

	@Column(name = "rental_months", nullable = false)
	private int rentalMonths;

	@Column(name = "renovation_cost", nullable = false)
	private int renovationCost;

	@Column(name = "potential_selling_price", nullable = false)
	private int potentialSell;

// CELEM JEST WYLICZANIE ROCNEGO ZYSKU Z WYNAJMU LUB ZYSKU ZE SPRZEDAŻY


	public Property() {
		super();
	}

	public Property(Long owner, String name, String voivodeship, String city, String address, int bedrooms, int bathrooms, int yearBuilt, float area, int purchasePrice, int purchaseCosts, int propertyRental, int rentalMonths, int renovationCost, int potentialSell) {
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
		this.propertyRental = propertyRental;
		this.rentalMonths = rentalMonths;
		this.renovationCost = renovationCost;
		this.potentialSell = potentialSell;
	}


//	public Property(Long owner, String name, String voivodeship, String city, String address, int bedrooms,
//			int bathrooms, int yearBuilt, float area, int purchasePrice, int purchaseCosts) {
//		super();
//		this.owner = owner;
//		this.name = name;
//		this.voivodeship = voivodeship;
//		this.city = city;
//		this.address = address;
//		this.bedrooms = bedrooms;
//		this.bathrooms = bathrooms;
//		this.yearBuilt = yearBuilt;
//		this.area = area;
//		this.purchasePrice = purchasePrice;
//		this.purchaseCosts = purchaseCosts;
//	}



	public Long getId() {
		return id;
	}


//
//	public Property(String name, Long owner, String voivodeship, String city, String address, int bedrooms, int bathrooms,
//		int yearBuilt, float area, int purchasePrice, int purchaseCosts) {
//	super();
//	this.name = name;
//	this.owner = owner;
//	this.voivodeship = voivodeship;
//	this.city = city;
//	this.address = address;
//	this.bedrooms = bedrooms;
//	this.bathrooms = bathrooms;
//	this.yearBuilt = yearBuilt;
//	this.area = area;
//	this.purchasePrice = purchasePrice;
//	this.purchaseCosts = purchaseCosts;
//}



//	public Long getOwner() {
//		return owner;
//	}
//
//
//
//	public void setOwner(Long owner) {
//		this.owner = owner;
//	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getVoivodeship() {
		return voivodeship;
	}



	public void setVoivodeship(String voivodeship) {
		this.voivodeship = voivodeship;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getBedrooms() {
		return bedrooms;
	}



	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}



	public int getBathrooms() {
		return bathrooms;
	}



	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}



	public int getYearBuilt() {
		return yearBuilt;
	}



	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}



	public float getArea() {
		return area;
	}



	public void setArea(float area) {
		this.area = area;
	}



	public int getPurchasePrice() {
		return purchasePrice;
	}



	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}



	public int getPurchaseCosts() {
		return purchaseCosts;
	}



	public void setPurchaseCosts(int purchaseCosts) {
		this.purchaseCosts = purchaseCosts;
	}
	
	public Long getOwner() {
		return owner;
	}
	
	

	public void setOwner(Long owner) {
		this.owner = owner;
	}
	
	



//	@Override
//	public String toString() {
//		return "Property [id=" + id + ", name=" + name + ", voivodeship=" + voivodeship + ", city=" + city
//				+ ", address=" + address + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", yearBuilt="
//				+ yearBuilt + ", area=" + area + ", purchasePrice=" + purchasePrice + ", purchaseCosts=" + purchaseCosts
//				+ "]";
//	}







	@Override
	public String toString() {
		return "Property [id=" + id + ", owner=" + owner + ", name=" + name + ", voivodeship=" + voivodeship + ", city="
				+ city + ", address=" + address + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", yearBuilt="
				+ yearBuilt + ", area=" + area + ", purchasePrice=" + purchasePrice + ", purchaseCosts=" + purchaseCosts
				+ "]";
	}


	public int getPropertyRental() {
		return propertyRental;
	}

	public void setPropertyRental(int propertyRental) {
		this.propertyRental = propertyRental;
	}

	public int getRentalMonths() {
		return rentalMonths;
	}

	public void setRentalMonths(int rentalMonths) {
		this.rentalMonths = rentalMonths;
	}

	public int getRenovationCost() {
		return renovationCost;
	}

	public void setRenovationCost(int renovationCost) {
		this.renovationCost = renovationCost;
	}

	public int getPotentialSell() {
		return potentialSell;
	}

	public void setPotentialSell(int potentialSell) {
		this.potentialSell = potentialSell;
	}
}