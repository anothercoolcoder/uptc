package com.uptc.programacion2.ServiceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uptc.programacion2.Management.EstudianteManagement;
import com.uptc.programacion2.entities.estudianteEntity;

@Service("ServicioEstudiante")
@Transactional
public class EstudianteServiceImplement implements com.uptc.programacion2.Services.EstudianteServices {

    @Autowired
    @Qualifier("CrudEstudiantes")
    EstudianteManagement em;

    @Override
    public List<estudianteEntity> listarEstudiantes() {
        return (List<estudianteEntity>) em.findAll();
    }

    @Override
    public estudianteEntity guardarEstudiante(estudianteEntity est) {
        em.save(est);
        return est;
    }
    @Override
    public String borrarEstudiante(Long id) {
        em.deleteById(id);
        return "Estudiante con ID " + id + " eliminado con exito";
    }
    // @Override
//     public estudianteEntity actualizarEstudiante(estudianteEntity estudianteEditado, int id) {
//         return em.findById(id).map(estudianteExistente -> {
//             estudianteExistente.setId(estudianteEditado.getId());
//             estudianteExistente.setNombre(estudianteEditado.getNombre());
//             estudianteExistente.setEdad(estudianteEditado.getEdad());
//             estudianteExistente.setGenero(estudianteEditado.getGenero());
//             return em.save(estudianteExistente);
//         }).orElseGet(() -> {
//             return em.save(estudianteEditado); // en caso de no existir
//         });
// }
    
}