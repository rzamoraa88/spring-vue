package demofacturas.service;

import demofacturas.mapper.FacturaInDTOToFactura;
import demofacturas.persistence.entity.Factura;
import demofacturas.persistence.repository.FacturaRepository;
import demofacturas.service.dto.FacturaInDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturaServiceImp extends GenericServiceCrudImp<Factura, Long> implements  FacturaService{
    private final FacturaRepository facturaRepository;
    private final FacturaInDTOToFactura mapper;

    public FacturaServiceImp(FacturaRepository facturaRepository, FacturaInDTOToFactura mapper) {
        this.facturaRepository = facturaRepository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Factura, Long> getRepository() {
        return facturaRepository;
    }

    @Override
    public Factura saveChanges(FacturaInDTO in) {
        Factura f = null;
        Optional<Factura> opt = this.getRepository().findById(in.getId());
        if (opt.isPresent()){
            f = mapper.hidrate(in,opt.get());
            return this.getRepository().save(f);
        }
        else{
            f = mapper.map(in);
            return this.getRepository().save(f);
        }
    }
}
