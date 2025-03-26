import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BorsaTest {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Borsa borsa;
	
	@BeforeEach
	public void setUp()
	{
		borsa = new Borsa();
	}
	
	@Test
	public void testGetPesoMax()
	{
		assertEquals(10, borsa.getPesoMax());
	}
	
	@Test
	public void testIsEmpty()
	{
		assertTrue(borsa.isEmpty());
	}
}
