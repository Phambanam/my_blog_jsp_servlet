package com.phambanam.DAO.impl;


import com.phambanam.DAO.IUserDAO;
import com.phambanam.mapper.impl.UserMapper;
import com.phambanam.model.UserModel;

import java.sql.Timestamp;
import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long insert(UserModel userModel) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO user" +
						"(username, password, fullname,status,roleid,createddate)")
				.append("VALUES (?,?,?,?,?,?)");
		Timestamp createddate = new Timestamp(System.currentTimeMillis());
		return insert(stringBuilder.toString(), userModel.getUserName(),userModel.getPassword(),userModel.getFullName()
		,userModel.getStatus(),userModel.getRoleId(),createddate);
	}

}
