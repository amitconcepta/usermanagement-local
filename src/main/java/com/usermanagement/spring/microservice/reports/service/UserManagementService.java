package com.usermanagement.spring.microservice.reports.service;

import com.usermanagement.spring.microservice.orm.User;
import com.usermanagement.spring.microservice.orm.repository.UserRepository;
import com.usermanagement.spring.microservice.reports.exception.BadRequestException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class UserManagementService {
    @Resource
    private UserRepository userRepository;

    @SneakyThrows
    public User registerUser(User user) {

        if (user == null) {
            throw new BadRequestException("User data not found");
        }
        if (ObjectUtils.isEmpty(user.getEmail()) || findByEmailId(user.getEmail()) != null) {
            throw new BadRequestException("Email ID: " + user.getEmail() + " is already Exist!, Please try with login with same email id");
        }
        User newUser = new User();
        //    newUser.setCreatedBy("System");
        newUser.mergeMetaData(user);
        return userRepository.save(newUser);
    }

    @SneakyThrows
    public User findByEmailId(String email) {
        return userRepository.findByEmailId(email);
    }

    @SneakyThrows
    public User findByAccessKey(String accessKey) {
        return userRepository.findByAccessKey(accessKey);
    }
}
