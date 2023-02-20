/**
 * 
 */
package ClassiProgetto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    

		  Scanner scanner = new Scanner ( System.in );


	        Player[] lista = new Player[5];
	        System.out.println ("Inserisci 5 file nella lista" );

	        for (int i = 0; i < lista.length; i++ ) {
	            System.out.println ("Di che tipo è il file numero " + (i + 1) + " ?" );
	            System.out.println ( """
	                    1.VIDEO \r
	                    2.AUDIO \r
	                    3.IMG
	                    """);
	            int tipoFile = Integer.parseInt( scanner.nextLine() );

	            System.out.println ("Dai un nome al tuo file numero " + (i + 1) );
	            String nomeFile = scanner.nextLine ( );

	            if(tipoFile == 1) {
	                System.out.println ("Indica la durata del tuo VIDEO" );
	                int durataVideo = Integer.parseInt ( scanner.nextLine ( ) );
	                lista[i] = new Video ( nomeFile, durataVideo );
	            } else if (tipoFile == 2) {
	                System.out.println ("Indica la durata del tuo AUDIO" );
	                int durataAudio = Integer.parseInt ( scanner.nextLine ( ) );
	                lista[i] = new Audio ( nomeFile, durataAudio );
	            } else if (tipoFile == 3) {
	                lista[i] = new Immagine ( nomeFile );
	            } else {
	                System.out.println ("Scegli un numero valido!!" );
	            }

	        }
	        System.out.println ("Benvenuti ecco la vostra playList" );

	        getPlayList ( lista );

	        System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );

	        int numeroTraccia = Integer.parseInt( scanner.nextLine() );

	        if (numeroTraccia == 0) {
	            System.out.println ("Good bye" );
	            scanner.close ();
	        } else {
	            while (numeroTraccia != -1 ) {

	                switch (numeroTraccia) {
	                    case 0:
	                        System.out.println ( "Good bye!!" );
	                        numeroTraccia = -1;
	                        break;
	                    case 1:
	                        riproduci ( lista[0] );
	                        System.out.println ( "Riprodurre ancora? si o no?" );
	                        String input0 = scanner.nextLine();

	                        if (input0.equals ( "si" )) {
	                            numeroTraccia = 1;
	                        } else {
	                            getPlayList ( lista );
	                            System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );
	                            numeroTraccia = Integer.parseInt( scanner.nextLine() );
	                        }
	                        break;

	                    case 2:
	                        riproduci ( lista[1] );

	                        System.out.println ( "Riprodurre ancora? si o no?" );
	                        String input2 = scanner.nextLine();

	                        if (input2.equals ( "si" )) {
	                            numeroTraccia = 2;
	                        } else {
	                            getPlayList ( lista );
	                            System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );
	                            numeroTraccia = Integer.parseInt( scanner.nextLine() );
	                        }
	                        break;

	                    case 3:
	                        riproduci ( lista[2] );

	                        System.out.println ( "Riprodurre ancora? si o no?" );
	                        String input3 = scanner.nextLine();

	                        if (input3.equals ( "si" )) {
	                            numeroTraccia = 3;
	                        } else {
	                            getPlayList ( lista );
	                            System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );
	                            numeroTraccia = Integer.parseInt( scanner.nextLine() );
	                        }
	                        break;

	                    case 4:
	                        riproduci ( lista[3] );

	                        System.out.println ( "Riprodurre ancora? si o no?" );
	                        String input4 = scanner.nextLine();

	                        if (input4.equals ( "si" )) {
	                            numeroTraccia = 4;
	                        } else {
	                            getPlayList ( lista );
	                            System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );
	                            numeroTraccia = Integer.parseInt( scanner.nextLine() );
	                        }
	                        break;

	                    case 5:
	                        riproduci ( lista[4] );

	                        System.out.println ( "Riprodurre ancora? si o no?" );
	                        String input5 = scanner.nextLine();

	                        if (input5.equals ( "si" )) {
	                            numeroTraccia = 5;
	                        } else {
	                            getPlayList ( lista );
	                            System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );
	                            numeroTraccia = Integer.parseInt( scanner.nextLine() );
	                        }
	                        break;

	                    default:
	                        System.out.println ( "scegli un numero valido!" );

	                        getPlayList ( lista );
	                        System.out.println ("Scegli il numero da riprodurre, oppure 0 per uscire" );
	                        numeroTraccia = Integer.parseInt( scanner.nextLine() );
	                }

	            }
	        }



	    }

	    static void getPlayList(Player[] playlist) {
	        for ( int i = 0; i < playlist.length; i++ ) {
	            System.out.println ("" + (i + 1) + "." + playlist[i].title );
	        }
	    }

	    static void riproduci(Player file) {
	        if (file.getTipo ().equals ( "IMG" )) {
	            file.show();
	        } else {
	            file.play();
	        }
	    }
	}
