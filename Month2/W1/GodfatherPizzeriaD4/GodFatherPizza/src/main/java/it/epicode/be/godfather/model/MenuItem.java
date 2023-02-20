package it.epicode.be.godfather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public abstract class MenuItem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuitem_seq")
    @SequenceGenerator(name = "menuitem_seq", sequenceName = "menuitem_seq")
    protected Long id;
    

    protected String name;
    protected Double price;
    protected Double calories;
    
	public String getMenuItemLine() {
		return name + " - Calories: x" + this.calories + " - Price: " + price;
	}

}