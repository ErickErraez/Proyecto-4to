package com.proyecto.server.services;

import java.util.List;
import com.proyecto.server.model.Imagenes;

public interface ImagenesServices {

    Imagenes guardarImagenes(Imagenes imagen);

    Imagenes buscarId(Long id);

    Imagenes actualizarImagenes(Imagenes imagen);

}
