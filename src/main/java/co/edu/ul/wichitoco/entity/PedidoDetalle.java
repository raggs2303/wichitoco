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
@Table(name = "pedido_detalle", catalog = "wichitocodb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoDetalle.findAll", query = "SELECT p FROM PedidoDetalle p"),
    @NamedQuery(name = "PedidoDetalle.findByConsecutivo", query = "SELECT p FROM PedidoDetalle p WHERE p.consecutivo = :consecutivo"),
    @NamedQuery(name = "PedidoDetalle.findByCantidad", query = "SELECT p FROM PedidoDetalle p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PedidoDetalle.findByValor", query = "SELECT p FROM PedidoDetalle p WHERE p.valor = :valor"),
    @NamedQuery(name = "PedidoDetalle.findByEstado", query = "SELECT p FROM PedidoDetalle p WHERE p.estado = :estado")})
public class PedidoDetalle implements Serializable {

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
    @JoinColumn(name = "pedido", referencedColumnName = "consecutivo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedido;
    @JoinColumn(name = "producto", referencedColumnName = "consecutivo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public PedidoDetalle(Integer consecutivo, int cantidad, long valor, String estado) {
        this.consecutivo = consecutivo;
        this.cantidad = cantidad;
        this.valor = valor;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        return object instanceof PedidoDetalle && ((PedidoDetalle) object).consecutivo != null && this.consecutivo.equals(((PedidoDetalle) object).consecutivo);
    }

    @Override
    public String toString() {
        return "co.edu.ul.wichitoco.entity.PedidoDetalle[ consecutivo=" + consecutivo + " ]";
    }

}
