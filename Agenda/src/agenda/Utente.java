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
    String email;
    String nome;
    String cognome;
    String classe;

    public Utente() {
        username="";
        password="";
        nome="";
        cognome="";
        email="";
        classe="";
    }
    public Utente(String username, String password,String email, String nome, String cognome,String classe) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
        this.classe=classe;
    }


    
    
    

}
