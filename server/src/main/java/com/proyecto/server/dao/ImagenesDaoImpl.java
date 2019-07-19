package com.proyecto.server.dao;

import com.proyecto.server.models.Imagenes;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImagenesDaoImpl extends AbstractSession implements ImagenesDao {

    @Override
    public Imagenes buscarId(Long id) {
        return getSession().get(Imagenes.class, id);
    }

    @Override
    public Imagenes actualizarImagenes(Imagenes imagen) {
        getSession().update(imagen);
        return imagen;
    }

    @Override
    public Imagenes guardarImagenes(Imagenes imagen) {
        getSession().persist(imagen);
        return imagen;
    }

}
