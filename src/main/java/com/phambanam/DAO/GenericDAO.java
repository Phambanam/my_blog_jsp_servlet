package com.phambanam.DAO;

import com.phambanam.mapper.IMapper;

import java.util.List;

public interface GenericDAO {
    <T> List<T> query(String sql, IMapper<T> rowMapper, Object... parameters);
    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
