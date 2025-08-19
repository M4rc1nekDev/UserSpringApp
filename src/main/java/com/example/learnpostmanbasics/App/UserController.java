package com.example.learnpostmanbasics.App;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getUser")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public Optional<User> updateUser(@PathVariable Long id, int age, String name,  String email){
        return userService.updateUser(id,age,name, email);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
