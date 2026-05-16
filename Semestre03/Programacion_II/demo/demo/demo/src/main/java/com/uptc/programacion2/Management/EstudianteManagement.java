package com.uptc.programacion2.Management;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uptc.programacion2.entities.estudianteEntity;

@Repository("CrudEstudiantes")
public interface EstudianteManagement extends CrudRepository<estudianteEntity, Long> {
    //cambie de int a Long

}