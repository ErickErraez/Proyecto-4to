package com.proyecto.server.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Imagenes")
public class Imagenes implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipoArchivo;

    @Column(name = "nombre")
    private String nombreArchivo;

    @Column(name = "adjunto")
    private String adjuntoArchivo;

    public Imagenes() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Imagenes(String tipoArchivo, String nombreArchivo, String adjuntoArchivo) {
        super();
        this.tipoArchivo = tipoArchivo;
        this.nombreArchivo = nombreArchivo;
        this.adjuntoArchivo = adjuntoArchivo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the tipoArchivo
     */
    public String getTipoArchivo() {
        return tipoArchivo;
    }

    /**
     * @param tipoArchivo the tipoArchivo to set
     */
    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the adjuntoArchivo
     */
    public String getAdjuntoArchivo() {
        return adjuntoArchivo;
    }

    /**
     * @param adjuntoArchivo the adjuntoArchivo to set
     */
    public void setAdjuntoArchivo(String adjuntoArchivo) {
        this.adjuntoArchivo = adjuntoArchivo;
    }

}
