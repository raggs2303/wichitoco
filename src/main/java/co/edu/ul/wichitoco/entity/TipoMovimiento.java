/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ul.wichitoco.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rosbelly Benitez
 */
@Entity
@Table(name = "tipo_movimiento", catalog = "wichitocodb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimiento.findAll", query = "SELECT t FROM TipoMovimiento t"),
    @NamedQuery(name = "TipoMovimiento.findByConsecutivo", query = "SELECT t FROM TipoMovimiento t WHERE t.consecutivo = :consecutivo"),
    @NamedQuery(name = "TipoMovimiento.findByNombre", query = "SELECT t FROM TipoMovimiento t WHERE t.nombre = :nombre")})
public class TipoMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private Integer consecutivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;

    public TipoMovimiento() {
    }

    public TipoMovimiento(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public TipoMovimiento(Integer consecutivo, String nombre) {
        this.consecutivo = consecutivo;
        this.nombre = nombre;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consecutivo != null ? consecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        return object instanceof TipoMovimiento && ((TipoMovimiento) object).consecutivo != null && this.consecutivo.equals(((TipoMovimiento) object).consecutivo);
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

}
