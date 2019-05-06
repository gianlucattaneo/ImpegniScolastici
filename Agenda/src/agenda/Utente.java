/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author baldassin_matteo
 */
public class Utente {

    String username;
    String password;
    String nome;
    String cognome;

    public Utente() {
        username="";
        password="";
        nome="";
        cognome="";
    }
    public Utente(String username, String password, String nome, String cognome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }


    
    
    

}
