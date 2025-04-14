import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.Comando.*;

public class ComandoPrenditest {
    private Partita partita;
    private Attrezzo attrezzo;
    private Comando comando;

    @BeforeEach
    public void setUp()
    {
        partita = new Partita();
        attrezzo = new Attrezzo("mazza", 4);
        comando = new ComandoPrendi();
    }

    @Test
    public void testEsegui()
    {
        partita.getStanzaCorrente().addAttrezzo(attrezzo);
        comando.setParametro("mazza");
        comando.esegui(partita);
        assertFalse(partita.getBorsa().hasAttrezzo("mazza"));
    }
}
