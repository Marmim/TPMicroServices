package org.example.donationms.services;


import org.example.donationms.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "UserService")
public interface UserRestClient {
    @GetMapping("/users/{id}")
    User getUserByID(@PathVariable("id") int id);

    @GetMapping("/users")
    List<User> getUsers();


}


