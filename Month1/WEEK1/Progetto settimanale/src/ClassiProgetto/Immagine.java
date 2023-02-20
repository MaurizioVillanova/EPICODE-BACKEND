/**
 * 
 */
package ClassiProgetto;

import Interfaces.Luminosità;

public class Immagine extends Player implements Luminosità {

	private int luminosità;

	public Immagine(String title) {

		super(title);
		luminosità = 53;
		tipo = "IMG";
	}

	public void show() {
		for (int i = 0; i <= luminosità; i++) {
			String lum = "";
			String singleLum = "!";
			for (int l = 0; l <= this.luminosità; l++) {
				lum = lum + singleLum;
			}
			System.out.println(title + lum);
		}
	}

	@Override
	public void aumentaLuminosità(int più){
		if (luminosità + più < 50) {
			luminosità += più;
			System.out.println("Luminosità al: " + luminosità);
		} else {
			System.out.println("Luminosità al massimo");
		}
	}

	@Override
	public void abbassaLuminosità(int meno) {
		if (luminosità - meno > 0) {
			luminosità -= meno;

			System.out.println("Luminosità al: " + luminosità);
		} else {
			System.out.println("Luminosità al minimo");
		}
	}
}
