package com.proyecto.server.model;

import com.sun.org.apache.bcel.internal.generic.L2D;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "imagenes")
public class Imagenes implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "adjunto")
    @Type(type="text")
    private String adjunto;

    public Imagenes() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Imagenes(String tipo, String nombre, String adjunto) {
        super();
        this.tipo = tipo;
        this.nombre = nombre;
        this.adjunto = adjunto;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the adjunto
     */
    public String getAdjunto() {
        return adjunto;
    }

    /**
     * @param adjunto the adjunto to set
     */
    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

}
