package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVai implements Comando{

    private String direzione;
    IOConsole io = new IOConsole();

    @Override
    public void esegui(Partita partita)
    {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Stanza prossimaStanza = null;
    
        if(this.direzione==null)
        {
            io.mostraMessaggio("Dove vuoi andare?");
            return;
        }
        prossimaStanza = stanzaCorrente.getStanzaAdiacente((this.direzione));
        if(prossimaStanza==null)
        {
            io.mostraMessaggio("Direzione inesistente");
            return;
        }

        partita.setStanzaCorrente(prossimaStanza);
        System.out.println(partita.getStanzaCorrente().getNome());
        partita.setCfu(partita.getCfu()-1);
    }

    @Override
    public void setParametro(String parametro)
    {
        this.direzione = parametro;
    }
}