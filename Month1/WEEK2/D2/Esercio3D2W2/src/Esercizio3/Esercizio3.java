
package Esercizio3;
import java.util.*;


public class Esercizio3 {
	  HashMap<String, Integer> rubrica = new HashMap<>();

	    public void setContatto(String name, int number){

	        rubrica.put(name, number);
	    }

	    public void remContatto(String name){

	        rubrica.remove(name);

	    }

	    public void findContattobynumber(int number){

	        if (rubrica.containsValue(number)){
	            Set entrySet = rubrica.entrySet();
	            Iterator it = entrySet.iterator();
	            while(it.hasNext()){
	                Map.Entry contatto = (Map.Entry)it.next();

	                if (contatto.getValue().equals(number)){
	                    System.out.println("Nome= " + contatto.getKey());
	                }

	            }
	        }else{
	            System.out.println("nessun contatto trovato");
	        }

	    }

	    public void findContattobynume(String name){
	        System.out.println( rubrica.get(name));

	    }

	    public void getRubrica(){
	        Set entrySet = rubrica.entrySet();
	        Iterator it = entrySet.iterator();
	        while(it.hasNext()){
	            Map.Entry contatto = (Map.Entry)it.next();

	            System.out.println("Nome= " + contatto.getKey() + " Numero= " + contatto.getValue());

	        }
	    }


	}
