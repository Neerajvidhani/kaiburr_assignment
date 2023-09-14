package com.kaiburr_task1.service;



import java.util.List;
import java.util.Optional;

import com.kaiburr_task1.model.server;

public interface server_service {

    List<server> findAll();

    Optional<server> findById(String Id);

    void createOrUpdateServer(server server);

    void deleteServerById(String Id);

    List<server> findByName(String name);
}
