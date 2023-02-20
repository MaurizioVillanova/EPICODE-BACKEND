/**
 * 
 */
package ClassiProgetto;

import Interfaces.Volume;
public class Audio extends Player implements Volume {

	private int volume;
	private int durata;

	  public Audio(String title, int durata) {
	        super(title);
	        this.volume = 15;
	       this.durata = durata;
	        tipo = "AUDIO";
	    }

	public void play() {
		for (int i = 0; i <= durata; i++) {
			String vol = " volume al ";
			String singleVolume = "!";

			for (int l = 0; l <= this.volume; l++) {
				vol = vol + singleVolume;
			}
			System.out.println(title + vol);
		}
	}

	@Override
	public void alzaVolume(int su) {
		if (volume + su < 100) {
			volume = volume + su;
			System.out.println("Volume al: " + volume);
			play();
		} else {
			System.out.println("Volume al massimo! tuz tunz tunz boom boom boom");
		}
	}

	@Override
	public void abbassaVolume(int giù) {
		if (volume - giù > 0) {
			System.out.println("Volume al: " + volume);
			play();
		} else {
			System.out.println("Volume al minimo! tunz boom");
		}
	}

}
