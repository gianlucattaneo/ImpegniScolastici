package agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
//import java.util.Scanner;

/**
 *
 * @author gianluca
 */
public class Agenda {

    private static WSConsumer webService = new WSConsumer();
    private static int scelta = -1;
    private static String username = "";
    // private static Scanner input = new Scanner(System.in);
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException,
            ParserConfigurationException, SAXException {
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
        System.out.println("Scrivi la data dell'impegno");
        String data = input.readLine();
        System.out.println("Scrivi il luogo dell'impegno");
        String luogo = input.readLine();
        System.out.println("Scrivi la/le aula/e dell'impegno");
        String aule = input.readLine();
        System.out.println("Scrivi l'ora d'inizio dell'impegno");
        String oraInizio = input.readLine();
        System.out.println("Scrivi l'ora di fine dell'impegno");
        String oraFine = input.readLine();
        int result = webService.addImpegno(nomeImpegno, descrizione, data, luogo, aule, oraInizio, oraFine);
        webService.printResult();
        System.out.println("RISULTATO: " + result);
        if (result == 200) {
            System.out.println("Impegno inserito correttamente");
        }

    }

    public static void deleteImpegno() throws IOException {
        System.out.println("Scrivi l'id dell'impegno da eliminare");
        String id = input.readLine();
        webService.deleteImpegno(id);
        webService.printResult();
    }

    public static void updateImpegno() throws IOException {
        System.out.println("Scrivi il nome dell'impegno");
        String nomeImpegno = input.readLine();
        System.out.println("Scrivi la descrizione dell'impegno");
        String descrizione = input.readLine();
        System.out.println("Scrivi la data dell'impegno");
        String data = input.readLine();
        System.out.println("Scrivi il luogo dell'impegno");
        String luogo = input.readLine();
        System.out.println("Scrivi la/le aula/e dell'impegno");
        String aule = input.readLine();
        System.out.println("Scrivi l'ora d'inizio dell'impegno");
        String oraInizio = input.readLine();
        System.out.println("Scrivi l'ora di fine dell'impegno");
        String oraFine = input.readLine();
        webService.updateImpegno(nomeImpegno, descrizione, data, luogo, aule, oraInizio, oraFine);
        webService.printResult();
    }

    public static void getAllImpegno() {
        webService.getAllImpegno();
        webService.printResult();
    }

    public static void parseImpegno() throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Iserisci l'URL: ");
        String url = input.readLine();

        ArrayList<Impegno> impegni = new ArrayList<>();
        Parser dom = new Parser();
        impegni = dom.parseDocument(url);

        for (Impegno i : impegni) {
            System.out.println(i.toString());
            int result = webService.addImpegno(i.nome, i.descrizione, i.data, i.luogo, i.aule, i.oraInizio, i.oraFine);
            webService.printResult();
            System.out.println("RISULTATO: " + result);
            if (result == 200)
                System.out.println("Impegno inserito correttamente");

            // webService.addImpegno(i.nome, i.descrizione, "pubblico", i.data, "8:00");
        }

    }

    public static void Menu() throws IOException, ParserConfigurationException, SAXException {
        do {
            System.out.println("Benvenuto: " + username);
            System.out.println("Seleziona cosa vuoi fare: ");

            System.out.println("1- addImpegno");
            System.out.println("2- deleteImpegno");
            System.out.println("3- updateImpegno");
            System.out.println("4- getAllImpegno");
            System.out.println("5- parseDocument");
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
            case 5: {
                parseImpegno();
                break;
            }
            case 0: {
                System.out.println("FINE");
            }
            }
        } while (scelta != 0);
    }

}
