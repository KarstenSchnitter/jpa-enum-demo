package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MyEntity;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, String> {

}
