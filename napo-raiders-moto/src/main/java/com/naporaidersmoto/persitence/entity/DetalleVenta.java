package com.naporaidersmoto.persitence.entity;


import javax.persistence.*;


@Entity
@Table(name = "detalles_venta")
public class DetalleVenta {
    @EmbeddedId
    private DetalleVentaPk id;

    @ManyToOne
    @MapsId("idVenta")
    @JoinColumn(name = "id_venta", insertable = false, updatable = false)
    private Venta venta;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    @Column(name = "cantidad_vendida")
    private Integer cantidadVendida;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "total_venta")
    private Double totalVenta;

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public DetalleVentaPk getId() {
        return id;
    }

    public void setId(DetalleVentaPk id) {
        this.id = id;
    }
}
