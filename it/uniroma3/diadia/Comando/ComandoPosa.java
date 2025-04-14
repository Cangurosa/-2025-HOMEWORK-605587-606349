package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPosa implements Comando{
    private IO io;
    private String nomeAttrezzo;
    private final static String NOME = "posa";

    @Override
    public void esegui(Partita partita)
    {
        Attrezzo a = partita.getBorsa().getAttrezzo(nomeAttrezzo);
        if(a!=null)
        {
            partita.getStanzaCorrente().addAttrezzo(a);
            partita.getBorsa().removeAttrezzo(a.getNome());
    
            io.mostraMessaggio("Attrezzo posato nella stanza e rimosso dalla borsa");
        }
        else
        {
            io.mostraMessaggio("Scegliere un attrezzo valido");
        }
    }

    @Override
    public void setParametro(String nomeAttrezzo)
    {
        this.nomeAttrezzo = nomeAttrezzo;
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
        return this.nomeAttrezzo;
    }
}
