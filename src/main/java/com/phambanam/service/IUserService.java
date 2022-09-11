package com.phambanam.service;

import com.phambanam.model.UserModel;


public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

	Long insert(UserModel userModel);
}
