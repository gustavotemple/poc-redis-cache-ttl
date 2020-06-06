package com.poc.redis.cache.ttl.app.repository;

import com.poc.redis.cache.ttl.app.model.AppModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class AppRepositoryImpl implements AppRepository {

    private static Integer i = 0;
    private static final Map<String, AppModel> repo = new HashMap<>();

    @Cacheable(value = "model", key = "#id", cacheManager = "myCacheManager1", unless = "#result == null")
    @Override
    public Optional<AppModel> findById(String id) {
        if (existsById(id))
            return Optional.of(repo.get(id));

        return Optional.empty();
    }

    public void replace(String id, AppModel model) {
        repo.replace(id, model);
    }

    @Override
    public boolean existsById(String key) {
        return repo.containsKey(key);
    }

    @Cacheable(value = "models", cacheManager = "myCacheManager2", unless = "#result == null")
    @Override
    public ArrayList<AppModel> findAll() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public Iterable<AppModel> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return repo.size();
    }

    @Override
    public void deleteById(String id) {
        repo.remove(id);
    }

    @Override
    public void delete(AppModel appModel) {
    }

    @Override
    public void deleteAll(Iterable<? extends AppModel> iterable) {
    }

    @Override
    public void deleteAll() {
        repo.clear();
    }

    @Override
    public AppModel save(AppModel model) {
        i++;
        model.setId(i.toString());
        return repo.put(i.toString(), model);
    }

    @Override
    public <S extends AppModel> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

}
