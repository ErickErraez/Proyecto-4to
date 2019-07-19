package com.proyecto.server.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.SalasDao;
import com.proyecto.server.model.Salas;
import java.util.List;

@Service("salasServices")
@Transactional
public class SalaServicesImpl implements SalasServices {

    @Autowired
    private SalasDao _salasDao;

    @Override
    public Salas buscarId(Long id) {
        return _salasDao.buscarId(id);
    }

    @Override
    public Salas actualizarSalas(Salas salas) {
        return _salasDao.actualizarSalas(salas);
    }

    @Override
    public Salas guardarSalas(Salas salas) {
        return _salasDao.guardarSalas(salas);
    }

    @Override
    public void borrarSalas(Long id) {
        _salasDao.borrarSalas(id);
    }

    @Override
    public List<Salas> traerTodos() {
        return _salasDao.traerTodos();
    }

}
