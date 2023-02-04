package com.api.cuentas.infrastructure.jpa.helper;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.StreamSupport.stream;

public abstract class AdapterOperations<M, E, I, R extends JpaRepository<E, I>> {
    protected R repository;
    private final Class<E> entity;
    private final Function<E, M> toModel;
    protected ModelMapper mapper;

    protected AdapterOperations(R repository, ModelMapper mapper, Class<E> entity, Function<E, M> toModel) {
        this.repository = repository;
        this.mapper = mapper;
        this.entity = entity;
        this.toModel = toModel;
    }

    protected E toEntity(M model) {
        return mapper.map(model, entity);
    }

    protected M toModel(E entity) {
        return entity != null ? toModel.apply(entity) : null;
    }

    public M save(M model) {
        E entitySave = toEntity(model);
        return toModel(saveEntity(entitySave));
    }

    protected List<M> saveAll(List<M> models) {
        List<E> list = models.stream()
                .map(this::toEntity)
                .toList();
        return toList(saveEntity(list));
    }

    public List<M> toList(Iterable<E> iterable) {
        return stream(iterable.spliterator(), false)
                .map(this::toModel).toList();
    }

    protected E saveEntity(E entity) {
        return repository.save(entity);
    }

    protected Iterable<E> saveEntity(List<E> entities) {
        return repository.saveAll(entities);
    }

    public M findById(I id) {
        return toModel(repository.findById(id).orElse(null));
    }

    public List<M> findAll(){
        return toList(repository.findAll());
    }

}
