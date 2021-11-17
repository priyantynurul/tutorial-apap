package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    void deleteUser(UserModel user);
    List<UserModel> getUserList();
    UserModel getUserByNoUser(Long noUser);
}