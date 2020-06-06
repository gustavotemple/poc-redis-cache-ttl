package com.poc.redis.cache.ttl.app.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

//@RedisHash(value = "models", timeToLive = 1)
public class AppModel {

    @Id
    private String id;

    private String name;

    //    @TimeToLive(unit = TimeUnit.MINUTES)
    private Long expiration;

    public AppModel() {
    }

    public AppModel(String name) {
        this.name = name;
    }

    public AppModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppModel)) return false;
        AppModel appModel = (AppModel) o;
        return id.equals(appModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
