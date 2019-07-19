package com.proyecto.server.dao;

import java.util.List;
import com.proyecto.server.models.Preguntas;

public interface PreguntasDao {

    Preguntas buscarId(Long id);

    Preguntas actualizarPreguntas(Preguntas preguntas);

    Preguntas guardarPreguntas(Preguntas preguntas);

    void borrarPreguntas(Long id);

    List<Preguntas> traerTodos();

}
