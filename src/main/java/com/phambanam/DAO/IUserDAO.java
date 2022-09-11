package com.phambanam.DAO;

import com.phambanam.model.UserModel;

public interface IUserDAO {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    Long insert(UserModel userModel);
}
