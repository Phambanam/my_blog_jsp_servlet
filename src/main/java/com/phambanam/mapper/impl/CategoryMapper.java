package com.phambanam.mapper.impl;

import com.phambanam.mapper.IMapper;
import com.phambanam.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements IMapper<CategoryModel> {
    @Override
    public CategoryModel mapper(ResultSet resultSet) {
        try {
            CategoryModel category = new CategoryModel();
            category.setId(resultSet.getLong("id"));
            category.setCode(resultSet.getString("code"));
            category.setName(resultSet.getString("name"));
            return category;
        } catch (SQLException e) {
            return null;
        }
    }
}
