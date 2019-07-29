package com.proyecto.server.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.PreguntasDao;
import com.proyecto.server.model.Preguntas;
import java.util.List;

@Service("preguntasServices")
@Transactional
public class PreguntaServicesImpl implements PreguntaServices {

    @Autowired
    private PreguntasDao _preguntasDao;

    @Override
    public Preguntas buscarId(Long id) {
        return _preguntasDao.buscarId(id);
    }

    @Override
    public Preguntas actualizarPreguntas(Preguntas preguntas) {
        return _preguntasDao.actualizarPreguntas(preguntas);
    }

    @Override
    public Preguntas guardarPreguntas(Preguntas preguntas) {
        return _preguntasDao.guardarPreguntas(preguntas);
    }

    @Override
    public void borrarPreguntas(Long id) {
         _preguntasDao.borrarPreguntas(id);
    }

    @Override
    public List<Preguntas> traerTodos() {
        return _preguntasDao.traerTodos();
    }

}
