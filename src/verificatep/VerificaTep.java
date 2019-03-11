/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author riva_roland
 */
public class VerificaTep {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int totale=0;
        int igt=0;
        String year="";
        String regione="";
        Scanner scanner=new Scanner(System.in);
        boolean controllo=true;
        String patheth="vini.xml";
        ArrayList<Vino> vini=null;
        Parser dom = new Parser();
        try {
            vini = dom.parseDocument(patheth);
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        while(controllo=true){
        System.out.println("menu=");
        System.out.println("1) Chiedere all’utente anno e regione per visualizzare tutte le informazioni presenti.");
        System.out.println("2) Chiedere all’utente l’anno , visualizzare il totale di Vino da tavola prodotto in italia.");
        System.out.println("3) In tutto il documento quale regione ha prodotto piu’ I.G.T.");
        System.out.println("4) Quale regione ,in tutto il documento ha il Totale Maggiore");
        System.out.println("0) esci");
        int risposta=scanner.nextInt();
        switch(risposta){
            case 0:
                controllo=false;
                break;
            case 1:
                System.out.println("dammi anno");
                year=scanner.next();
                System.out.println("dammi regione");
                regione=scanner.next();
                for(int i=0;i<vini.size();i++){
                    if(vini.get(i).getAnno().equals(year)&&vini.get(i).getRegione().equals(regione)){
                        System.out.println(vini.get(i).toString());
                    }
                }
                break;
            case 2:
                System.out.println("dammi anno");
                year=scanner.next();
                for(int i=0;i<vini.size();i++){
                    if(vini.get(i).getAnno().equals(year)){
                        totale=totale+vini.get(i).getTotale();
                    }
                }
                System.out.println(totale);
                break;
            case 3:
                
                break;
            case 4:
                break;
        }
        }
        //iterazione della lista e visualizzazione degli oggetti
//        System.out.println("Numero di Vini: " + vini.size());
//        Iterator iterator = vini.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }
        
    }
    
}
