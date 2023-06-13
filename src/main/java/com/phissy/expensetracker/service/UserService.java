package com.phissy.expensetracker.service;

import com.phissy.expensetracker.entity.User;
import com.phissy.expensetracker.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User updateUser(UserModel user);

    void deleteUser();

    User readUser();

    User getLoggedInUser();

}
