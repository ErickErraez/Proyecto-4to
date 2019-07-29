package com.proyecto.server.dao;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.proyecto.server.model.Expositores;
import java.util.List;

@Repository
@Transactional
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
