package com.proyecto.server.controller;

import com.proyecto.server.model.Imagenes;
import com.proyecto.server.services.ImagenesServices;
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
@RequestMapping(value = "/imagenes")
@CrossOrigin(origins = "*")
public class ImagenesController {

    @Autowired
    private ImagenesServices _imagenServices;

    // OBTENER IMAGENES
    @RequestMapping(value = "/obtenerImagenes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Imagenes> getImagenById(@PathVariable("id") Long id) {
        Imagenes imagenes = _imagenServices.buscarId(id);
        if (imagenes == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Imagenes>(imagenes, HttpStatus.OK);
    }

    // GUARDAR IMAGENES
    @RequestMapping(value = "/guardarImagenes", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> guardarImagen(@RequestBody Imagenes imagenes, UriComponentsBuilder uriComponentsBuilder) {

        if (imagenes.getTipo().equals(null) || imagenes.getTipo().isEmpty() || imagenes.getAdjunto().equals(null) || imagenes.getAdjunto().isEmpty()) {
            return new ResponseEntity("Faltan Datos Necesarios", HttpStatus.CONFLICT);
        }
        _imagenServices.guardarImagenes(imagenes);

        return new ResponseEntity<Imagenes>(imagenes, HttpStatus.CREATED);

    }

    // ACTUALIZAR IMAGENES
    @RequestMapping(value = "/actualizarImagenes/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<?> actualizarImagen(@PathVariable("id") Long id, @RequestBody Imagenes imagen) {

        Imagenes imagenUpdate = _imagenServices.buscarId(id);
        if (imagenUpdate == null) {
            return new ResponseEntity("No se encuentra imagen", HttpStatus.NOT_FOUND);
        }

        imagenUpdate.setNombre(imagen.getNombre());
        imagenUpdate.setTipo(imagen.getTipo());
        imagenUpdate.setAdjunto(imagen.getAdjunto());

        _imagenServices.actualizarImagenes(imagenUpdate);

        return new ResponseEntity<Imagenes>(imagenUpdate, HttpStatus.OK);
    }

}
