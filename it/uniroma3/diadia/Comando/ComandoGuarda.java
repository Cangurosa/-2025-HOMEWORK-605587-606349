package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.IO;

public class ComandoGuarda implements Comando{
    private IO io;
    private final static String NOME = "guarda";

    @Override
    public void esegui(Partita partita)
    {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        io.mostraMessaggio(stanzaCorrente.getDescrizione());

        io.mostraMessaggio("Borsa: "+ partita.getBorsa());
        io.mostraMessaggio("CFU rimanenti: "+ partita.getCfu());
    }  

    @Override
    public void setParametro(String parametro)
    {
        //da implementare
    }

    @Override
    public void setIO(IO io)
    {
        this.io = io;
    }

    @Override
    public String getNome()
    {
        return NOME;
    }

    @Override
    public String getParametro()
    {
        return null;
    }
}
