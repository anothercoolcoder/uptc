package dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Student;

public class StudentDao {
    // Cambiado a 'estudiantes.json' para coincidir con tu archivo real
    private final String file = "File/estudiantes.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<Student> readFile() {
        try (Reader reader = new FileReader(file)) {
            Type typeList = new TypeToken<List<Student>>() {}.getType();
            List<Student> list = gson.fromJson(reader, typeList);
            return (list != null) ? list : new ArrayList<>();
        } catch (IOException e) {
            // Si el archivo no existe o está vacío, retornamos lista nueva
            return new ArrayList<>();
        }
    }

    private void write(List<Student> students) {
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void create(Student e) {
        List<Student> students = readFile();
        students.add(e);
        write(students);
    }

    public List<Student> list() {
        return readFile();
    }

    public Student searchId(int id) {
        return readFile().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Student updateStudent) {
        List<Student> students = readFile();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updateStudent.getId()) {
                students.set(i, updateStudent);
                break;
            }
        }
        write(students);
    }

    public void remove(int id) {
        List<Student> estudiantes = readFile();
        estudiantes.removeIf(e -> e.getId() == id);
        write(estudiantes);
    }
}