package demofacturas.service;

import demofacturas.persistence.entity.Producto;
import demofacturas.persistence.repository.ProductoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp extends GenericServiceCrudImp<Producto, Long> implements  ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    protected JpaRepository<Producto, Long> getRepository() {
        return this.productoRepository;
    }
}
