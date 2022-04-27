package demofacturas.service.dto;

import demofacturas.persistence.entity.Producto;

public class FacturaInDTO {
    private Long id;
    private String codigo;
    private String nif;
    private Producto[] productos;

    public FacturaInDTO(String codigo, String nif, Producto[] productos) {
        this.codigo = codigo;
        this.nif = nif;
        this.productos = productos;
    }

    public FacturaInDTO() {}

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
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
}
