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

/**
 *
 * @author gianluca
 */
public class WSConsumer {

    private String result;
    
    private String prefix = "http://gestioneagenda.altervista.org/tapschoolws/gestioneImpegni/";

    WSConsumer() {
        result = "";
    }

    public String getResult() {
        return result;
    }
    
    public int addImpegno(String nome, String descrizione, String tipo, String data, String ora){
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    +"addImpegno.php?"
                    + "nome="+ URLEncoder.encode(nome, "UTF-8")
                    + "&descrizione="+URLEncoder.encode(descrizione, "UTF-8")
                    + "&tipo="+ URLEncoder.encode(tipo, "UTF-8")
                    + "&data="+ URLEncoder.encode(data, "UTF-8")
                    + "&ora="+ URLEncoder.encode(ora, "UTF-8");
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
    
    public int deleteImpegno(String id){
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    +"deleteImpegno.php?"
                    + "id="+ URLEncoder.encode(id, "UTF-8");
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
    
   public int updateImpegno(String nome, String descrizione, String tipo, String data, String ora,String id){
       int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    +"updateImpegno.php?"
                    + "nome="+ URLEncoder.encode(nome, "UTF-8")
                    + "&id="+URLEncoder.encode(id, "UTF-8")
                    + "&descrizione="+URLEncoder.encode(descrizione, "UTF-8")
                    + "&tipo="+ URLEncoder.encode(tipo, "UTF-8")
                    + "&data="+ URLEncoder.encode(data, "UTF-8")
                    + "&ora="+ URLEncoder.encode(ora, "UTF-8");
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
    
    public int getAllImpegno(){
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpURLConnection service;
            BufferedReader input;

            String url = prefix
                    +"getAllImpegno.php";
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
    
    public int get(String paramater, String value) {
        int status = 0;
        result = "";

        try {
            URL serverURL;
            HttpsURLConnection service;
            BufferedReader input;

            String url = prefix
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
}
