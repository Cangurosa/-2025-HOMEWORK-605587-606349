import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagicatest{
    private StanzaMagica stanzaMagica;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp()
    {
        stanzaMagica = new StanzaMagica("stanzaMagica", 0);
        attrezzo = new Attrezzo("spada", 2);
    }

    @Test
    public void testmodificAttrezzo()
    {
        assertNotSame(attrezzo.getNome(), stanzaMagica.modificAttrezzo(attrezzo));
        assertNotSame(attrezzo.getPeso(), stanzaMagica.modificAttrezzo(attrezzo));
    }
}