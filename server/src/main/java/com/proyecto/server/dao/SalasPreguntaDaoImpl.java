package com.proyecto.server.dao;

import com.proyecto.server.model.SalasPreguntas;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SalasPreguntaDaoImpl extends AbstractSession implements SalasPreguntasDao {

    @Override
    public SalasPreguntas buscarId(Long id) {
        return getSession().get(SalasPreguntas.class, id);
    }

    @Override
    public SalasPreguntas actualizarSalasPreguntas(SalasPreguntas salasPreguntas) {
        getSession().update(salasPreguntas);
        return salasPreguntas;
    }

    @Override
    public SalasPreguntas guardarSalasPreguntas(SalasPreguntas salasPreguntas) {
        getSession().persist(salasPreguntas);
        return salasPreguntas;
    }

    @Override
    public void borrarSalasPreguntas(Long id) {
        SalasPreguntas salasPreguntas = buscarId(id);
        if (salasPreguntas != null) {
            getSession().delete(salasPreguntas);
        }
    }

    @Override
    public List<SalasPreguntas> traerTodos() {
        return getSession().createQuery("from SalasPreguntas").list();
    }

}
