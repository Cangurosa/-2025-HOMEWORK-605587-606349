import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaBuiatest {
    private StanzaBuia seminterrato;
    private Attrezzo torcia;

    @BeforeEach 
    public void setUp()
    {
        torcia = new Attrezzo("torcia", 3);
        seminterrato = new StanzaBuia("seminterrato", torcia.getNome());
    }

    @Test
    public void testgetDescrizione()
    {
        assertSame(seminterrato.getDescrizione(), "qui c'è buio pesto");
        seminterrato.addAttrezzo(torcia);

        assertNotSame(seminterrato.getDescrizione(), "qui c'è buio pesto");

    }

}
