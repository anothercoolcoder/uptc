package uptc.dao;
import uptc.model.HistorialMedicoModel;
import uptc.model.PacienteModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class PacienteDao {
    private String rutaArchivo;
    HistorialMedicoDao historialMedicoDao = new HistorialMedicoDao();

    public PacienteDao(String ruta){
        this.rutaArchivo = ruta;
    }

    public List<PacienteModel> obtenerPacientes() {
        System.out.println("Buscando en: " + new File(rutaArchivo).getAbsolutePath());
        try {
            File archivo = new File(rutaArchivo);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("paciente");

            return IntStream.range(0, nList.getLength())
                .mapToObj(nList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .map(this::mapearAPacienteModel)
                .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("Error al leer XML: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    private PacienteModel mapearAPacienteModel(Element e) {
        int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
        String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
        int edad = Integer.parseInt(e.getElementsByTagName("edad").item(0).getTextContent());
        String genero = e.getElementsByTagName("genero").item(0).getTextContent();
        String enfermedad = e.getElementsByTagName("enfermedad").item(0).getTextContent();
        String ciudad = e.getElementsByTagName("ciudad").item(0).getTextContent();
    return new PacienteModel(id, nombre, edad, genero, enfermedad, ciudad, traerInformacionJson(id));        
    }

    public HistorialMedicoModel traerInformacionJson(int id){
        return historialMedicoDao.readFile().stream().filter(e -> e.getIdPaciente() == id).findFirst().orElse(null);
    }

}
