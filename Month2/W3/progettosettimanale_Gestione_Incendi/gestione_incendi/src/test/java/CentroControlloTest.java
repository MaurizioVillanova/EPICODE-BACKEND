package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Observable;

import org.junit.Before;
import org.junit.Test;

import it.epicode.gestione_incendi.application.models.CanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.CentroControllo;
import it.epicode.gestione_incendi.application.models.MioCanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.Sonda;

public class CentroControlloTest {

	private Sonda sonda;
    private CentroControllo centroControllo;
    CanaleDiComunicazione canale = (CanaleDiComunicazione) new MioCanaleDiComunicazione();

    @Before
    public void setUp() {
        sonda = new Sonda(1, 41.736175, 12.470555, 4.0, canale);
        centroControllo = CentroControllo.getInstance(canale);
    }

    @Test
    public void testAddSonda() {
        centroControllo.addSonda(sonda);
        assertTrue(centroControllo.getSonde().containsKey(1));
    }

    @Test
    public void testRemoveSonda() {
        centroControllo.addSonda(sonda);
        centroControllo.removeSonda(sonda);
        assertFalse(centroControllo.getSonde().containsKey(1));
    }

    @Test
    public void testSendAlarm() {
        centroControllo.addSonda(sonda);
        centroControllo.update(sonda, sonda);
        assertEquals("http://host/alarm?idsonda=1&lat=41.736175&lon=12.470555&smokelevel=4.0", "http://host/alarm?idsonda=" + sonda.getIdSonda() + "&lat=" + sonda.getLatitude() + "&lon=" + sonda.getLongitude() + "&smokelevel=" + sonda.getSmokeLevel());
    }
}
