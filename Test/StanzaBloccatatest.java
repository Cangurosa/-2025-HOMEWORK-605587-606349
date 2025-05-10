import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaBloccatatest {
    private StanzaBloccata cantina;
    private String direzioneBloccata;
    private Attrezzo chiave;
    private Stanza seminterrato;

    @BeforeEach
    public void setUp()
    {
        direzioneBloccata = "est";
        chiave = new Attrezzo("chiave", 0);
        cantina = new StanzaBloccata("cantina", direzioneBloccata, chiave.getNome());
        seminterrato = new Stanza("seminterrato");
    }

    @Test
    public void testgetStanzaAdiacente()
    {
        cantina.impostaStanzaAdiacente(direzioneBloccata, seminterrato);
        assertNotEquals(cantina.getStanzaAdiacente(direzioneBloccata).getDescrizione(), seminterrato.getDescrizione());

        cantina.addAttrezzo(chiave);
        assertEquals(cantina.getStanzaAdiacente(direzioneBloccata).getDescrizione(), seminterrato.getDescrizione());
    }
}
