package parcial2_andres_nino.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class ClienteJsonDao {
    
    private List<Estudiante> leerArchivo() {
        try (Reader reader = new FileReader(archivo)) {
            Type tipoLista = new TypeToken<List<Estudiante>>() {
            }.getType();
            List<Estudiante> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
