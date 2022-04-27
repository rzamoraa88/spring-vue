package demofacturas.mapper;

import demofacturas.persistence.entity.Factura;
import demofacturas.persistence.entity.Producto;
import demofacturas.service.dto.FacturaInDTO;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class FacturaInDTOToFactura implements IMapper<FacturaInDTO, Factura> {
    @Override
    public Factura map(FacturaInDTO in) {
        Factura f = new Factura();
        f.setCodigo(in.getCodigo());
        f.setNif(in.getNif());
        Producto[] arProductos = in.getProductos();
        if (arProductos.length == 0){
            f.setProductos(null);

            f.setNumeroProductos(0);
            f.setImporte(0d);
            f.setImporteConIva(0d);
        }
        else{
            f.setProductos(new HashSet<Producto>(Arrays.asList(arProductos)));
            double imp = Arrays.stream(arProductos).mapToDouble(Producto::getImporte).sum();
            f.setImporte(DoubleRounder.round(imp, 3));
            f.setImporteConIva(DoubleRounder.round((imp * 1.21), 3));
            f.setNumeroProductos(arProductos.length);
        }

        return f;
    }
    @Override
    public Factura hidrate(FacturaInDTO in, Factura f) {
        f.setCodigo(in.getCodigo());
        f.setNif(in.getNif());
        Producto[] arProductos = in.getProductos();
        if (arProductos.length == 0){
            f.setProductos(null);

            f.setNumeroProductos(0);
            f.setImporte(0d);
            f.setImporteConIva(0d);
        }
        else{
            f.setProductos(new HashSet<Producto>(Arrays.asList(arProductos)));
            double imp = Arrays.stream(arProductos).mapToDouble(Producto::getImporte).sum();
            f.setImporte(DoubleRounder.round(imp, 3));
            f.setImporteConIva(DoubleRounder.round((imp * 1.21), 3));
            f.setNumeroProductos(arProductos.length);
        }

        return f;
    }
}
