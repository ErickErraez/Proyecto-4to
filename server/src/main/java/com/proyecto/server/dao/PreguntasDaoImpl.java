package com.proyecto.server.dao;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.proyecto.server.model.Preguntas;
import java.util.List;

@Repository
@Transactional
public class PreguntasDaoImpl extends AbstractSession implements PreguntasDao {

    @Override
    public Preguntas buscarId(Long id) {
        return getSession().get(Preguntas.class, id);
    }

    @Override
    public Preguntas actualizarPreguntas(Preguntas preguntas) {
        getSession().update(preguntas);
        return preguntas;
    }

    @Override
    public Preguntas guardarPreguntas(Preguntas preguntas) {
        getSession().persist(preguntas);
        return preguntas;
    }

    @Override
    public void borrarPreguntas(Long id) {
        Preguntas preguntas = buscarId(id);
        if (preguntas != null) {
            getSession().delete(preguntas);
        }
    }

    @Override
    public List<Preguntas> traerTodos() {
        return getSession().createQuery("from Preguntas").list();
    }

}
