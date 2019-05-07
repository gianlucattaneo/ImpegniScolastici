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
 * @author Davide
 */
public class Impegno {
    String descrizione,idCalendario,nome,luogo,aula,nomeCalendario,data;
    Time oraInizio,oraFine;

    public Impegno(String descrzione, String nomeCalendario, String nome, String lotto, String aula, String data, Time oraInizio, Time oraFine) {
        this.descrizione = descrzione;
        this.nomeCalendario = nomeCalendario;
        this.nome = nome;
        this.luogo = lotto;
        this.aula = aula;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        idCalendario="0";
    }

    @Override
    public String toString() {
        return "Impegno{" + "descrzione=" + descrizione + ", idCalendario=" + idCalendario + ", nome=" + nome + ", luogo=" + luogo + ", aula=" + aula + ", nomeCalendario=" + nomeCalendario + ", data=" + data + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + '}';
    }
    

    public String getNomeCalendario() {
        return nomeCalendario;
    }

    public void setNomeCalendario(String nomeCalendario) {
        this.nomeCalendario = nomeCalendario;
    }
    
        
    public String getDescrzione() {
        return descrizione;
    }

    public void setDescrzione(String descrzione) {
        this.descrizione = descrzione;
    }

    public String getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(String idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLotto() {
        return luogo;
    }

    public void setLotto(String lotto) {
        this.luogo = lotto;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Time getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    public Time getOraFine() {
        return oraFine;
    }

    public void setOraFine(Time oraFine) {
        this.oraFine = oraFine;
    }
    
    
}
