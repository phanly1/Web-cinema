package com.team12.fantafilm.service.impl;

import com.team12.fantafilm.model.User;
import com.team12.fantafilm.repository.UserRepository;
import com.team12.fantafilm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

    public Optional<User> findUserByUserName(String userName){
        return userRepository.findUserEntityByUserName(userName);
    }
}
