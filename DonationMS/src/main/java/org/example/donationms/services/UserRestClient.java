package org.example.donationms.services;


import org.example.donationms.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "UserService")
public interface UserRestClient {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);

    @GetMapping("/users")
    List<User> getUsers();


    @PutMapping("/updateusers/{id}")
    User updateUser(@PathVariable("id") int id, @RequestBody User user);

}


