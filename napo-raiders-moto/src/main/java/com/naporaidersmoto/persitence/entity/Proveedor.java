package com.naporaidersmoto.persitence.entity;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "proveedores")
public class Proveedor{

    @Id
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "informacion_proveedor")
    private String informacionProveedor;

    @Column(name = "telefono_proveedor")
    private String telefonoProveedor;

    @Column(name = "correo_proveedor")
    private String correoProveedor;

    @OneToMany(mappedBy = "proveedor")
    private List<Compra> compras;

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getInformacionProveedor() {
        return informacionProveedor;
    }

    public void setInformacionProveedor(String informacionProveedor) {
        this.informacionProveedor = informacionProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
}
