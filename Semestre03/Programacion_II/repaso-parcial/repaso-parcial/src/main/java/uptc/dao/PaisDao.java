package uptc.dao;

import uptc.model.PaisModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaisDao {
    private String rutaArchivo;

    public PaisDao(String ruta) {
        this.rutaArchivo = ruta;
    }

    public List<PaisModel> obtenerPaises() {
        System.out.println("Buscando en: " + new File(rutaArchivo).getAbsolutePath());
        try {
            File archivo = new File(rutaArchivo);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("pais");

            return IntStream.range(0, nList.getLength())
                .mapToObj(nList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .map(this::mapearAPaisModel)
                .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("Error al leer XML: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private PaisModel mapearAPaisModel(Element e) {
        int id = Integer.parseInt(e.getAttribute("id"));
        String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();

        NodeList dList = e.getElementsByTagName("departamento");
        List<String> depts = IntStream.range(0, dList.getLength())
                .mapToObj(i -> dList.item(i).getTextContent())
                .collect(Collectors.toList());

        return new PaisModel(id, nombre, depts);
    }
}