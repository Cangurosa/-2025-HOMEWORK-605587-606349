package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @see Labirinto
 * @version base
 */

public class Partita {

	private Labirinto labirinto; //creo una variabile labirinto di tipo Labirinto
	private Giocatore giocatore; //creo una variabile giocatore di tipo Giocatore
	private boolean finita;
	
	public Partita(){
		labirinto = new Labirinto(); //creo e inizializzo il labirinto
		giocatore = new Giocatore();
		this.finita = false;
	}
	
	//richiamo le funzioni nella classe Labirinto
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setStanzaCorrente(stanzaCorrente); 
	}
	
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}
	
	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}
	
	public boolean persa() {
		return (giocatore.getCfu() == 0);
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || persa();
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public int getCfu()
	{
		return giocatore.getCfu();
	}
	
	public void setCfu(int cfu) {
		if(cfu>0)
			giocatore.setCfu(cfu);
		
		else
		{
			giocatore.setCfu(0);
			this.finita=true;
		}
		
	}	
	
	public Borsa getBorsa()
	{
		return this.giocatore.getBorsa();
	}
}



