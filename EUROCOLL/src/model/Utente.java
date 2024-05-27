package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utente implements Serializable{
    private final String nickName;
    private final String password;

    private final List<Moneta> moneteRaccolte;

    public Utente(String nickName, String password){
        this.nickName = nickName;
        this.password = password;
        this.moneteRaccolte = new ArrayList<>();

    }

    public boolean checkUtente(String nickName, String password){
        return (this.nickName.equals(nickName)) && (this.password.equals(password));
    }

    public boolean aggiungiMonetaAllaCollezione(Moneta moneta){
        if(this.moneteRaccolte.contains(moneta)){
            return false;
        }
        else{
            this.moneteRaccolte.add(moneta);
            return true;
        }
    }

    public boolean rimuoviMonetaDallaCollezione(Moneta moneta){
        if(this.moneteRaccolte.contains(moneta)){
            this.moneteRaccolte.remove(moneta);
            return true;
        }
        else{
            return false;
        }
    }


    public boolean isPresent(Moneta moneta){
        return this.moneteRaccolte.contains(moneta);
    }

    public boolean isPresentDivisionale(Moneta.Taglio taglio){
        return this.moneteRaccolte.stream()
                .anyMatch(m->(!m.isCommemorativa()) && (m.getTaglio() == taglio));
    }

    public boolean isPresentCommemorativa(MonetaCommemorativa moneta){
        return this.moneteRaccolte.contains(moneta);
    }

    public long numeroDivisionaliCollezionate(){
        return this.moneteRaccolte.stream()
                .filter(m->! m.isCommemorativa())
                .count();
    }

    public long numeroCommemorativeCollezionate(){
        return  this.moneteRaccolte.stream()
                .filter(Moneta::isCommemorativa)
                .count();
    }

    public double totaleValoreDivisionaliCollezionate(){
        return this.moneteRaccolte.stream()
                .filter(m->! m.isCommemorativa())
                .mapToDouble(moneta->moneta.getTaglio().getValore())
                .sum();
    }

    public double totaleValoreCommemorativeCollezionate(){
        return this.moneteRaccolte.stream()
                .filter(Moneta::isCommemorativa)
                .mapToDouble(moneta->moneta.getTaglio().getValore())
                .sum();
    }

    public long numeroMonetePerTaglioCollezionate(Moneta.Taglio taglio){
        return this.moneteRaccolte.stream()
                .filter(m->m.getTaglio()==taglio)
                .count();
    }
}
