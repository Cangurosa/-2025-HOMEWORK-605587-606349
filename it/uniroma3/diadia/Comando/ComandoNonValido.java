package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

    private IO io;
    private final static String NOME = "non valido";

    @Override
    public void esegui(Partita partita)
    {
        io.mostraMessaggio("Comando non valido");
    }

    @Override
    public void setParametro(String comandoInvalido)
    {
        // Da implementare
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
