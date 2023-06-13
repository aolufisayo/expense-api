package com.phissy.expensetracker.service;

import com.phissy.expensetracker.entity.User;
import com.phissy.expensetracker.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    User readUser(Long id);

}
