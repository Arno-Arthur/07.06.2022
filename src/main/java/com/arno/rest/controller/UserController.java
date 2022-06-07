package com.arno.rest.controller;


import com.arno.domain.User;
import com.arno.rest.dto.UserDto;
import com.arno.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDto getByLoginAndPassword(@RequestParam String login, @RequestParam String password){
        User user = userService.getByLoginAndPassword(login, password);
        return UserDto.toDto(user);
    }
}
