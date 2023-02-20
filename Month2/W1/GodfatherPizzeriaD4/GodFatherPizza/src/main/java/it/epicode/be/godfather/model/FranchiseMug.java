package it.epicode.be.godfather.model;

import javax.persistence.Entity;

@Entity
public class FranchiseMug extends Franchise {
	
	
	public FranchiseMug() {
		super("Mug",4.99);
	}
}
