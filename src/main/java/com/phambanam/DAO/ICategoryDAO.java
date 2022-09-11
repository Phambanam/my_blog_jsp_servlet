package com.phambanam.DAO;

import com.phambanam.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
    CategoryModel findOne(long id);
    CategoryModel findOneByCode(String code);
}
