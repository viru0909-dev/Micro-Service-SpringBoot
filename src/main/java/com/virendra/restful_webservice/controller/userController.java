package com.virendra.restful_webservice.controller;

import com.virendra.restful_webservice.entity.userDaoService;
import com.virendra.restful_webservice.entity.users;
import com.virendra.restful_webservice.exception.UserNotFoundExecption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class userController {
    private userDaoService service;
    public userController(userDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<users> retrieveAllUsers(){
        return  service.findAll();
    }

    @GetMapping("/users/{id}")
    public users retrieveByID(@PathVariable Integer id){
        users user = service.findOne(id);

        // we created class UserNotFoundExecption -> when we try to search for users which does not
        // exist it return back error code of 404 and error message of id : {id}
        if(user == null){
            throw new UserNotFoundExecption("id: "+id);
        }
        return  user;
    }

    @PostMapping("/users")
    public ResponseEntity<users> createUser(@RequestBody users user){
       users savedUser = service.save(user);

       // we add a location -> 	http://localhost:8080/users/4 to response
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        //Give back 201 status code when user is successfully create user
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }

}
