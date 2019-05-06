package agenda;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author gianluca
 */

public class Agenda {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        WSConsumer webService = new WSConsumer();
        int scelta = -1;
        String nomeImpegno="",descrizione="",tipo="",data="",ora="",id="";
        Scanner input = new Scanner(System.in);
        System.out.println("BENVENUTO NEL SISTEMA DI CALENDARIO");
        System.out.println("1 - Effettua il login");
        System.out.println("2 - Effettua la registrazione");
        scelta=input.nextInt();
        switch(scelta){
            case 1:{
                System.out.println("Username:");
                String username=input.nextLine();
                System.out.println("Username:");
                String password=input.nextLine();
            }
            case 2:{
                System.out.println("Inserisci l'username:");
                String username=input.next();
                System.out.println("Inserisci la password:");
                String password=input.next();
                System.out.println("Inserisci la mail:");
                String email=input.next();
                System.out.println("Inserisci la nome:");
                String nomeUtente=input.next();
                System.out.println("Inserisci il cognome:");
                String cognomeUtente=input.next();
                webService.addUtente(username, password, email, nomeUtente, cognomeUtente, email);
                webService.printResult();
            }
        }
        
        do{
        System.out.println("1- addImpegno");
        System.out.println("2- deleteImpegno");
        System.out.println("3- updateImpegno");
        System.out.println("4- getAllImpegno");
        System.out.println("0- Esci");
        
        scelta = input.nextInt();
        System.out.println();
        System.out.println();
        System.out.println();
        switch(scelta){
            case 1:{
                System.out.println("Scrivi il nome dell'impegno");
                nomeImpegno = input.nextLine();
                System.out.println("Scrivi la descrizione dell'impegno");
                descrizione = input.nextLine();
                System.out.println("Scrivi il tipo dell'impegno");
                tipo = input.nextLine();
                System.out.println("Scrivi la data dell'impegno");
                data = input.nextLine();
                System.out.println("Scrivi il ora dell'impegno");
                ora = input.nextLine();
                webService.addImpegno(nomeImpegno, descrizione, tipo, data, ora);
                webService.printResult();
                break;
            }
            case 2:{
                System.out.println("Scrivi l'id dell'impegno da eliminare");
                id = input.nextLine();
                
                webService.deleteImpegno(id);
                webService.printResult();
                break;
            }
            case 3:{
                System.out.println("Scrivi l'id dell'impegno da modificare");
                id = input.nextLine();
                System.out.println("Scrivi il nome dell'impegno");
                nomeImpegno = input.nextLine();
                System.out.println("Scrivi la descrizione dell'impegno");
                descrizione = input.nextLine();
                System.out.println("Scrivi il tipo dell'impegno");
                tipo = input.nextLine();
                System.out.println("Scrivi la data dell'impegno");
                data = input.nextLine();
                System.out.println("Scrivi il ora dell'impegno");
                ora = input.nextLine();
                webService.updateImpegno(nomeImpegno, descrizione, tipo, data, ora, id);
                webService.printResult();
                break;
            }
            case 4:{
                webService.getAllImpegno();
                    
                webService.printResult();
                break;
            }
            case 0:{
                System.out.println("FINE");
            }
            
        }
        
        }while(scelta!=0);
        
    }
    
}
