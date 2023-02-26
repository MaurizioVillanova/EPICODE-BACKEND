package it.epicode.gestione_incendi.application.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CentroControllo implements Observer{

		private Map<Integer, Sonda> sonde;
		private CanaleDiComunicazione communicationChannel;

	    private static CentroControllo instance;

	    public CentroControllo(CanaleDiComunicazione communicationChannel) {
	        this.sonde = new HashMap<>();
	        this.communicationChannel = communicationChannel;
	    }
	    
	    private CentroControllo() {
	        sonde = new HashMap<>();
	    }

	    public static CentroControllo getInstance(CanaleDiComunicazione communicationChannel) {
	        if (instance == null) {
	            instance = new CentroControllo(communicationChannel);
	        }
	        return instance;
	    }

	    public void addSonda(Sonda sonda) {
	        sonde.put(sonda.getIdSonda(), sonda);
	        sonda.addObserver(this);
	        if (communicationChannel != null) {
	            sonda.setCanaleComunicazione(communicationChannel);
	        }
	    }

	    public void removeSonda(Sonda sonda) {
	        sonde.remove(sonda.getIdSonda());
	        sonda.deleteObserver(this);
	    }
	    
	    public void sendAlarm(int idSonda, double latitude, double longitude, double smokeLevel) {
	        String messaggio = "ALLARME: sonda numero " + idSonda + " ha rilevato livello di fumo " + smokeLevel;
	        communicationChannel.inviaMessaggio(messaggio);
	    }

	    @Override
	    public void update(Observable o, Object arg) {
	        if (o instanceof Sonda) {
	            Sonda sonda = (Sonda) o;
	            System.out.println("La sonda numero " + sonda.getIdSonda() + " ha un nuovo livello di fumo pari a: " + sonda.getSmokeLevel());
	            sendAlarm(sonda.getIdSonda(), sonda.getLatitude(), sonda.getLongitude(), sonda.getSmokeLevel());
	        }
	    }
	    
}
