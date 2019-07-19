package com.proyecto.server.dao;

import java.util.List;
import com.proyecto.server.models.Imagenes;

public interface ImagenesDao {

    Imagenes buscarId(Long id);

    Imagenes actualizarImagenes(Imagenes imagen);

    Imagenes guardarImagenes(Imagenes imagen);

}
