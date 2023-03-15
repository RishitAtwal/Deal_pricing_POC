package com.DealPricing.service;

import com.DealPricing.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();
    Optional<User> findById(int id);
    User saveUser(User user);
    User updateUser(User user);
    User updateUserByFields(int id, Map<String, Object> fields);
    void deleteUser(int id);

}
