package com.proyecto.server.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.ImagenesDao;
import com.proyecto.server.models.Imagenes;

@Service("imagenesServices")
@Transactional
public class ImagenesServicesImpl implements ImagenesServices {

    @Autowired
    private ImagenesDao _imagenesDao;

    @Override
    public Imagenes guardarImagenes(Imagenes imagen) {
        return _imagenesDao.guardarImagenes(imagen);
    }

    @Override
    public Imagenes buscarId(Long id) {
        return _imagenesDao.buscarId(id);
    }

    @Override
    public Imagenes actualizarImagenes(Imagenes imagen) {
        return _imagenesDao.actualizarImagenes(imagen);
    }

}
