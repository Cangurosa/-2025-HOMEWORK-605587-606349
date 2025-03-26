import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GiocatoreTest {
	private Giocatore giocatore;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp()
	{
		giocatore = new Giocatore();
		attrezzo = new Attrezzo("spada", 5);
		
	}
	
	@Test
	public void testGetCfu()
	{
		giocatore.setCfu(5);
		assertEquals(5, giocatore.getCfu());
	}
	
	@Test
	public void testHasAttrezzo()
	{
		giocatore.addAttrezzo(attrezzo);
		assertTrue(giocatore.hasAttrezzo(attrezzo.getNome()));
	}
}
