package demofacturas.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "FACTURA_ID")
    private Long id;
    @Column(name = "CODIGO", nullable = false)
    private String codigo;
    @Column(name = "NIF", nullable = false)
    private String nif;
    @Column(name = "NUMERO_PRODUCTOS")
    private int numeroProductos;
    @Column(name = "IMPORTE")
    private Double importe;
    @Column(name = "IMPORTE_IVA")
    private Double importeConIva;
    @OneToMany(mappedBy = "factura")
    private Set<Producto> productos;
    public Factura() {

    }

    public Factura(String codigo, String nif) {
        this.codigo = codigo;
        this.nif = nif;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getNumeroProductos() {
        return numeroProductos;
    }

    public Double getImporte() {
        return importe;
    }

    public Double getImporteConIva() {
        return importeConIva;
    }

    public void setNumeroProductos(int numeroProductos) {
        this.numeroProductos = numeroProductos;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public void setImporteConIva(Double importeConIva) {
        this.importeConIva = importeConIva;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

}
