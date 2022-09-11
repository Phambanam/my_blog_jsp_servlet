package com.phambanam.DAO;

import com.phambanam.model.NewModel;
import com.phambanam.paging.Pageble;

import java.util.List;

public interface INewDAO {
    NewModel findOne(Long id);
    List<NewModel> findByCategoryId(Long categoryId);
    Long save(NewModel newModel);
    void update(NewModel updateNew);
    void delete(long id);
    List<NewModel> findAll(Pageble pageble);
    int getTotalItem();
}
