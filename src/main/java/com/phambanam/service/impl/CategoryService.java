package com.phambanam.service.impl;


import com.phambanam.DAO.ICategoryDAO;
import com.phambanam.model.CategoryModel;
import com.phambanam.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
