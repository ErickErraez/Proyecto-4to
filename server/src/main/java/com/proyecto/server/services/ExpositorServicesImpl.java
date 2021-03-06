package com.proyecto.server.services;
import com.proyecto.server.dao.ExpositoresDao;
import com.proyecto.server.model.Expositores;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("expositorServices")
@Transactional
public class ExpositorServicesImpl implements ExpositorServices {

    @Autowired
    private ExpositoresDao _expositoresDao;

    @Override
    public Expositores buscarId(Long id) {
        return _expositoresDao.buscarId(id);
    }

    @Override
    public Expositores actualizarExpositores(Expositores expositor) {
        return _expositoresDao.actualizarExpositores(expositor);
    }

    @Override
    public Expositores guardarExpositores(Expositores expositor) {
        return _expositoresDao.guardarExpositores(expositor);
    }

    @Override
    public void borrarExpositor(Long id) {
        _expositoresDao.borrarExpositor(id);
    }

    @Override
    public List<Expositores> traerTodos() {
        return _expositoresDao.traerTodos();
    }

}
