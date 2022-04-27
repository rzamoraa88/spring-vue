package demofacturas.persistence.entity;

import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
@ConstructorBinding
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTO_ID")
    private Long id;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "IMPORTE", nullable = false)
    private Double importe;
    @ManyToOne
    @JoinColumn(name = "FACTURA_ID")
    private Factura factura;

    public Producto() {

    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getImporte() {
        return importe;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
