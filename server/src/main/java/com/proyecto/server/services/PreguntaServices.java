package com.proyecto.server.services;

import java.util.List;
import com.proyecto.server.models.Preguntas;

public interface PreguntaServices {

    Preguntas buscarId(Long id);

    Preguntas actualizarPreguntas(Preguntas preguntas);

    Preguntas guardarPreguntas(Preguntas preguntas);

    void borrarPreguntas(Long id);

    List<Preguntas> traerTodos();

}
