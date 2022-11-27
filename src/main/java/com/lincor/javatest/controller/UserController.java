package com.lincor.javatest.controller;


import com.lincor.javatest.dto.UserDto;
import com.lincor.javatest.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userFacade.saveUser(userDto);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userFacade.saveUser(userDto);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userFacade.deleteUser(id);
    }
    
}
