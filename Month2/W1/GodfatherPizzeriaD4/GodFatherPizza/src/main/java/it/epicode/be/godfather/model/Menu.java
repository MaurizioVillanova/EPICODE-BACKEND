package it.epicode.be.godfather.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Menu {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "menu_seq")
    protected Long id;
	
    @ManyToMany
	private final List<Pizza> menuPizza = new ArrayList<>();
    
    @ManyToMany
	private final List<PizzaTopping> menuTopping = new ArrayList<>();
    
    @ManyToMany
	private final List<Drink> menuDrink = new ArrayList<>();
    
    @ManyToMany
	private final List<Franchise> menuFranchise = new ArrayList<>();
	
	


}
