package it.epicode.exercises.week3.giorno3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio1 implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Esercizio1.class);

	private String simbolo;

	public Esercizio1(String simbolo) {
		this.simbolo = simbolo;
	}

	public static void main(String[] args) {

		Esercizio1 runnable1 = new Esercizio1("#");
		Esercizio1 runnable2 = new Esercizio1("*");

		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);

		thread1.start();
		thread2.start();

	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(simbolo);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			logger.error("Errore", e);
		}

	}

}
