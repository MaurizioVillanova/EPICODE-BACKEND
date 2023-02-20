package it.epicode.be.godfather.model;

import javax.persistence.Entity;

@Entity
public class Franchise extends MenuItem {
	
	
	public Franchise(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getMenuItemLine() {
		return this.getName() + " - price: " + getPrice();	
	}


}
