package verificatep;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List vini;

    public Parser() {
        vini = new ArrayList();
    }

    public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Vino vino;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("row");       
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element)nodelist.item(i);
                Vino l = getVino(element);
                vini.add(l);
            }
        }
        return vini;
    }

    private Vino getVino(Element element) {
        Vino v;
        String anno=getTextValue(element,"anno");
        String regione=getTextValue(element,"regione");
        String codice=getTextValue(element,"codice");
        String doc=getTextValue(element,"d_o_c__e_d_o_c_g_");
        String igt=getTextValue(element,"i_g_t_");
        int daTavola=getIntValue(element,"da_tavola");
        int totale=getIntValue(element,"totale");
        v = new Vino(anno,regione,codice,doc,igt,daTavola,totale);
        return v;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element) {
        String value = null;
        if (element != null) {
            value = element.getFirstChild().getNodeValue();
        }
        return value;
    }    
    
    private String getTextValue(Element element, String tag) {
        String value = null;
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        if (nodelist != null && nodelist.getLength() > 0) {
            value = nodelist.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }
    
    // restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }
    
    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }
    
}