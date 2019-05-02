package agenda;

import java.util.Scanner;

/**
 *
 * @author gianluca
 */

public class Agenda {
    
    public static void main(String[] args) {
        WSConsumer webService = new WSConsumer();
        int scelta = 657894;
        String nome="",descrizione="",tipo="",data="",ora="",id="";
        Scanner input = new Scanner(System.in);
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
                nome = input.nextLine();
                System.out.println("Scrivi la descrizione dell'impegno");
                descrizione = input.nextLine();
                System.out.println("Scrivi il tipo dell'impegno");
                tipo = input.nextLine();
                System.out.println("Scrivi la data dell'impegno");
                data = input.nextLine();
                System.out.println("Scrivi il ora dell'impegno");
                ora = input.nextLine();
                webService.addImpegno(nome, descrizione, tipo, data, ora);
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
                nome = input.nextLine();
                System.out.println("Scrivi la descrizione dell'impegno");
                descrizione = input.nextLine();
                System.out.println("Scrivi il tipo dell'impegno");
                tipo = input.nextLine();
                System.out.println("Scrivi la data dell'impegno");
                data = input.nextLine();
                System.out.println("Scrivi il ora dell'impegno");
                ora = input.nextLine();
                webService.updateImpegno(nome, descrizione, tipo, data, ora, id);
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
