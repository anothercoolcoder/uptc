package com.uptc.programacion2.controller;

import java.util.List;

// import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.uptc.programacion2.ServiceImplement.EstudianteServiceImplement;
import com.uptc.programacion2.entities.estudianteEntity;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class estudianteController {


    @Autowired
    @Qualifier("ServicioEstudiante")
    EstudianteServiceImplement estimpl;
    
    @GetMapping(path="/listar",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<estudianteEntity> getStudents(){
        return estimpl.listarEstudiantes();
    }
    
    @PostMapping(path="/guardar",consumes=MediaType.APPLICATION_JSON_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<estudianteEntity> crear(@RequestBody estudianteEntity estudiante){
        estudianteEntity newEst = estimpl.guardarEstudiante(estudiante);
        return ResponseEntity.ok(newEst);
    }
    @DeleteMapping(path="/borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable("id") Long id) {
        String message = estimpl.borrarEstudiante(id);
        return ResponseEntity.ok(message);
    }
    @PutMapping(path="/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<estudianteEntity> actualizar (@RequestBody estudianteEntity estudiante, @PathVariable("id") Long id){
        estudiante.setId(id);
        estudianteEntity actualizado = estimpl.guardarEstudiante(estudiante);
        return ResponseEntity.ok(actualizado);
    }
}
