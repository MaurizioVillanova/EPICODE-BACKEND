package it.rinomarra.chainofresponsibility;

public abstract class Ufficiale {

	Ufficiale superiore = null;

	public void setSuperiore(Ufficiale ufficiale) {
		this.superiore = ufficiale;
	}

	public abstract void check(int stipendio);

}