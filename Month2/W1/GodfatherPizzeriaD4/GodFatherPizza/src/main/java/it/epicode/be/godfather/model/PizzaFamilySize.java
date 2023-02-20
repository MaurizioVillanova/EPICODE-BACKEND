package it.epicode.be.godfather.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PizzaFamilySize extends Pizza {

	@ManyToOne
	private Pizza pizza;


	public PizzaFamilySize(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public PizzaFamilySize() {}

	@Override
	public String getName() {
		return (this.pizza != null ? (getPizza().getName() + " - ") : "") + "Family size";
	}

	@Override
	public Double getPrice() {
		return (this.pizza != null ? getPizza().getPrice() : 0) + price;
	}

	@Override
	public Double getCalories() {
		return (this.pizza != null ? getPizza().getCalories() : 1) * calories;
	}

	public String getMenuItemLine() {
		return "Family size for Pizza" + " - Calories: x" + this.calories + " - Price: " + price;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
