package com.project.usermodule.controller;


import com.project.usermodule.dto.request.ApiResponse;
import com.project.usermodule.dto.request.UserCreationRequest;
import com.project.usermodule.dto.request.UserUpdateRequest;
import com.project.usermodule.entity.User;
import com.project.usermodule.service.UserService;
import jakarta.validation.Valid;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse <User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")
    User getUser(@PathVariable("userid") String userid) {
        return userService.getUser(userid);
    }

    @PutMapping("/{userid}")
    User updateUser(@PathVariable String userid, @RequestBody UserUpdateRequest user) {
        return userService.updateUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    String deleteUser(@PathVariable("userid") String userid) {
        userService.deleteUser(userid);
        return "User has been deleted";
    }
}
