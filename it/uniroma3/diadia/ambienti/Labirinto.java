package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;
/**
* Ha la responsabilità di creare il labirinto, di memorizzare la stanza
* iniziale (entrata) e quella finale (uscita)
 *
 * @author  Daniel Della Posta 605587, Gabriel Garcia Ramos 606349
 * @see Stanza
 * @version finale
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
		Attrezzo accetta = new Attrezzo("accetta", 2);
	
		
		//settaggio delle stanze del gioco
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new StanzaMagica("Aula N11");
		Stanza aulaN10 = new StanzaBloccata("Aula N10", "est", "accetta");
		Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
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
		aulaN11.addAttrezzo(accetta);
		
		stanzaIniziale = atrio; //stanza di partenza "Atrio"
		stanzaFinale = biblioteca; //stanza di vittoria "Biblioteca"
		stanzaCorrente = stanzaIniziale; //in stanzaCorrente ci metto la stanza di partenza
	}
	
	/**
 	* Ritorna la stanza vincente
  	* @return la stanza vincente
	*/
	public Stanza getStanzaVincente() {
		return this.stanzaFinale;
	}
	
	/**
 	* Ritorna la stanza corrente
  	* @return la stanza corrente
	*/
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
 	* Imposta la stanza corrente
  	* @param stanzaCorrente la stanza in cui si trova il giocatore
	*/
	public void setStanzaCorrente(Stanza stanzaCorrente)
	{
		this.stanzaCorrente = stanzaCorrente;
	}

}
