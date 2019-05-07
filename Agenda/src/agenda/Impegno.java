package agenda;

import java.sql.Time;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davide_Pirolo
 * @author Matteo_Baldassin
 */
public class Impegno {
    String descrizione,idCalendario,nome,luogo,aule,nomeCalendario,data, oraInizio, oraFine;
    //Time oraInizio,oraFine;
/*
    public Impegno(String nomeCalendario, String nome, String descrizione, String data, String luogo, String aule, Time oraInizio, Time oraFine){
        this.descrizione = descrizione;
        this.nomeCalendario = nomeCalendario;
        this.nome = nome;
        this.luogo = luogo;
        this.aule = aule;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        idCalendario="0";
    }
    */
    public Impegno(String nomeCalendario, String nome, String descrizione, String data, String luogo, String aule, String oraInizio, String oraFine){
        this.descrizione = descrizione;
        this.nomeCalendario = nomeCalendario;
        this.nome = nome;
        this.luogo = luogo;
        this.aule = aule;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        idCalendario="0";
    }

    @Override
    public String toString() {
        return "{" +
            " descrizione='" + getDescrizione() + "'" +
            ", idCalendario='" + getIdCalendario() + "'" +
            ", nome='" + getNome() + "'" +
            ", luogo='" + getLuogo() + "'" +
            ", aule='" + getAule() + "'" +
            ", nomeCalendario='" + getNomeCalendario() + "'" +
            ", data='" + getData() + "'" +
            ", oraInizio='" + getOraInizio() + "'" +
            ", oraFine='" + getOraFine() + "'" +
            "}";
    }

    
    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIdCalendario() {
        return this.idCalendario;
    }

    public void setIdCalendario(String idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLuogo() {
        return this.luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getAule() {
        return this.aule;
    }

    public void setAule(String aule) {
        this.aule = aule;
    }

    public String getNomeCalendario() {
        return this.nomeCalendario;
    }

    public void setNomeCalendario(String nomeCalendario) {
        this.nomeCalendario = nomeCalendario;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOraInizio() {
        return this.oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return this.oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }
    
    
    
}
