package diadia;

/**
* Ha la responsabilità di creare il labirinto, di memorizzare la stanza
* iniziale (entrata) e quella finale (uscita)
 *
 * @author  Daniel 605587, Gabriel 606349
 * @see Stanza
 * @version base
 */

public class Labirinto {
	public Stanza stanzaIniziale;
	public Stanza stanzaFinale;
	public Stanza stanzaCorrente;
	
	public Labirinto()
	{
		creaLabirinto(); //costruttore per costruire il labirinto e settare tutte le stanze
	}
	
	
	private void creaLabirinto()
	{
		//creazione degli attrezzi
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
	
		
		//settaggio delle stanze del gioco
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		//impostazione delle stanze e delle direzioni
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
        //sistemazione  degli attrezzi nelle stanze
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		stanzaIniziale = atrio; //stanza di partenza "Atrio"
		stanzaFinale = biblioteca; //stanza di vittoria "Biblioteca"
		stanzaCorrente = stanzaIniziale; //in stanzaCorrente ci metto la stanza di partenza
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaFinale;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente)
	{
		this.stanzaCorrente = stanzaCorrente;
	}

}
