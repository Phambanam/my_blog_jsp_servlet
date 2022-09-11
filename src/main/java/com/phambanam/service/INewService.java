package com.phambanam.service;

import com.phambanam.model.NewModel;
import com.phambanam.paging.Pageble;

import java.util.List;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long[] ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	NewModel findOne(long id);
}
