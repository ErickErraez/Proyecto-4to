package com.proyecto.server.dao;

import com.proyecto.server.models.Salas;
import java.util.List;

public class SalasDaoImpl extends AbstractSession implements SalasDao {

    @Override
    public Salas buscarId(Long id) {
        return getSession().get(Salas.class, id);
    }

    @Override
    public Salas actualizarSalas(Salas salas) {
        getSession().update(salas);
        return salas;
    }

    @Override
    public Salas guardarSalas(Salas salas) {
        getSession().persist(salas);
        return salas;
    }

    @Override
    public void borrarSalas(Long id) {
        Salas salas = buscarId(id);
        if (salas != null) {
            getSession().delete(salas);
        }
    }

    @Override
    public List<Salas> traerTodos() {
        return getSession().createQuery("from Salas").list();
    }

}
