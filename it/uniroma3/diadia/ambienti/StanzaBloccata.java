package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String attrezzoChiave;
    private IO io;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoChiave)
    {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoChiave = attrezzoChiave;
        io = new IOConsole();
    }
    
    @Override
    public Stanza getStanzaAdiacente(String direzione)
    {
        if(direzioneBloccata.equals(direzione))
        {
            if(!this.hasAttrezzo(attrezzoChiave))
            {
                io.mostraMessaggio("direzione bloccata in " + direzione);
                return this;
            }
        }
        return super.getStanzaAdiacente(direzione);
        
    }
    
}
