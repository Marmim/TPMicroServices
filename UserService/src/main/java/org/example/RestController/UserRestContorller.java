package org.example.RestController;

import org.example.dto.UserDtoResponse;
import org.example.Repositories.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestContorller {
    private UserRepo userRepo;

    public UserRestContorller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<UserDtoResponse> UsersList() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDtoResponse User(@PathVariable Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("le user n´existe pas", id)));
    }

    @PostMapping("/users/save")
    public UserDtoResponse saveUsers(@RequestBody UserDtoResponse user) {
        return userRepo.save(user);
    }

    @PutMapping("/users/updateUsers/{id}")
    public UserDtoResponse updateUser(@PathVariable Long id, @RequestBody UserDtoResponse user) {
        UserDtoResponse userById = userRepo.findById(id).get();
        if (user.getName() != null) userById.setName(user.getName());
        if (user.getPassword() != null) userById.setPassword(user.getPassword());
        if (user.getEmail() != null) userById.setEmail(user.getEmail());
        return userRepo.save(userById);

    }

    @DeleteMapping("deleteUsers/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
