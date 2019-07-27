package com.proyecto.server.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salasPreguntas")
public class SalasPreguntas implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idSala")
    private Salas salas;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPregunta")
    private Preguntas preguntas;
    
    
    @Column(name = "estado")
    private String estado;

    public SalasPreguntas() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SalasPreguntas(Salas salas, Preguntas preguntas) {
        super();
        this.salas = salas;
        this.preguntas = preguntas;

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
     * @return the salas
     */
    public Salas getSalas() {
        return salas;
    }

    /**
     * @param salas the salas to set
     */
    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    /**
     * @return the preguntas
     */
    public Preguntas getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
