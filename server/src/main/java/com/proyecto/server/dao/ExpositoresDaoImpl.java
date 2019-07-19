package com.proyecto.server.dao;

import com.proyecto.server.models.Expositores;
import java.util.List;

public class ExpositoresDaoImpl extends AbstractSession implements ExpositoresDao {

    @Override
    public Expositores buscarId(Long id) {
        return getSession().get(Expositores.class, id);
    }

    @Override
    public Expositores actualizarExpositores(Expositores expositor) {
        getSession().update(expositor);
        return expositor;
    }

    @Override
    public Expositores guardarExpositores(Expositores expositor) {
        getSession().persist(expositor);
        return expositor;
    }

    @Override
    public void borrarExpositor(Long id) {
        Expositores expositor = buscarId(id);
        if (expositor != null) {
            getSession().delete(expositor);
        }
    }

    @Override
    public List<Expositores> traerTodos() {
        return getSession().createQuery("from Expositores").list();
    }

}
