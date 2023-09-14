package com.kaiburr_task1.service;



import java.util.List;
import java.util.Optional;

import com.kaiburr_task1.model.server;
import com.kaiburr_task1.repository.server_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class server_serviceImpl implements server_service {

    @Autowired
    private server_repository serverRepository;

    @Override
    public List<server> findAll() {
        return serverRepository.findAll();
    }

    @Override
    public Optional<server> findById(String Id) {
        return serverRepository.findById(Id);
    }

    @Override
    public void createOrUpdateServer(server server) {
        serverRepository.save(server);
    }

    @Override
    public void deleteServerById(String Id) {
        serverRepository.deleteById(Id);
    }

    @Override
    public List<server> findByName(String name) {
        return serverRepository.findByName(name);
    }

    public boolean existsServerById(String id) {
        return serverRepository.existsById(id);
    }

}