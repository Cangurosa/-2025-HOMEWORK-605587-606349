package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String attrezzoChiave;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoChiave)
    {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoChiave = attrezzoChiave;
    }
    
    @Override
    public Stanza getStanzaAdiacente(String direzione)
    {
        if(direzioneBloccata.equals(direzione))
        {
            if(!this.hasAttrezzo(attrezzoChiave))
            return this;
        }
        return super.getStanzaAdiacente(direzione);
    }

    @Override
    public String getDescrizione()
    {
        String  blocco = new String();
        blocco = "stanza bloccata in questa direzione";

        if(!this.hasAttrezzo(attrezzoChiave))
        {
            return super.getDescrizione();
        }

        else
        {
            return blocco;
        }
    }
    
}
