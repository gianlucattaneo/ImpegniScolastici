package agenda;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author gianluca
 */
public class Agenda {
    
    private static WSConsumer webService = new WSConsumer();
    private static int scelta = -1;
    private static String nomeImpegno = "", descrizione = "", tipo = "", data = "", ora = "", id = "";
    private static Scanner input = new Scanner(System.in);
    
    public static void addImpegno(){
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
    }
    public static void deleteImpegno(){
        System.out.println("Scrivi l'id dell'impegno da eliminare");
        id = input.nextLine();
        webService.deleteImpegno(id);
        webService.printResult();
    }
    public static void updateImpegno(){
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
    }
    
    public static void Menu(){
        do {
            System.out.println("1- addImpegno");
            System.out.println("2- deleteImpegno");
            System.out.println("3- updateImpegno");
            System.out.println("4- getAllImpegno");
            System.out.println("0- Esci");

            scelta = input.nextInt();
            System.out.println();
            System.out.println();
            System.out.println();
            switch (scelta) {
                case 1: {
                    addImpegno();
                    break;
                }
                case 2: {
                    deleteImpegno();
                    break;
                }
                case 3: {
                    updateImpegno();
                    break;
                }
                case 4: {
                    webService.getAllImpegno();
                    webService.printResult();
                    break;
                }
                case 0: {
                    System.out.println("FINE");
                }
            }
        } while (scelta != 0);
    }
    

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        System.out.println("BENVENUTO NELL'AGENDA");
        System.out.println("1 - Effettua il login");
        System.out.println("2 - Effettua la registrazione");
        System.out.println("0 - Esci");
        scelta = input.nextInt();
        
        do{
        switch (scelta) {
            case 1: {
                System.out.println("Username o email:");
                String username_email = input.next();
                System.out.println("password:");
                String password = input.next();
                int result = webService.verificaUtente(username_email, password);
                webService.printResult();
                System.out.println("RISULTATO: " + result);
                if (result == 200) {
                    Menu();
                }
                
                break;
            }
            case 2: {
                System.out.println("Inserisci l'username:");
                String username = input.next();
                System.out.println("Inserisci la password:");
                String password = input.next();
                System.out.println("Inserisci la tua email:");
                String email = input.next();
                System.out.println("Inserisci il tuo nome:");
                String nomeUtente = input.next();
                System.out.println("Inserisci il tuo cognome:");
                String cognomeUtente = input.next();
                System.out.println("Inserisci la tua classe:");
                String classe = input.next();
                webService.addUtente(username, password, email, nomeUtente, cognomeUtente, classe);
                webService.printResult();
                break;
            }
            case 0:{
                System.out.println("FINE");
                break;
            }
        }
        }while(scelta!=0);

    }

}
