package com.proyecto.server.dao;

import java.util.List;
import com.proyecto.server.model.SalasPreguntas;

public interface SalasPreguntasDao {

    SalasPreguntas buscarId(Long id);

    SalasPreguntas actualizarSalasPreguntas(SalasPreguntas salasPreguntas);

    SalasPreguntas guardarSalasPreguntas(SalasPreguntas salasPreguntas);

    void borrarSalasPreguntas(Long id);

    List<SalasPreguntas> traerTodos();

}
