package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
    private IO io;
    private final static String NOME = "fine";
    public final static String MESSAGGIO_FINE = "Grazie per aver giocato";

    @Override
    public void esegui(Partita partita)
    {
        partita.setFinita();
        io.mostraMessaggio(MESSAGGIO_FINE);
    }

    @Override
    public void setParametro(String parametro)
    {
        //da implementare
    }

    @Override
    public String getParametro()
    {
        return null;
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
}
