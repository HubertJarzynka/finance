package com.lincor.javatest.service;

import com.lincor.javatest.domain.User;
import com.lincor.javatest.dto.UserDto;
import com.lincor.javatest.eception.UserNotFoundException;
import com.lincor.javatest.mapper.UserMapper;
import com.lincor.javatest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(final UserDto userDto) {
        return userRepository.save(userMapper.mapToUser(userDto));

    }
    public User getUserByID(final Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


}
