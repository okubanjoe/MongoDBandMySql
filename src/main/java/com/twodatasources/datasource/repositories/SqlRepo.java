package com.twodatasources.datasource.repositories;


import com.twodatasources.datasource.models.SqlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SqlRepo extends JpaRepository<SqlModel, Integer> {
}
