package com.phambanam.DAO.impl;

import com.phambanam.DAO.GenericDAO;
import com.phambanam.mapper.IMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AbstractDAO<T> implements GenericDAO {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    public Connection  getConnection()  {
        String driverName = resourceBundle.getString("driverName");
        try {
            Class.forName(driverName);
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException |  SQLException e) {
            return null;
        }

    }
    @Override
    public <T> List<T> query(String sql, IMapper<T> rowMapper, Object... parameters) {
        List<T> result = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) result.add(rowMapper.mapper(resultSet));
            return result;
        } catch (SQLException e) {
            return null;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Long result = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            setParameters(preparedStatement, parameters);
             preparedStatement.executeUpdate();
             resultSet = preparedStatement.getGeneratedKeys();
           while (resultSet.next())
               result = resultSet.getLong(1);
           connection.commit();
            return result;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public int count(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int count = 0;
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameters(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }
    public void setParameters(PreparedStatement prstm, Object... parameters){
        for (int i = 1; i <= parameters.length;i++){
            Object parameter = parameters[i-1];
            try {
                prstm.setObject(i,parameter);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
