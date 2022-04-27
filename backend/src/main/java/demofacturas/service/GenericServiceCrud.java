package demofacturas.service;

import java.io.Serializable;
import java.util.List;


public interface GenericServiceCrud<TEntity, ID extends Serializable> {
    TEntity save(TEntity entity);
    CrudStatus delete(ID id);
    TEntity get(ID id);
    List<TEntity> getAll();
}
