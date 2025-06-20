package it.uniroma3.diadia;
import it.uniroma3.diadia.Comando.Comando;
import it.uniroma3.diadia.Comando.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private IO io;
	private Partita partita;

	public DiaDia(IO io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);

		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
		io.mostraMessaggio("Hai vinto!");

		else if (this.partita.persa())
		io.mostraMessaggio("Hai esaurito i CFU...");
		
		return this.partita.isFinita();
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}
	
	private void mostra()
	{
		io.mostraMessaggio(partita.getBorsa().toString());
	}
	
	private void prendi(String nomeAttrezzo)
	{
		if(nomeAttrezzo==null)
		{
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		}
		else
		{
			if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo))
			{
				partita.getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
				partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
				io.mostraMessaggio("Attrezzo preso dalla stanza e messo in borsa");
			}
			else
			io.mostraMessaggio("Oggetto non trovato");
		}
	}
	
	private void lascia(String nomeAttrezzo)
	{
		if(nomeAttrezzo==null)
		{
			io.mostraMessaggio("Quale attrezzo vuoi lasciare?");
		}
		else
		{
			if(partita.getBorsa().hasAttrezzo(nomeAttrezzo))
			{
				partita.getStanzaCorrente().addAttrezzo(partita.getBorsa().getAttrezzo(nomeAttrezzo));
				partita.getBorsa().removeAttrezzo(nomeAttrezzo);
				
				io.mostraMessaggio("Attrezzo rimosso dalla borsa e lasciato nella stanza: " + partita.getStanzaCorrente());
			}

			else
			{
				io.mostraMessaggio("Oggetto non trovato nella borsa");
			}
		}
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/* 
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.partita.setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU rimanenti: " + partita.getCfu());
	}

	/**
	 * Comando "Fine".
	 */
	/* 
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	*/

	public static void main(String[] argc) {
		IO io =new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}
