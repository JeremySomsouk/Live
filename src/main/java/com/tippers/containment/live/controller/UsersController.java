package com.tippers.containment.live.controller;

import com.tippers.containment.live.controller.dto.UserDto;
import com.tippers.containment.live.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    UserDto saveUser(@RequestBody UserDto newUser) {
        return usersService.saveUser(newUser);
    }

    @GetMapping("/{userId}")
    UserDto getUserById(@PathVariable(value = "userId") Long userId) {

        return usersService.findUserById(userId);
    }

    @GetMapping("/all")
    List<UserDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PutMapping("/{userId}")
    UserDto replaceEmployee(@RequestBody UserDto newUser, @PathVariable(value = "userId") Long userId) {
        return usersService.replaceUserById(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    void deleteEmployee(@PathVariable(value = "userId") Long userId) {
        usersService.deleteUserById(userId);
    }
}