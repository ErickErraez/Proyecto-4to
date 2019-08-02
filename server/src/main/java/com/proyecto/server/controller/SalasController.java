package com.proyecto.server.controller;

import com.proyecto.server.model.Expositores;
import com.proyecto.server.model.Salas;
import com.proyecto.server.services.ExpositorServices;
import com.proyecto.server.services.SalasServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/salas")
@CrossOrigin(origins = "*")
public class SalasController {

    @Autowired
    private SalasServices _salaServices;
    @Autowired
    private ExpositorServices _expositorServices;

    // OBTENER SALAS POR ID
    @RequestMapping(value = "/obtenerSalas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Salas> obtenerSalas(@PathVariable("id") Long id) {
        Salas salas = _salaServices.buscarId(id);
        if (salas == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Salas>(salas, HttpStatus.OK);
    }

    // OBTENER TODOS LOS SALAS
    @RequestMapping(value = "/obtenerSalas", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Salas>> obtenerSalas() {
        List<Salas> salas = new ArrayList<Salas>();

        salas = _salaServices.traerTodos();
        return new ResponseEntity<List<Salas>>(salas, HttpStatus.OK);

    }

    // GUARDAR SALAS
    @RequestMapping(value = "/guardarSalas", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> guardarSalas(@RequestBody Salas salas, UriComponentsBuilder uriComponentsBuilder) {

        if (salas.getNombre().equals(null) || salas.getNombre().isEmpty()) {
            return new ResponseEntity("Faltan Datos Necesarios", HttpStatus.CONFLICT);
        }
        _salaServices.guardarSalas(salas);

        return new ResponseEntity<Salas>(salas, HttpStatus.CREATED);

    }

    // ACTUALIZAR SALAS
    @RequestMapping(value = "/actualizarSalas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> actualizarSalas(@PathVariable("id") Long id, @RequestBody Salas salas) {

        Salas salasUpdate = _salaServices.buscarId(id);
        if (salasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        salasUpdate.setNombre(salas.getNombre());
        salasUpdate.setCodigo(salas.getCodigo());
        salasUpdate.setTema(salas.getTema());
        salasUpdate.setCapacidad(salas.getCapacidad());
        salasUpdate.setPreguntasPermitidas(salas.getPreguntasPermitidas());
        salasUpdate.setEstado(salas.getEstado());
        salasUpdate.setPersonasIngresadas(salas.getPersonasIngresadas());
        salasUpdate.setExpositores(salas.getExpositores());

        _salaServices.actualizarSalas(salasUpdate);

        return new ResponseEntity<Salas>(salasUpdate, HttpStatus.OK);
    }

    // BORRAR SALAS
    @RequestMapping(value = "/borrarSalas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> borrarSalas(@PathVariable("id") Long id, @RequestBody Salas salas) {

        Salas salasUpdate = _salaServices.buscarId(id);
        if (salasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        _salaServices.borrarSalas(id);

        return new ResponseEntity("Se ha borrado con exito", HttpStatus.OK);
    }

    //ASIGNAR EXPOSITOR A LA SALA
    @RequestMapping(value = "/salaexpo", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Salas> expositoresToImage(@RequestBody Salas sala,
            UriComponentsBuilder ucBuilder) {

        if (sala.getId() == null || sala.getExpositores().getId() == null) {
            return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
        }
        Salas salasSaved = _salaServices.buscarId(sala.getId());
        if (salasSaved == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        Expositores expositor = _expositorServices.buscarId(sala.getExpositores().getId());
        if (expositor == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        salasSaved.setExpositores(expositor);
        _salaServices.actualizarSalas(salasSaved);

        return new ResponseEntity<Salas>(salasSaved, HttpStatus.OK);
    }

    @RequestMapping(value = "/obtenerSalasCodigo/{codigo}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Salas> obtenerSalas(@PathVariable("codigo") String codigo) {
        Salas salas = _salaServices.buscarCodigo(codigo);
        if (salas == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Salas>(salas, HttpStatus.OK);
    }

}
