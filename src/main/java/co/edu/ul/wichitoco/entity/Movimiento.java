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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rosbelly Benitez
 */
@Entity
@Table(name = "movimiento", catalog = "wichitocodb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByConsecutivo", query = "SELECT m FROM Movimiento m WHERE m.consecutivo = :consecutivo"),
    @NamedQuery(name = "Movimiento.findByCantidad", query = "SELECT m FROM Movimiento m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "Movimiento.findByValor", query = "SELECT m FROM Movimiento m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimiento.findByEstado", query = "SELECT m FROM Movimiento m WHERE m.estado = :estado"),
    @NamedQuery(name = "Movimiento.findByDocumento", query = "SELECT m FROM Movimiento m WHERE m.documento = :documento")})
public class Movimiento implements Serializable {

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
    @Column(name = "valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "documento")
    private String documento;
    @JoinColumn(name = "producto", referencedColumnName = "consecutivo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "tipo", referencedColumnName = "consecutivo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoMovimiento tipo;

    public Movimiento() {
    }

    public Movimiento(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Movimiento(Integer consecutivo, int cantidad, long valor, String estado, String documento) {
        this.consecutivo = consecutivo;
        this.cantidad = cantidad;
        this.valor = valor;
        this.estado = estado;
        this.documento = documento;
    }
    
    @PrePersist
    protected void prePersist(){
        this.setEstado("A");
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

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consecutivo != null ? consecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        return object instanceof Movimiento && ((Movimiento) object).consecutivo != null && this.consecutivo.equals(((Movimiento) object).consecutivo);
    }

    @Override
    public String toString() {
        return this.getDocumento().concat(" - ").concat(this.getTipo().toString());
    }

}
