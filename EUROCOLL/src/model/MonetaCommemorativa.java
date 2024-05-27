package model;

import java.io.Serializable;

public class MonetaCommemorativa extends Moneta implements Serializable{
    private final String pathimm;
    private final String nome;
    private final String descrizione;
    public MonetaCommemorativa(int anno,String nome, String pathimm, String descrizione){
        super(anno);
        this.nome = nome;
        this.pathimm = pathimm;
        this.descrizione = descrizione;
    }

    public final String getNome() {
        return this.nome;
    }

    public final String getDescrizione() {
        return this.descrizione;
    }

    public final String getPathimm() {
        return this.pathimm;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(this==obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        MonetaCommemorativa other = (MonetaCommemorativa) obj;
        if(this.getAnno() != other.getAnno()) return false;
        if(! this.getNome().equals(other.getNome())) return false;
        return this.getDescrizione().equals(other.getDescrizione());
    }
}
