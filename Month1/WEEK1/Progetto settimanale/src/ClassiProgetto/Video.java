/**
 * 
 */
package ClassiProgetto;

import Interfaces.Luminosità;
import Interfaces.Volume;

public class Video extends Player implements Luminosità, Volume {

	private int durata;
	private int volume;
	private int lum;

	public Video(String title, int durata) {
		super(title);
		this.durata = durata;
		this.volume = 53;
		lum = 10;
		tipo = "VIDEO";

	}

	public void alzaVolume(int su) {
		if (volume + su < 50) {
			volume = volume + su;
			System.out.println("Volume al: " + volume);
			play();
		} else {
			System.out.println("Volume al massimo! tunz tunz tunz boom boom boom");
		}
	}

	public void abbassaVolume(int giu) {
		if (volume - giu > 0) {
			volume = volume - giu;
			System.out.println("Volume al: " + volume);
			play();
		} else {
			System.out.println("Volume al minimo! tunz  boom");
		}
	}

	public void aumentaLuminosità(int più) {
		if (lum + più < 50) {
			lum += più;
			System.out.println("Luminosità al: " + lum);
		} else {
			System.out.println("Luminosità al massimo!");
		}
	}

	public void abbassaLuminosità(int meno) {
		if (lum - meno > 0) {
			lum -= meno;
			System.out.println("Luminosità al: " + lum);
		} else {
			System.out.println("Luminosità al minimo!");
		}
	}

	public void play() {
		String print = title;
		String currentVol = "";
		String currentLum = "";

		for (int j = 0; j < volume; j++) {
			currentVol = "!";
		}
		for (int k = 0; k < lum; k++) {
			currentLum += "*";
		}
		for (int i = 0; i < durata; i++) {
			System.out.println(title + " " + currentVol + " " + currentLum);
		}
	}
}
