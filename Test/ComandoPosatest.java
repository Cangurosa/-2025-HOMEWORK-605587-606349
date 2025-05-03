import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.Comando.*;

public class ComandoPosatest {
    private Partita partita;
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    private Comando comando;
    private IO io;

    @BeforeEach
    public void setUp()
    {
        partita = new Partita();
        attrezzo1 = new Attrezzo("spada", 2);
        attrezzo2 = new Attrezzo("Randello", 12);
        comando = new ComandoPosa();
        io = new IOConsole();
        comando.setIO(io);
    }

    @Test
    public void testEsegui()
    {
        partita.getBorsa().addAttrezzo(attrezzo1);
        comando.setParametro("spada");
        comando.esegui(partita);
        assertEquals(attrezzo1, partita.getStanzaCorrente().getAttrezzo("spada"));
    }

    @Test 
    public void testBorsaPiena()
    {
        partita.getBorsa().addAttrezzo(attrezzo2);
        comando.setParametro("Randello");
        comando.esegui(partita);

        assertFalse(partita.getStanzaCorrente().hasAttrezzo("Randello"));
    }
}
