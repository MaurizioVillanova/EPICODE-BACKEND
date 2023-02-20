package it.epicode.be.godfather.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class FoodItem extends MenuItem {
	
	protected Double calories;
	
	
	

}