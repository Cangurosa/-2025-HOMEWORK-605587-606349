package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
    private String attrezzoLuce;

    public StanzaBuia(String nome, String attrezzoLuce)
    {
        super(nome);
        this.attrezzoLuce = attrezzoLuce;

    }

    @Override
    public String getDescrizione()
    {
        String buio = new String();
        buio = "qui c'è buio pesto";
        if(!this.hasAttrezzo(attrezzoLuce))
        {
            return buio;
        }
        else
        {
            return super.getDescrizione();
        }
    }


}
