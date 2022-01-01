package com.booking.marraigehall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hall {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	private double area;
	@Column(length = 1337)
	private String image;
	private double price;
	private double discount;
	@Column(nullable=true)
	private int owner;
	
	
	public Hall() {
		super();
	}
	
	public Hall(String name, String city, double area, String image, double price, double discount, int owner) {
		super();
		this.name = name;
		this.city = city;
		this.area = area;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public int getOwner_id() {
		return owner;
	}

	public void setOwner_id(int owner_id) {
		this.owner = owner_id;
	}

	@Override
	public String toString() {
		return "Hall [id=" + id + ", name=" + name + ", city=" + city + ", area=" + area + ", image=" + image
				+ ", price=" + price + ", discount=" + discount + ", owner_id=" + owner + "]";
	}


	
	
	
}
