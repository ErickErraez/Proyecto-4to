package com.proyecto.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.server.model.Expositores;
import com.proyecto.server.model.Imagenes;
import com.proyecto.server.services.ExpositorServices;
import com.proyecto.server.services.ImagenesServices;

@Controller
@RequestMapping(value = "/expositores")
@CrossOrigin(origins = "*")
public class ExpositoresController {

    @Autowired
    private ExpositorServices _expositorServices;
    @Autowired
    private ImagenesServices _imageServices;

    // OBTENER EXPOSITORES POR ID
    @RequestMapping(value = "/obtenerExpositor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Expositores> getImagenById(@PathVariable("id") Long id) {
        Expositores expositores = _expositorServices.buscarId(id);
        if (expositores == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Expositores>(expositores, HttpStatus.OK);
    }

    // OBTENER TODOS LOS EXPOSITORES
    @RequestMapping(value = "/obtenerExpositores", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Expositores>> obtenerExpositores() {
        List<Expositores> expositores = new ArrayList<Expositores>();

        expositores = _expositorServices.traerTodos();
        return new ResponseEntity<List<Expositores>>(expositores, HttpStatus.OK);

    }

    // GUARDAR EXPOSITORES
    @RequestMapping(value = "/guardarExpositores", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> guardarExpositores(@RequestBody Expositores expositores, UriComponentsBuilder uriComponentsBuilder) {

        if (expositores.getNombre().equals(null) || expositores.getNombre().isEmpty()) {
            return new ResponseEntity("Faltan Datos Necesarios", HttpStatus.CONFLICT);
        }
        _expositorServices.guardarExpositores(expositores);

        return new ResponseEntity<Expositores>(expositores, HttpStatus.CREATED);

    }

    // ACTUALIZAR IMAGENES
    @RequestMapping(value = "/actualizarExpositores/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> actualizarExpositores(@PathVariable("id") Long id, @RequestBody Expositores expositores) {

        Expositores expositoresUpdate = _expositorServices.buscarId(id);
        if (expositoresUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        expositoresUpdate.setNombre(expositores.getNombre());
        expositoresUpdate.setApellido(expositores.getApellido());
        expositoresUpdate.setCorreo(expositores.getCorreo());
        expositoresUpdate.setTelefono(expositores.getTelefono());
        expositoresUpdate.setTitulo(expositores.getTitulo());
        expositoresUpdate.setInstitucion(expositores.getInstitucion());
        expositoresUpdate.setImagenes(expositores.getImagenes());

        _expositorServices.actualizarExpositores(expositoresUpdate);

        return new ResponseEntity<Expositores>(expositoresUpdate, HttpStatus.OK);
    }

    // BORRAR EXPOSITOR
    @RequestMapping(value = "/borrarExpositores/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> borrarExpositores(@PathVariable("id") Long id, @RequestBody Expositores expositores) {

        Expositores expositoresUpdate = _expositorServices.buscarId(id);
        if (expositoresUpdate == null) {
            return new ResponseEntity("No se encuentra expositor", HttpStatus.NOT_FOUND);
        }

        _expositorServices.borrarExpositor(id);

        return new ResponseEntity("Se ha borrado con exito", HttpStatus.OK);
    }

    // ASIGNAR IMAGEN EXPOSITOR
    @RequestMapping(value = "/expofoto", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Expositores> expositoresToImage(@RequestBody Expositores expo,
            UriComponentsBuilder ucBuilder) {

        if (expo.getId() == null || expo.getImagenes().getId() == null) {
            return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
        }
        Expositores expoSaved = _expositorServices.buscarId(expo.getId());
        if (expoSaved == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        Imagenes image = _imageServices.buscarId(expo.getImagenes().getId());
        if (image == null) {
            return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
        }
        expoSaved.setImagenes(image);
        _expositorServices.actualizarExpositores(expoSaved);

        return new ResponseEntity<Expositores>(expoSaved, HttpStatus.OK);
    }

}
