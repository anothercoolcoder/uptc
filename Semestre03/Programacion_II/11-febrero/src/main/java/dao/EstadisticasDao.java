package dao;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dto.*;

public class EstadisticasDao {
    public void guardar(EstadisticasEstudiantesDto est) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("Estadisticas");
            doc.appendChild(root);
            Element maximo = doc.createElement("EdadMaxima");
            maximo.setTextContent(String.valueOf(est.getEdadMax()));
            Element min = doc.createElement("EdadMinima");
            min.setTextContent(String.valueOf(est.getEdadMin()));
            Element promedio = doc.createElement("EdadPromedio");
            promedio.setTextContent(String.valueOf(est.getEdadPromedio()));
            root.appendChild(maximo);
            root.appendChild(min);
            root.appendChild(promedio);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(
                    new DOMSource(doc),
                    new StreamResult(new File("File/persistencia.xml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
