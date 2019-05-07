/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import java.security.*;
import org.json.*;

/**
 *
 * @author gianluca
 */
public class WSConsumer {

    private String result;

    private String prefix = "http://gestioneagenda.altervista.org/tapschoolws/";

    WSConsumer() {
        result = "";
    }

    public String getResult() {
        return result;

    }

    public int verificaUtente(String username_email, String password) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    + "gestioneUtente/"
                    + "verificaUtente.php?"
                    + "username_email=" + URLEncoder.encode(username_email, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8");

            serverURL = new URL(url);
            System.out.println(url);
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int addUtente(String username, String password, String email, String nome, String cognome, String classe) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix + "gestioneUtente/"
                    + "addUtente.php?"
                    + "username=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                    + "&email=" + URLEncoder.encode(email, "UTF-8")
                    + "&nome=" + URLEncoder.encode(nome, "UTF-8")
                    + "&cognome=" + URLEncoder.encode(cognome, "UTF-8")
                    + "&classe=" + URLEncoder.encode(classe, "UTF-8");

            serverURL = new URL(url);
            System.out.println(url);
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int addImpegno(String nome, String descrizione, String data, String luogo, String aule, String oraInizio, String oraFine) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    + "gestioneImpegni/"
                    + "addImpegno.php?"
                    + "nome=" + URLEncoder.encode(nome, "UTF-8")
                    + "&descrizione=" + URLEncoder.encode(descrizione, "UTF-8")
                    + "&data=" + URLEncoder.encode(data, "UTF-8")
                    + "&luogo=" + URLEncoder.encode(luogo, "UTF-8")
                    + "&aule=" + URLEncoder.encode(aule, "UTF-8")
                    + "&oraInizio=" + URLEncoder.encode(oraInizio, "UTF-8")
                    + "&oraFine=" + URLEncoder.encode(oraFine, "UTF-8");
            serverURL = new URL(url);
            //System.out.println(url); //attivare per debug
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;

    }

    public int deleteImpegno(String id) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix + "gestioneImpegni/"
                    + "deleteImpegno.php?"
                    + "id=" + URLEncoder.encode(id, "UTF-8");
            serverURL = new URL(url);
            System.out.println(url);
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int updateImpegno(String nome, String descrizione, String data, String luogo, String aule, String oraInizio, String oraFine) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    + "gestioneImpegni/"
                    + "addImpegno.php?"
                    + "nome=" + URLEncoder.encode(nome, "UTF-8")
                    + "&descrizione=" + URLEncoder.encode(descrizione, "UTF-8")
                    + "&data=" + URLEncoder.encode(data, "UTF-8")
                    + "&luogo=" + URLEncoder.encode(luogo, "UTF-8")
                    + "&aule=" + URLEncoder.encode(aule, "UTF-8")
                    + "&oraInizio=" + URLEncoder.encode(oraInizio, "UTF-8")
                    + "&oraFine=" + URLEncoder.encode(oraFine, "UTF-8");
            serverURL = new URL(url);
            System.out.println(url);
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int getAllImpegno() {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix + "gestioneImpegni/"
                    + "getAllImpegno.php";
            serverURL = new URL(url);
            System.out.println(url);
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            int conta = 0;
            while ((line = input.readLine()) != null) {
                // contatore per una più facile visualizzazione
                conta++;

                //creo oggetto JSON con riga ricevuta da webservice
                JSONObject jsonObject = new JSONObject(line);

                int ID = jsonObject.getInt("ID");
                Object nome = jsonObject.get("nome");
                Object descrizione = jsonObject.get("descrizione");
                Object data = jsonObject.get("data");
                Object luogo = jsonObject.get("luogo");
                Object aule = jsonObject.get("aule");
                Object oraInizio = jsonObject.get("oraInizio");
                Object oraFine = jsonObject.get("oraFine");
                //scrivo nel terminale
                System.out.println("------------ELEMENTO " + conta + "------------");
                System.out.println("ID: " + ID);
                System.out.println("Nome: " + nome);
                System.out.println("Descrizione: " + descrizione);
                System.out.println("Data: " + data.toString());
                System.out.println("Luogo: " + luogo);
                System.out.println("Aule: " + aule);
                System.out.println("Ora Inizio: " + oraInizio);
                System.out.println("Ora Fine: " + oraFine);

                //vecchia versione, si puo rimuovere
                //result += line + "\r\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int subscribeImpegno(String utente, String impegno) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    + "gestioneImpegni/"
                    + "subscribeToImpegno.php?"
                    + "utente=" + URLEncoder.encode(utente, "UTF-8")
                    + "&impegno=" + URLEncoder.encode(impegno, "UTF-8");
            serverURL = new URL(url);
            System.out.println(url);
            service = (HttpURLConnection) serverURL.openConnection();
            // impostazione header richiesta . ftp.gestioneagenda.altervista.org
            service.setRequestProperty("Host", "ftp.gestioneagenda.altervista.org");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    //in teoria questo non viene mai richiamato
    public int get(String paramater, String value) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpsURLConnection service;
            BufferedReader input;

            String url = prefix + "gestioneImpegni/"
                    + URLEncoder.encode(paramater, "UTF-8") + "="
                    + URLEncoder.encode(value, "UTF-8");
            serverURL = new URL(url);
            service = (HttpsURLConnection) serverURL.openConnection();
            // impostazione header richiesta
            service.setRequestProperty("Host", "www.gerriquez.com");
            service.setRequestProperty("Accept", "application/text");
            service.setRequestProperty("Accept-Charset", "UTF-8");
            // impostazione metodo di richiesta GET
            service.setRequestMethod("GET");
            // attivazione ricezione
            service.setDoInput(true);
            // connessione al web-service
            service.connect();
            // verifica stato risposta
            status = service.getResponseCode();
            if (status != 200) {
                return status; // non OK
            }
            // apertura stream di ricezione da risorsa web
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), "UTF-8"));
            // ciclo di lettura da web e scrittura in result
            String line;
            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
            input.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    void printResult() {
        String[] arrOfStr = result.split("\",\"");
        for (int i = 0; i < arrOfStr.length; i++) {
            System.out.println(arrOfStr[i]);
        }
    }

    String printResultString() {
        String[] arrOfStr = result.split("\",\"");
        String result = "";
        for (int i = 0; i < arrOfStr.length; i++) {
            result += arrOfStr[i];
        }
        return result;
    }
}
