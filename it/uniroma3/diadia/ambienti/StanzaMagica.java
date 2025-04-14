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
public class StanzaMagica extends Stanza{
    final static private int SOGLIA_MAGICA_DEFAULT = 3;
    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagica(String nome)
    {
        super(nome);
        this.sogliaMagica = SOGLIA_MAGICA_DEFAULT;
    }
    public StanzaMagica(String nome, int soglia)
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

    public Attrezzo modificAttrezzo(Attrezzo attrezzo)
    {
        StringBuilder nomeInvertito;
        int pesoX2 = attrezzo.getPeso()*2;

        nomeInvertito = new StringBuilder(attrezzo.getNome());
        nomeInvertito = nomeInvertito.reverse();
        attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
        
        return attrezzo;
    }

}
