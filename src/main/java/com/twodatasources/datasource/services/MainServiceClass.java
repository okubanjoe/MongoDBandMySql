package com.twodatasources.datasource.services;


import com.twodatasources.datasource.models.MongoModel;
import com.twodatasources.datasource.models.SqlModel;
import com.twodatasources.datasource.repositories.MongoRepo;
import com.twodatasources.datasource.repositories.SqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MainServiceClass {
    @Autowired
    MongoRepo mongoRepo;

    @Autowired
    SqlRepo sqlRepo;

    public MongoModel createmongo(MongoModel mongoModel){
        return mongoRepo.save(mongoModel);
    }
    public List<MongoModel> listmongo(){
        List<MongoModel> all = mongoRepo.findAll();

        return all;
    }




    public SqlModel createsql(SqlModel sqlModel){
        return sqlRepo.save(sqlModel);

    }


    public List<SqlModel> listsql(){
        List<SqlModel> all = sqlRepo.findAll();
        for (SqlModel ss : all){
            System.out.println(ss);

        }
        return all;
    }
}
