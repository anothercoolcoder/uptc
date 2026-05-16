package com.uptc.programacion2.Services;

import java.util.List;
import com.uptc.programacion2.entities.estudianteEntity;

public interface EstudianteServices {

    List<estudianteEntity> listarEstudiantes();

    estudianteEntity guardarEstudiante(estudianteEntity est);

    String borrarEstudiante(Long id);
}