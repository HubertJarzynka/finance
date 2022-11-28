package com.lincor.javatest.service;

import com.lincor.excercise.DbManager;
import com.lincor.javatest.domain.User;
import com.lincor.javatest.dto.UserDto;
import com.lincor.javatest.eception.UserNotFoundException;
import com.lincor.javatest.mapper.UserMapper;
import com.lincor.javatest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

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


    public void getUserid() throws SQLException {

        List ll = new LinkedList();

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT ID, name, password FROM users";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        while (rs.next()) {
            Long i = rs.getLong("ID");
            String str = rs.getString("name");
            String str2 = rs.getString("password");

            //Assuming you have a user object
            User user = new User(i,str,str2);

            ll.add(user);
        }


    }
}
