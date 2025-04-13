package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoAiuto implements Comando{
    public static final String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
    private IO io;
    private final static String NOME = "aiuto";

    @Override
    public void esegui(Partita partita)
    {
        for(int i=0; i<ELENCO_COMANDI.length; i++)
        {
            io.mostraMessaggio(ELENCO_COMANDI[i] + " ");
            io.mostraMessaggio("");
        }
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
