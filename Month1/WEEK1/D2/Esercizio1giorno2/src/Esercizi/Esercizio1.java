/**
 * 
 */
package Esercizi;

/**
 * @author Utente
 *
 */
public class Esercizio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rettangolo rett1 = new Rettangolo(10, 98);
//		rett1.stampaRettangolo();
		Rettangolo rett2 = new Rettangolo(27, 45);
		
		stampaDueRettangoli(rett1, rett2);
	}
	static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		int sommaArea = r1.area + r2.area;
		int sommaPerimetro = r1.perimetro + r2.perimetro;
		
		System.out.println("L'area del primo rettangolo è di " + r1.area + ", del secondo "+ r2.area);
		System.out.println("Il perimetro del primo rettangolo è di " + r1.perimetro + ", del secondo "+ r2.perimetro);
		System.out.println("La somma delle aree è di " + sommaArea);
		System.out.println("La somma dei perimetri è di " + sommaPerimetro);
	}
}
