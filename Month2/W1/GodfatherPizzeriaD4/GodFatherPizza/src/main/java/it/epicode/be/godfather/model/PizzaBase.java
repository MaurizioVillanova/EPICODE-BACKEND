package it.epicode.be.godfather.model;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public abstract class PizzaBase extends Pizza {


	
	public PizzaBase(String name, Double price, Double calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	public PizzaBase() {}

	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	


	

}
