package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.epicode.gestione_incendi.application.models.CanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.MioCanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.Sonda;


public class SondaTest {

	private Sonda sonda;
    CanaleDiComunicazione canale = (CanaleDiComunicazione) new MioCanaleDiComunicazione();

	@Before
	public void setUp() {
		sonda = new Sonda(1, 41.0, 12.0, 0.0, canale);
	}

	@Test
	public void testSetSmokeLevel() {

		sonda.setSmokeLevel(3.0);
		assertEquals(3.0, sonda.getSmokeLevel(), 0.0);

		sonda.setSmokeLevel(7.0);
		assertEquals(7.0, sonda.getSmokeLevel(), 0.0);
	}
}
