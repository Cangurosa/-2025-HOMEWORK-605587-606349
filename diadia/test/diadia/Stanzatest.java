package diadia;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//*I metodi principali sono getNome(), impostaStanzaAdiacente() e addAttrezzo()*//

public class Stanzatest {
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp()
	{
		stanza = new Stanza("Atrio"); //inizializzo una stanza chiamandola Atrio
		attrezzo = new Attrezzo("lanterna", 3); //inizializzo un attrezzo chiamandolo lanterna con peso 3
	}
	
	@Test
	public void testGetNome()
	{
		assertEquals("Atrio", stanza.getNome()); //mi assicuro che Atrio sia il nome della stanza
	}
	
	@Test
	public void testImpostaStanzaAdiacente()
	{
		Stanza biblioteca = new Stanza("Biblioteca"); //creo una nuova stanza (biblioteca)
		stanza.impostaStanzaAdiacente("nord", biblioteca); //la stanza a nord di Atrio è Biblioteca ad esempio
		assertEquals(biblioteca, stanza.getStanzaAdiacente("nord")); //verifico che la biblioteca sia effettivamente la stanza adiacente all'Atrio, procedendo verso nord
	}
	
	@Test
	public void testAddAttrezzo()
	{
		assertTrue(stanza.addAttrezzo(attrezzo)); //assicurati che la stanza acquisisca l'attrezzo
		assertTrue(stanza.hasAttrezzo("lanterna")); //assicurati che sia proprio l'attrezzo impostato all'inizio
	}
}

	