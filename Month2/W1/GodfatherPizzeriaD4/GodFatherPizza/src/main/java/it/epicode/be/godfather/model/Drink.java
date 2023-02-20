package it.epicode.be.godfather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
public class Drink extends FoodItem {
	
	
	
	public Drink(String name, Double price, Double calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	public Drink() {}
	
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}


}
