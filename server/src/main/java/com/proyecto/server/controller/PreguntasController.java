package com.proyecto.server.controller;


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
import com.proyecto.server.model.Preguntas;
import com.proyecto.server.services.PreguntaServices;

@Controller
@RequestMapping(value = "/preguntas")
@CrossOrigin(origins = "*")
public class PreguntasController {
    
    @Autowired
    private PreguntaServices _preguntasServices;

    // OBTENER PREGUNTAS POR ID
    @RequestMapping(value = "/obtenerPreguntas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Preguntas> obtenerPreguntas(@PathVariable("id") Long id) {
        System.out.println("Entro");
        Preguntas preguntas = _preguntasServices.buscarId(id);
        if (preguntas == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Preguntas>(preguntas, HttpStatus.OK);
    }

    // OBTENER TODOS LOS PREGUNTAS
    @RequestMapping(value = "/obtenerPreguntas", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Preguntas>> obtenerPreguntas() {
        List<Preguntas> preguntas = new ArrayList<Preguntas>();
        
        preguntas = _preguntasServices.traerTodos();
        return new ResponseEntity<List<Preguntas>>(preguntas, HttpStatus.OK);
        
    }

    // GUARDAR PREGUNTAS
    @RequestMapping(value = "/guardarPreguntas", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> guardarPreguntas(@RequestBody Preguntas preguntas, UriComponentsBuilder uriComponentsBuilder) {
        
        if (preguntas.getNombre().equals(null) || preguntas.getNombre().isEmpty()) {
            return new ResponseEntity("Faltan Datos Necesarios", HttpStatus.CONFLICT);
        }
        _preguntasServices.guardarPreguntas(preguntas);
        
        return new ResponseEntity<Preguntas>(preguntas, HttpStatus.CREATED);
        
    }

    // ACTUALIZAR PREGUNTAS
    @RequestMapping(value = "/actualizarPreguntas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> actualizarPreguntas(@PathVariable("id") Long id, @RequestBody Preguntas preguntas) {
        
        Preguntas preguntasUpdate = _preguntasServices.buscarId(id);
        if (preguntasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }
        preguntasUpdate.setNombre(preguntas.getNombre());
        preguntasUpdate.setCorreo(preguntas.getCorreo());
        preguntasUpdate.setPregunta(preguntas.getPregunta());
        
        _preguntasServices.actualizarPreguntas(preguntasUpdate);
        
        return new ResponseEntity<Preguntas>(preguntasUpdate, HttpStatus.OK);
    }

    // BORRAR PREGUNTAS
    @RequestMapping(value = "/borrarPreguntas/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> borrarPreguntas(@PathVariable("id") Long id, @RequestBody Preguntas preguntas) {
        
        Preguntas preguntasUpdate = _preguntasServices.buscarId(id);
        if (preguntasUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }
        
        _preguntasServices.borrarPreguntas(id);
        
        return new ResponseEntity("Se ha borrado con exito", HttpStatus.OK);
    }
    
}
