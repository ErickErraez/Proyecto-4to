package com.proyecto.server.services;

import java.util.List;
import com.proyecto.server.model.Salas;

public interface SalasServices {

    Salas buscarId(Long id);

    Salas actualizarSalas(Salas salas);

    Salas guardarSalas(Salas salas);

    void borrarSalas(Long id);

    List<Salas> traerTodos();

}
