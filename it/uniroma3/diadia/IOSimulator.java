package it.uniroma3.diadia;

public class IOSimulator implements IO{
    private String[] messaggiLetti;
    private int indiceMessaggiLetti;
    private String[] messaggiProdotti;
    private int indiceMessaggiProdotti;

    public IOSimulator(String[] messaggiNonLetti)
    {
        this.messaggiLetti = messaggiNonLetti;
        this.indiceMessaggiLetti = 0;
        this.indiceMessaggiProdotti = 0;
        this.messaggiProdotti = new String[42*23];
    }

    public String[] getMessaggi()
    {
        return messaggiProdotti;
    }

    public void setMessaggi(String[] messaggiProdotti)
    {
        this.messaggiProdotti = messaggiProdotti;
    }

    @Override
    public String leggiRiga()
    {
        String riga = null;
        riga = this.messaggiLetti[indiceMessaggiLetti];
        this.indiceMessaggiLetti++;
        return riga;
    }

    @Override
    public void mostraMessaggio(String msg)
    {
        this.messaggiProdotti[indiceMessaggiProdotti] = msg;
        this.indiceMessaggiProdotti++;
    }


}
