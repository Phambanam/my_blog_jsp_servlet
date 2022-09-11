package com.phambanam.service.impl;

import com.phambanam.DAO.IUserDAO;
import com.phambanam.model.UserModel;
import com.phambanam.service.IUserService;


import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

	@Override
	public Long insert(UserModel userModel) {
 	return userDAO.insert(userModel);
	}

}
