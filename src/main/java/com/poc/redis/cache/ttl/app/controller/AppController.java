package com.poc.redis.cache.ttl.app.controller;

import com.poc.redis.cache.ttl.app.model.AppModel;
import com.poc.redis.cache.ttl.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/v1")
public class AppController {

    private AppRepository repo;

    @Autowired
    public AppController(AppRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/models")
    public ArrayList<AppModel> getAppModels() {
        return repo.findAll();
    }

    @GetMapping("/models/{id}")
    public AppModel getAppModel(@PathVariable("id") String id) {
        return repo.findById(id).orElse(new AppModel("0", ""));
    }

    @GetMapping("/models/add")
    public AppModel add() {
        return repo.save(new AppModel("added"));
    }

    @GetMapping("/models/replace/{id}")
    public ResponseEntity replace(@PathVariable("id") String id) {
        repo.replace(id, new AppModel(id, "replaced"));
        return ResponseEntity.ok().build();
    }

}
