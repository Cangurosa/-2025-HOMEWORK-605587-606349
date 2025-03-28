package diadia;


/**
 * Si occupa di gestire i cfu della partita e gli
 * oggetti contenuti nella borsa
 *
 * @author  Daniel 605587, Gabriel 606349
 * @see Partita
 * @see Borsa
 * @version base
 */

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa;
	private int cfu;
	
	public Giocatore()
	{
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/*Metodo per ottenere il numero di cfu */
	public int getCfu()
	{
		return this.cfu;
	}
	
	/*Metodo che imposta i cfu del giocatore*/
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	/*Metodo che mostra la borsa del giocatore*/
	public Borsa getBorsa()
	{
		return this.borsa;
	}
	
	/*Metodo che aggiunge un attrezzo in borsa*/
	public void addAttrezzo(Attrezzo attrezzo)
	{
		 this.borsa.addAttrezzo(attrezzo);
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo)
	{
		return this.borsa.hasAttrezzo(nomeAttrezzo);
	}
	
	/*Metodo che ritorna il peso della borsa*/
	public int getPesoBorsa()
	{
		return borsa.getPeso();
	}
	
}