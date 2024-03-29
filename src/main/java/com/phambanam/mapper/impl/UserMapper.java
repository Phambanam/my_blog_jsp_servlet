package com.phambanam.mapper.impl;

import com.phambanam.mapper.IMapper;
import com.phambanam.model.RoleModel;
import com.phambanam.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IMapper<UserModel> {
    @Override
    public UserModel mapper(ResultSet resultSet) {
        try {
            UserModel user = new UserModel();
            user.setId(resultSet.getLong("id"));
            user.setUserName(resultSet.getString("username"));
            user.setFullName(resultSet.getString("fullname"));
            user.setPassword(resultSet.getString("password"));
            user.setStatus(resultSet.getInt("status"));
            try {
                RoleModel role = new RoleModel();
                role.setCode(resultSet.getString("code"));
                role.setName(resultSet.getString("name"));
                user.setRole(role);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
