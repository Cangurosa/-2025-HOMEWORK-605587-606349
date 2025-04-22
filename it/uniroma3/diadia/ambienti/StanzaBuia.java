package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaBuia extends Stanza{
    private String NomeAttrezzoDescrizione;

    public StanzaBuia(String nome)
    {
        super(nome);
       Attrezzo attrezzodescrizione = new Attrezzo("Lanterna", 4);
       NomeAttrezzoDescrizione = attrezzodescrizione.getNome();
    }

    public String getDescrizione()
    {
        if(this.hasAttrezzo(NomeAttrezzoDescrizione))
        {
            return toString();
        }
       else
       return "Qui c'è un buio pesto";
    }

}
