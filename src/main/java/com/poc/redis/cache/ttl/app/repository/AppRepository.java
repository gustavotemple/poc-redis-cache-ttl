package com.poc.redis.cache.ttl.app.repository;

import com.poc.redis.cache.ttl.app.model.AppModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface AppRepository extends CrudRepository<AppModel, String> {

    @Override
    public Optional<AppModel> findById(String id);

    public void replace(String id, AppModel model);

    @Override
    public boolean existsById(String key);

    @Override
    public ArrayList<AppModel> findAll();

    @Override
    public Iterable<AppModel> findAllById(Iterable<String> iterable);

    @Override
    public void deleteById(String id);

    @Override
    public void delete(AppModel appModel);

    @Override
    public void deleteAll(Iterable<? extends AppModel> iterable);

    @SuppressWarnings("unchecked")
    @Override
    public AppModel save(AppModel model);

    @Override
    public <S extends AppModel> Iterable<S> saveAll(Iterable<S> iterable);

}
