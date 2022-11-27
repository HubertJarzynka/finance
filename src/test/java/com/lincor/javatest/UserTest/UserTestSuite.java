package com.lincor.javatest.UserTest;

import com.lincor.javatest.domain.User;
import com.lincor.javatest.dto.UserDto;
import com.lincor.javatest.eception.UserNotFoundException;
import com.lincor.javatest.facade.UserFacade;
import com.lincor.javatest.mapper.UserMapper;
import com.lincor.javatest.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class UserTestSuite {

    @InjectMocks
    private UserFacade userFacade;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserService userService;

    @Test
    void shouldSaveUser() {
        //Given
        User user = initUser();
        UserDto userDto = initUserDto();

        when(userMapper.mapToUser(userDto)).thenReturn(user);
        when(userService.saveUser(userDto)).thenReturn(user);
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);


        //When
        UserDto savedUser = userFacade.saveUser(userDto);

        //Then
        assertEquals(userDto.getId(), savedUser.getId());
        assertEquals(userDto.getName(), savedUser.getName());
    }

    @Test
    void shouldDeleteUser() throws UserNotFoundException {
        //Given
        User user = initUser();

        when(userService.getUserByID(anyLong())).thenReturn(user);
        doNothing().when(userService).deleteUser(any());

        //When
        userFacade.deleteUser(2L);

        //Then
        verify(userService, times(1)).deleteUser(2L);
    }


    private User initUser() {
        return User.builder()
                .id(1L)
                .name("Jan")
                .password("1234")
                .build();
    }

    private UserDto initUserDto() {
        return UserDto.builder()
                .id(1L)
                .name("Jan")
                .password("1234")
                .build();
    }

}
