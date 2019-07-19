package com.proyecto.server.dao;

import java.util.List;
import com.proyecto.server.models.Expositores;

public interface ExpositoresDao {

    Expositores buscarId(Long id);

    Expositores actualizarExpositores(Expositores expositor);

    Expositores guardarExpositores(Expositores expositor);

    void borrarExpositor(Long id);

    List<Expositores> traerTodos();

}
