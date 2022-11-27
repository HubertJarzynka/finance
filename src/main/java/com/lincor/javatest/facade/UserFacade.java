package com.lincor.javatest.facade;


import com.lincor.javatest.dto.UserDto;
import com.lincor.javatest.eception.UserNotFoundException;
import com.lincor.javatest.mapper.UserMapper;
import com.lincor.javatest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public UserDto saveUser(final UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userDto));
    }

    public UserDto getUserById(final Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUserByID(id));
    }
}
