package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Si occupa di gestire i cfu della partita e gli
 * oggetti contenuti nella borsa
 *
 * @author  Daniel Della Posta 605587, Gabriel Garcia Ramos 606349
 * @see Partita
 * @see Borsa
 * @version finale
 */

public class Giocatore {
	static final private int CFU_INIZIALI = 20; //CFU di partenza
	private Borsa borsa; //variabile borsa del giocatore
	private int cfu; //variabile cfu

	//costruttore
	public Giocatore()
	{
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/**
 	*
  	*Metodo che ritorna il numero di cfu
   	*
	*@return numero di cfu
 	*/
	public int getCfu()
	{
		return this.cfu;
	}
	
	/**
 	*
  	*Metodo che ritorna imposta i cfu
   	*@param cfu cfu passati da dinamiche esterne
 	*/
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	/**
 	*
  	*Metodo che mostra la borsa del giocatore
   	*
	*@return borsa del giocatore
 	*/
	public Borsa getBorsa()
	{
		return this.borsa;
	}
	
	/**
 	*
  	*Metodo che aggiunge un attrezzo
   	*@param attrezzo attrezzo da aggiungere
 	*/
	public void addAttrezzo(Attrezzo attrezzo)
	{
		 this.borsa.addAttrezzo(attrezzo);
	}

	/**
 	*
  	*Metodo che verifica l'esistenza di un attrezzo in base al nome
   	*@param nomeAttrezzo nome dell'attrezzo richiesto
	*@return true se esiste un attrezzo con lo stesso nome
 	*/
	public boolean hasAttrezzo(String nomeAttrezzo)
	{
		return this.borsa.hasAttrezzo(nomeAttrezzo);
	}
	
	/**
 	*
  	*Metodo che ritorna il peso della borsa
   	*
	*@return peso della borsa
 	*/
	public int getPesoBorsa()
	{
		return borsa.getPeso();
	}
	
}
