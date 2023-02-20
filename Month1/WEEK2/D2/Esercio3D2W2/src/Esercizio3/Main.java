/**
 * 
 */
package Esercizio3;

import java.util.Scanner;


public class Main {

	public static void main(String[] args){
		
       Esercizio3 c1 = new Esercizio3();
        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci nome");
        String name = input.next();
        System.out.println("Inserisci numero");
        int number = input.nextInt();

        c1.setContatto(name, number);

        System.out.println("Inserisci numero da cercare");
        int numbersq = input.nextInt();
        c1.findContattobynumber(numbersq);




        c1.getRubrica();

        input.close();
    }
}

