/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatep;

/**
 *
 * @author riva_roland
 */
public class Vino {

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getIgt() {
        return igt;
    }

    public void setIgt(int igt) {
        this.igt = igt;
    }

    public int getDaTavola() {
        return daTavola;
    }

    public void setDaTavola(int daTavola) {
        this.daTavola = daTavola;
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }

    public Vino() {
    }

    public Vino(String anno, String regione, String codice, String doc, int igt, int daTavola, int totale) {
        this.anno = anno;
        this.regione = regione;
        this.codice = codice;
        this.doc = doc;
        this.igt = igt;
        this.daTavola = daTavola;
        this.totale = totale;
    }

    @Override
    public String toString() {
        return "Vino{" + "anno=" + anno + ", regione=" + regione + ", codice=" + codice + ", doc=" + doc + ", igt=" + igt + ", daTavola=" + daTavola + ", totale=" + totale + '}';
    }
    private String anno;
    private String regione;
    private String codice;
    private String doc;
    private int igt;
    private int daTavola;
    private int totale;
}
