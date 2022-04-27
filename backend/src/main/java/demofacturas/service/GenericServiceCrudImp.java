package demofacturas.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceCrudImp<TEntity, ID extends Serializable> implements  GenericServiceCrud<TEntity, ID> {

    @Override
    public TEntity save(TEntity tEntity) {
        return getRepository().save(tEntity);
    }

    @Override
    public CrudStatus delete(ID id) {
        Optional<TEntity> opt = getRepository().findById(id);
        if (opt.isPresent()){
            getRepository().deleteById(id);
            return CrudStatus.Ok;
        }
        return CrudStatus.Error;
    }

    @Override
    public TEntity get(ID id) {
        Optional<TEntity> opt = getRepository().findById(id);
        if (opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @Override
    public List<TEntity> getAll() {
        return getRepository().findAll();
    }

    protected abstract JpaRepository<TEntity, ID> getRepository();
}
