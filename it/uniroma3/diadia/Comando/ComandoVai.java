package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVai implements Comando{

    private String direzione;
    private IO io;
    private final static String NOME = "vai";

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

    @Override
    public String getNome()
    {
        return NOME;
    }

    @Override
    public void setIO(IO io)
    {
        this.io = io;
    }

    @Override
    public String getParametro()
    {
        return direzione;
    }
}