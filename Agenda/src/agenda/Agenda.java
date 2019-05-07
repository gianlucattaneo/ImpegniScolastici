package agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
//import java.util.Scanner;

/**
 *
 * @author gianluca
 */
public class Agenda {

    private static WSConsumer webService = new WSConsumer();
    private static int scelta = -1;
    private static String username = "";
//private static Scanner input = new Scanner(System.in);
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        do {
            System.out.println("BENVENUTO NELL'AGENDA");
            System.out.println("1 - Effettua il login");
            System.out.println("2 - Effettua la registrazione");
            System.out.println("0 - Esci");
            scelta = Integer.parseInt(input.readLine());

            switch (scelta) {
                case 1: {
                    System.out.println("Username o email:");
                    String username_email = input.readLine();
                    System.out.println("password:");
                    String password = input.readLine();
                    int result = webService.verificaUtente(username_email, password);
                    webService.printResult();
                    System.out.println("RISULTATO: " + result);
                    if (result == 200) {
                        username = username_email;
                        Menu();
                    }

                    break;
                }
                case 2: {
                    System.out.println("Inserisci l'username:");
                    String username = input.readLine();
                    System.out.println("Inserisci la password:");
                    String password = input.readLine();
                    System.out.println("Inserisci la tua email:");
                    String email = input.readLine();
                    System.out.println("Inserisci il tuo nome:");
                    String nomeUtente = input.readLine();
                    System.out.println("Inserisci il tuo cognome:");
                    String cognomeUtente = input.readLine();
                    System.out.println("Inserisci la tua classe:");
                    String classe = input.readLine();
                    webService.addUtente(username, password, email, nomeUtente, cognomeUtente, classe);
                    webService.printResult();
                    break;
                }
                case 0: {
                    System.out.println("FINE");
                    break;
                }
            }
        } while (scelta != 0);

    }

    public static void addImpegno() throws IOException {
        System.out.println("Scrivi il nome dell'impegno");
        String nomeImpegno = input.readLine();
        System.out.println("Scrivi la descrizione dell'impegno");
        String descrizione = input.readLine();
        System.out.println("Scrivi il tipo dell'impegno");
        String tipo = input.readLine();
        System.out.println("Scrivi la data dell'impegno");
        String data = input.readLine();
        System.out.println("Scrivi il ora dell'impegno");
        String ora = input.readLine();
        webService.addImpegno(nomeImpegno, descrizione, tipo, data, ora);
        webService.printResult();
    }

    public static void deleteImpegno() throws IOException {
        System.out.println("Scrivi l'id dell'impegno da eliminare");
        String id = input.readLine();
        webService.deleteImpegno(id);
        webService.printResult();
    }

    public static void updateImpegno() throws IOException {
        System.out.println("Scrivi l'id dell'impegno da modificare");
        String id = input.readLine();
        System.out.println("Scrivi il nome dell'impegno");
       String nomeImpegno = input.readLine();
        System.out.println("Scrivi la descrizione dell'impegno");
        String descrizione = input.readLine();
        System.out.println("Scrivi il tipo dell'impegno");
        String tipo = input.readLine();
        System.out.println("Scrivi la data dell'impegno");
        String data = input.readLine();
        System.out.println("Scrivi il ora dell'impegno");
        String ora = input.readLine();
        webService.updateImpegno(nomeImpegno, descrizione, tipo, data, ora, id);
        webService.printResult();
    }
    
    public static void getAllImpegno(){
        webService.getAllImpegno();
        webService.printResult();
    }

    public static void Menu() throws IOException {
        do {
            System.out.println("Benvenuto: " + username);
            System.out.println("Seleziona cosa vuoi fare: ");

            System.out.println("1- addImpegno");
            System.out.println("2- deleteImpegno");
            System.out.println("3- updateImpegno");
            System.out.println("4- getAllImpegno");
            System.out.println("0- Esci");

            scelta = Integer.parseInt(input.readLine());
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
                    getAllImpegno();
                    break;
                }
                case 0: {
                    System.out.println("FINE");
                }
            }
        } while (scelta != 0);
    }

}
