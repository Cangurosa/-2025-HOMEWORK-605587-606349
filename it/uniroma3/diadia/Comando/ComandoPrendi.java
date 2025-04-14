package it.uniroma3.diadia.Comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
    private IO io;
    private String nomeAttrezzo;
    private final static String NOME = "prendi";

    @Override
    public void esegui(Partita partita)
    {
        Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        if(a!=null)
        {
            if(partita.getBorsa().getPeso() + a.getPeso() <= partita.getBorsa().getPesoMax())
            {
                partita.getBorsa().addAttrezzo(a);
                partita.getStanzaCorrente().removeAttrezzo(a);
                io.mostraMessaggio("Attrezzo rimosso dalla stanza e messo in borsa");
            }
            else
            {
                io.mostraMessaggio("Attrezzo troppo pesante, allegerisci la borsa");
            }
        }
        else
        {
            io.mostraMessaggio("Scegliere un attrezzo valido");
        }
    }

    @Override
    public void setParametro(String nome)
    {
        this.nomeAttrezzo = nome;
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
        return nomeAttrezzo;
    }
}
