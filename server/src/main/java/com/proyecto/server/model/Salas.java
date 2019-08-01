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
@Table(name = "salas")
public class Salas implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tema")
    private String tema;

    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "preguntasPermitidas")
    private int preguntasPermitidas;

    @Column(name = "estado")
    private String estado;

    @Column(name = "personasIngresadas")
    private int personasIngresadas;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idExpositor")
    private Expositores expositores;

    public Salas() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Salas(String codigo, String nombre, String tema, int capacidad, int preguntasPermitidas, Expositores expositor) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.tema = tema;
        this.capacidad = capacidad;
        this.preguntasPermitidas = preguntasPermitidas;
        this.expositores = expositor;

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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the preguntasPermitidas
     */
    public int getPreguntasPermitidas() {
        return preguntasPermitidas;
    }

    /**
     * @param preguntasPermitidas the preguntasPermitidas to set
     */
    public void setPreguntasPermitidas(int preguntasPermitidas) {
        this.preguntasPermitidas = preguntasPermitidas;
    }

    /**
     * @return the expositores
     */
    public Expositores getExpositores() {
        return expositores;
    }

    /**
     * @param expositores the expositores to set
     */
    public void setExpositores(Expositores expositores) {
        this.expositores = expositores;
    }

    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the personasIngresadas
     */
    public int getPersonasIngresadas() {
        return personasIngresadas;
    }

    /**
     * @param personasIngresadas the personasIngresadas to set
     */
    public void setPersonasIngresadas(int personasIngresadas) {
        this.personasIngresadas = personasIngresadas;
    }

    
    
}
