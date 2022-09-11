package com.phambanam.mapper;

import java.sql.ResultSet;

public interface IMapper<T> {
     T mapper(ResultSet resultSet);

}
