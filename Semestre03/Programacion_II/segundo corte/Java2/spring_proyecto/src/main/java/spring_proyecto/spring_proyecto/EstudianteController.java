package spring_proyecto.spring_proyecto;

import org.springframework.web.bind.annotation.*; // Esto importa todo lo de web

@RestController
@CrossOrigin
@RequestMapping("/gestionEstudiantes")
public class EstudianteController {

    @GetMapping
    public String obtenerMensaje() {
        return "Conexión exitosa";
    }
}