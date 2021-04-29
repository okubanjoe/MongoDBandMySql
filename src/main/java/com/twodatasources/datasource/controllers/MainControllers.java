package com.twodatasources.datasource.controllers;


import com.twodatasources.datasource.models.MongoModel;
import com.twodatasources.datasource.models.SqlModel;
import com.twodatasources.datasource.repositories.MongoRepo;
import com.twodatasources.datasource.repositories.SqlRepo;
import com.twodatasources.datasource.services.MainServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class MainControllers {

    @Autowired
    MongoRepo mongoRepo;

    @Autowired
    SqlRepo sqlRepo;


    @Autowired
    MainServiceClass mainServiceClass;



    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<Void> createMongo(@RequestBody MongoModel mongoModel, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Member " + mongoModel.getName());
        mainServiceClass.createmongo(mongoModel);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/course/{id}").buildAndExpand(mongoModel.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @PostMapping(value = "/createsql", headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody SqlModel sqlModel, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Sql User " + sqlModel.getName());
        mainServiceClass.createsql(sqlModel);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(sqlModel.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getsql", headers = "Accept=application/json")
    public List<SqlModel> getAllUser() {
        List<SqlModel> tasks = mainServiceClass.listsql();
        return tasks;
    }
}
