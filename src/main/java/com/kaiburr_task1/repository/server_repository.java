package com.kaiburr_task1.repository;


import java.util.List;

import com.kaiburr_task1.model.server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface server_repository extends MongoRepository<server, String> {

	List<server> findByName(String name);
}
