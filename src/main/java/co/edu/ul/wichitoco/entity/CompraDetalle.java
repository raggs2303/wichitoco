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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "compra_detalle", catalog = "wichitocodb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraDetalle.findAll", query = "SELECT c FROM CompraDetalle c"),
    @NamedQuery(name = "CompraDetalle.findByConsecutivo", query = "SELECT c FROM CompraDetalle c WHERE c.consecutivo = :consecutivo"),
    @NamedQuery(name = "CompraDetalle.findByCantidad", query = "SELECT c FROM CompraDetalle c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CompraDetalle.findByCosto", query = "SELECT c FROM CompraDetalle c WHERE c.costo = :costo"),
    @NamedQuery(name = "CompraDetalle.findByEstado", query = "SELECT c FROM CompraDetalle c WHERE c.estado = :estado")})
public class CompraDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private Integer consecutivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private long costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "compra", referencedColumnName = "consecutivo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compra compra;
    @JoinColumn(name = "producto", referencedColumnName = "consecutivo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;

    public CompraDetalle() {
    }

    public CompraDetalle(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public CompraDetalle(Integer consecutivo, int cantidad, long costo, String estado) {
        this.consecutivo = consecutivo;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consecutivo != null ? consecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        return object instanceof CompraDetalle && ((CompraDetalle) object).consecutivo != null && this.consecutivo.equals(((CompraDetalle) object).consecutivo);
    }

    @Override
    public String toString() {
        return "co.edu.ul.wichitoco.entity.CompraDetalle[ consecutivo=" + consecutivo + " ]";
    }

}
