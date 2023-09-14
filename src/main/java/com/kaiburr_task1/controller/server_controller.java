package com.kaiburr_task1.controller;



import java.util.List;
import java.util.Optional;

import com.kaiburr_task1.model.server;
import com.kaiburr_task1.service.server_serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/servers")
public class server_controller {

    @Autowired
    private server_serviceImpl server_serviceImpl;

    @GetMapping(value = "/getServer")
    public List<server> getAllServers() {
        return server_serviceImpl.findAll();
    }

    @GetMapping(value = "/getServer", params = "id")
    public ResponseEntity<?> getServerById(@RequestParam String id) {
        Optional<server> server = server_serviceImpl.findById(id);
        if (server.isPresent()) {
            return new ResponseEntity<server>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getServer", params = "name")
    public ResponseEntity<?> getServerByName(@RequestParam String name) {
        List<server> servers = server_serviceImpl.findByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<server>>(servers, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/createServer")
    public ResponseEntity<?> createOrUpdateServer(@RequestBody server server) {
        server_serviceImpl.createOrUpdateServer(server);
        return new ResponseEntity<String>("Server added successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteServer")
    public ResponseEntity<?> deleteServer(@RequestParam String id) {
        if (server_serviceImpl.existsServerById(id)) {
            server_serviceImpl.deleteServerById(id);
            return new ResponseEntity<String>("Server deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Server not exists!", HttpStatus.OK);
    }

}