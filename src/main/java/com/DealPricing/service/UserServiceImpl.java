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
public class UserServiceImpl
{

@Autowired
UserRepository userRepository;

        public List<User> findAllUsers() {
            return userRepository.findAll();
        }
        public User findById (int id){
            return userRepository.findById(id).orElse(null);
        }
        public User saveUser (User user){
            return userRepository.save(user);
        }
        public User updateUser (int id, User user){
            if(userRepository.findById(id).isPresent()) {
                user.setEmployeeCode(id);
                return userRepository.save(user);
            }
            return null;
        }
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
    public String deleteUser (int id){
            Optional<User> toDelete= userRepository.findById(id);
            if(toDelete.isPresent()) {
                userRepository.deleteById(id);
                return "Deleted record:- "+ toDelete.toString();
            }
            return "Record Not Found";
        }
}
