package com.proyecto.server.services;

import com.proyecto.server.model.Expositores;
import java.util.List;

public interface ExpositorServices {

    Expositores buscarId(Long id);

    Expositores actualizarExpositores(Expositores expositor);

    Expositores guardarExpositores(Expositores expositor);

    void borrarExpositor(Long id);

    List<Expositores> traerTodos();

}
