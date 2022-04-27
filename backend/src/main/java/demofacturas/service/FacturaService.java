package demofacturas.service;

import demofacturas.persistence.entity.Factura;
import demofacturas.service.dto.FacturaInDTO;


public interface FacturaService extends GenericServiceCrud<Factura, Long>{
    Factura saveChanges(FacturaInDTO in);
}
