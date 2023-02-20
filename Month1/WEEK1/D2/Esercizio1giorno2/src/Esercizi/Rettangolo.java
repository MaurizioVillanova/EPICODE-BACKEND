/**
 * 
 */
package Esercizi;

/**
 * @author Utente
 *
 */
public class Rettangolo {

	int altezza;
	int larghezza;
	int perimetro;
	int area;
	
	Rettangolo(int altezza, int larghezza){
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.perimetro = this.perimetro();
		this.area = this.area();
	};
	int perimetro() {
		return this.altezza + this.larghezza *2;
				
	};
	int area() {
		return this.altezza + this.larghezza;
	};
	void stampaRettangolo() {
		System.out.println("L'area del rettangolo è di "+ this.area+ " , mentre il perimetro è di "+ this.perimetro());
	};
};
