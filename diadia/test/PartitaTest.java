import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//*I metodi principali sono getStanzaCorrente(), setStanzaCorrente() e vinta()*//
public class PartitaTest {
	private Partita partita;
	
	@BeforeEach
	public void setUp()
	{
		partita = new Partita(); //creo una nuova partita
	}
	
	@Test
	public void testGetStanzaCorrente()
	{
		assertNotNull(partita.getStanzaCorrente()); //mi assicuro che la stanza corrente non sia nulla
	}
	
	@Test
	public void testSetStanzaCorrente()
	{
		Stanza nuovaStanza = new Stanza("Laboratorio"); //creo una nuova stanza Laboratorio
		partita.setStanzaCorrente(nuovaStanza); //imposto Laboratorio come stanza corrente
		assertEquals(nuovaStanza, partita.getStanzaCorrente()); //verifico che nella stanza corrente ci sia Laboratorio
	}
	
	@Test
	public void testVinta()
	{
		partita.setStanzaCorrente(partita.getStanzaVincente()); //metto nella stanza corrente la stanza vincente
		assertTrue(partita.vinta()); //verifico di aver vinto
	}
}
