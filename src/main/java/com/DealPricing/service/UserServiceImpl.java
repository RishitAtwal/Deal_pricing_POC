package com.DealPricing.service;

import com.DealPricing.entities.User;
import com.DealPricing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{

@Autowired
UserRepository userRepository;
        @Override
        public List<User> findAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public Optional<User> findById (int id){
            return userRepository.findById(id);
        }

        @Override
        public User saveUser (User user){
            return userRepository.save(user);
        }

        @Override
        public User updateUser (User user){
            return userRepository.save(user);
        }

    @Override
    public User updateUserByFields(int id, Map<String, Object> fields) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return userRepository.save(existingUser.get());
        }
        return null;
    }


    @Override
        public void deleteUser (int id){
            userRepository.deleteById(id);
        }
    }