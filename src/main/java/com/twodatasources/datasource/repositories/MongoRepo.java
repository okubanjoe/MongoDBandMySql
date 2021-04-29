package com.twodatasources.datasource.repositories;

import com.twodatasources.datasource.models.MongoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface MongoRepo extends MongoRepository<MongoModel, Integer> {
}
