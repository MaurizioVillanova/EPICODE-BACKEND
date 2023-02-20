package it.epicode.exercises.week3.giorno3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio2 implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Esercizio2.class);

	private int[] arrayElementi;
	private int indiceIniziale;
	private int numeroElementi;
	private List<Integer> listaRisultati;

	public Esercizio2(int[] arrayElementi, int indiceIniziale, int numeroElementi, List<Integer> listaRisultati) {
		super();
		this.arrayElementi = arrayElementi;
		this.indiceIniziale = indiceIniziale;
		this.numeroElementi = numeroElementi;
		this.listaRisultati = listaRisultati;
	}

	@Override
	public void run() {
		int sommaParziale = 0;
		for (int i = indiceIniziale; i < indiceIniziale + numeroElementi; i++) {
			sommaParziale += arrayElementi[i];
		}
		listaRisultati.add(sommaParziale);
	}

	public static void main(String[] args) {

		int[] elementiDaSommare = inizializzaArrayDaSommare(3000);
		
		int sommasequenziale = 0;
		for (int i = 0;i<elementiDaSommare.length;i++) {
			sommasequenziale += elementiDaSommare[i];
		}
		logger.info("Totale calcolo sequenziale: " + sommasequenziale);

		List<Integer> listaRisultati = new ArrayList<Integer>();

		List<Runnable> listaRunnable = Arrays.asList(new Esercizio2(elementiDaSommare, 0, 1000, listaRisultati),
				new Esercizio2(elementiDaSommare, 1000, 1000, listaRisultati),
				new Esercizio2(elementiDaSommare, 2000, 1000, listaRisultati));

		List<Thread> listaThread = new ArrayList<Thread>();
		for (Runnable curRun : listaRunnable) {
			Thread curThread = new Thread(curRun);
			listaThread.add(curThread);
		}

		for (Thread curThread : listaThread) {
			curThread.start();
		}

		try {
			for (Thread curThread : listaThread) {
				curThread.join();
			}

			logger.info("***** Esecuzione parallela terminata - calcolo totale");

			int totale = 0;
			for (Integer curParziale : listaRisultati) {
				totale += curParziale;
			}
			logger.info("Totale calcolo parallelo: " + totale);
			;
		} catch (InterruptedException e) {
			logger.error("Errore", e);
		}
	}

	private static int[] inizializzaArrayDaSommare(int size) {
		Random randomGenerator = new Random();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomGenerator.nextInt(100);
		}
		return result;

	}

}
