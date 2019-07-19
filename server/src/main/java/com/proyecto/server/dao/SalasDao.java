package com.proyecto.server.dao;

import java.util.List;
import com.proyecto.server.models.Salas;

public interface SalasDao {

    Salas buscarId(Long id);

    Salas actualizarSalas(Salas salas);

    Salas guardarSalas(Salas salas);

    void borrarSalas(Long id);

    List<Salas> traerTodos();

}
