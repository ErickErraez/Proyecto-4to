package com.proyecto.server.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.SalasPreguntasDao;
import com.proyecto.server.models.SalasPreguntas;
import java.util.List;

@Service("salasPreguntasServices")
@Transactional
public class SalasPreguntasServicesImpl implements SalasPreguntasServices {

    @Autowired
    private SalasPreguntasDao _imagenesDao;

    @Override
    public SalasPreguntas buscarId(Long id) {
        return _imagenesDao.buscarId(id);
    }

    @Override
    public SalasPreguntas actualizarSalasPreguntas(SalasPreguntas salasPreguntas) {
        return _imagenesDao.actualizarSalasPreguntas(salasPreguntas);
    }

    @Override
    public SalasPreguntas guardarSalasPreguntas(SalasPreguntas salasPreguntas) {
        return _imagenesDao.guardarSalasPreguntas(salasPreguntas);
    }

    @Override
    public void borrarSalasPreguntas(Long id) {
        _imagenesDao.borrarSalasPreguntas(id);
    }

    @Override
    public List<SalasPreguntas> traerTodos() {
        return _imagenesDao.traerTodos();
    }

}
