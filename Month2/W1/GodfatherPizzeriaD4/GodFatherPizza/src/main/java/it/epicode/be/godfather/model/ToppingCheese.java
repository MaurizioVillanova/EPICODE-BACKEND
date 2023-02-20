/**
 * 
 */
package it.epicode.be.godfather.model;

import javax.persistence.Entity;

@Entity
public class ToppingCheese extends PizzaTopping {

	public ToppingCheese(Pizza pizza) {
		super(pizza,"Cheese", 0.69, 92d);
	}
	
	public ToppingCheese() {}

}
