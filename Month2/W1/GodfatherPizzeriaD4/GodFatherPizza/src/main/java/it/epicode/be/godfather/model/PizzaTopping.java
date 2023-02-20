package it.epicode.be.godfather.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode
public class PizzaTopping extends Pizza {
	
	
	public PizzaTopping(Pizza pizza, String name, Double price, Double calories) {
		this.pizza = pizza;
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	public PizzaTopping() {}

	@ManyToOne
	private Pizza pizza;
	
	@Override
	public String getName() {
		return (this.getPizza() != null ? (getPizza().getName() + " - ") : "") + this.name;
	}

	@Override
	public Double getPrice() {
		return (this.getPizza() != null ? getPizza().getPrice() : 0) + price;
	}

	@Override
	public Double getCalories() {
		return (this.getPizza() != null ? getPizza().getCalories() : 0) + calories;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}
	


	
		public Pizza getPizza() {
		return pizza;
	}

}
