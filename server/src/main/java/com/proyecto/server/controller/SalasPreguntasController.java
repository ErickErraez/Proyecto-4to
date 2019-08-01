package com.proyecto.server.controller;

import com.proyecto.server.model.Preguntas;
import com.proyecto.server.model.Salas;
import com.proyecto.server.model.SalasPreguntas;
import com.proyecto.server.services.PreguntaServices;
import com.proyecto.server.services.SalasPreguntasServices;
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
@RequestMapping(value = "/salasPreguntas")
@CrossOrigin(origins = "*")
public class SalasPreguntasController {

    @Autowired
    private SalasPreguntasServices _salaPreguntasServices;
    @Autowired
    private SalasServices _salaServices;
    @Autowired
    private PreguntaServices _preguntaServices;

    // OBTENER PREGUNTAS POR ID
    @RequestMapping(value = "/obtenerSalaspreguntas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<SalasPreguntas> obtenerSalasPreguntas(@PathVariable("id") Long id) {
        SalasPreguntas salasPreguntas = _salaPreguntasServices.buscarId(id);
        if (salasPreguntas == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<SalasPreguntas>(salasPreguntas, HttpStatus.OK);
    }

    // OBTENER TODOS LOS PREGUNTAS
    @RequestMapping(value = "/obtenerSalasPreguntas", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<SalasPreguntas>> obtenerSalasPreguntas() {
        List<SalasPreguntas> salasPreguntas = new ArrayList<SalasPreguntas>();

        salasPreguntas = _salaPreguntasServices.traerTodos();
        return new ResponseEntity<List<SalasPreguntas>>(salasPreguntas, HttpStatus.OK);

    }

    // GUARDAR PREGUNTAS
    @RequestMapping(value = "/guardarSalasPreguntas", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> guardarSalasPreguntas(@RequestBody SalasPreguntas salasPreguntas, UriComponentsBuilder uriComponentsBuilder) {

        if (salasPreguntas.getSalas().equals(null)) {
            return new ResponseEntity("Faltan Datos Necesarios", HttpStatus.CONFLICT);
        }
        _salaPreguntasServices.guardarSalasPreguntas(salasPreguntas);

        return new ResponseEntity<SalasPreguntas>(salasPreguntas, HttpStatus.CREATED);

    }

    // ACTUALIZAR PREGUNTAS
    @RequestMapping(value = "/actualizarSalasPreguntas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> actualizarSalasPreguntas(@PathVariable("id") Long id, @RequestBody SalasPreguntas salasPreguntas) {

        SalasPreguntas salasPreguntasUpdate = _salaPreguntasServices.buscarId(id);
        if (salasPreguntasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        salasPreguntasUpdate.setSalas(salasPreguntasUpdate.getSalas());
        salasPreguntasUpdate.setPreguntas(salasPreguntasUpdate.getPreguntas());

        return new ResponseEntity<SalasPreguntas>(salasPreguntasUpdate, HttpStatus.OK);
    }

    // BORRAR PREGUNTAS
    @RequestMapping(value = "/borrarSalasPregunta/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> borrarsalasPreguntasUpdate(@PathVariable("id") Long id, @RequestBody SalasPreguntas salasPreguntas) {

        SalasPreguntas salasPreguntasUpdate = _salaPreguntasServices.buscarId(id);
        if (salasPreguntasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        _salaPreguntasServices.borrarSalasPreguntas(id);

        return new ResponseEntity("Se ha borrado con exito", HttpStatus.OK);
    }

    @RequestMapping(value = "/salapreguntas", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<SalasPreguntas> assignAplicacionesToImage(@RequestBody SalasPreguntas salpre,
            UriComponentsBuilder ucBuilder) {

        if (salpre.getId() == null || salpre.getSalas().getId() == null) {
            return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
        }
        if (salpre.getId() == null || salpre.getPreguntas().getId() == null) {
            return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
        }
        SalasPreguntas salasPreSaved = _salaPreguntasServices.buscarId(salpre.getId());
        if (salasPreSaved == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        Salas salas = _salaServices.buscarId(salpre.getSalas().getId());
        if (salas == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        Preguntas pre = _preguntaServices.buscarId(salpre.getPreguntas().getId());
        if (pre == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        salasPreSaved.setPreguntas(pre);
        salasPreSaved.setSalas(salas);
        _salaPreguntasServices.actualizarSalasPreguntas(salasPreSaved);

        return new ResponseEntity<SalasPreguntas>(salasPreSaved, HttpStatus.OK);
    }

}
