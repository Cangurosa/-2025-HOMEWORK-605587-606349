package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/*
 * Classe capace di rendere le stanze magiche dopo
 * un certo numero di azioni. Essa è un estensione
 * della classe Stanza
 * 
 * @author Della Posta Daniel 605587
 * 
 * @version base
 */
public class StanzaMagicaProtected extends StanzaProtected{
    final static private int SOGLIA_MAGICA_DEFAULT = 3;
    protected int contatoreAttrezziPosati;
    protected int sogliaMagica;

    protected StanzaMagicaProtected(String nome)
    {
        super(nome);
        this.sogliaMagica = SOGLIA_MAGICA_DEFAULT;
    }
    protected StanzaMagicaProtected(String nome, int soglia)
    {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo)
    {
        this.contatoreAttrezziPosati++;
        if(this.contatoreAttrezziPosati > this.sogliaMagica)
        {
            attrezzo = this.modificAttrezzo(attrezzo);
        }
        return super.addAttrezzo(attrezzo);
    }

    protected Attrezzo modificAttrezzo(Attrezzo attrezzo)
    {
        StringBuilder nomeInvertito;
        int pesoX2 = attrezzo.getPeso()*2;

        nomeInvertito = new StringBuilder(attrezzo.getNome());
        nomeInvertito = nomeInvertito.reverse();
        attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
        
        return attrezzo;
    }

}
