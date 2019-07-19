package com.proyecto.server.controller;

import com.proyecto.server.model.SalasPreguntas;
import com.proyecto.server.services.SalasPreguntasServices;
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
@RequestMapping(value = "/salaspreguntas")
@CrossOrigin(origins = "*")
public class SalasPreguntasController {

    @Autowired
    private SalasPreguntasServices _preguntasServices;

    // OBTENER PREGUNTAS POR ID
    @RequestMapping(value = "/obtenerSalaspreguntas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<SalasPreguntas> obtenerSalasPreguntas(@PathVariable("id") Long id) {
        SalasPreguntas salasPreguntas = _preguntasServices.buscarId(id);
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

        salasPreguntas = _preguntasServices.traerTodos();
        return new ResponseEntity<List<SalasPreguntas>>(salasPreguntas, HttpStatus.OK);

    }

    // GUARDAR PREGUNTAS
    @RequestMapping(value = "/guardarSalasPreguntas", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> guardarSalasPreguntas(@RequestBody SalasPreguntas salasPreguntas, UriComponentsBuilder uriComponentsBuilder) {

        if (salasPreguntas.getSalas().equals(null)) {
            return new ResponseEntity("Faltan Datos Necesarios", HttpStatus.CONFLICT);
        }
        _preguntasServices.guardarSalasPreguntas(salasPreguntas);

        return new ResponseEntity<SalasPreguntas>(salasPreguntas, HttpStatus.CREATED);

    }

    // ACTUALIZAR PREGUNTAS
    @RequestMapping(value = "/actualizarSalasPreguntas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> actualizarSalasPreguntas(@PathVariable("id") Long id, @RequestBody SalasPreguntas salasPreguntas) {

        SalasPreguntas salasPreguntasUpdate = _preguntasServices.buscarId(id);
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

        SalasPreguntas salasPreguntasUpdate = _preguntasServices.buscarId(id);
        if (salasPreguntasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        _preguntasServices.borrarSalasPreguntas(id);

        return new ResponseEntity("Se ha borrado con exito", HttpStatus.OK);
    }

}
