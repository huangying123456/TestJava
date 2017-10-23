package com.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ListenYoung on 2017/5/13.
 */
public class SimpleJDBCDemo {

    //获取MySQL数据库连接
    public Connection getConnection(String url, String userName, String password){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 将你自己构建的对象转化成JSON串，方便前端去展示数据
     * @param object 这个Object应该是你自己定义的描述当前服务器状态的一个对象，其属性和值是你来决定的
     * @return
     */
    public String transObjToJSON(Object object){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        //用这样的形式来把你定义的类的所有属性都添加成JSON
        //stringBuilder.append("\"serverName\":\"")
                //.append(object.getServerName)
               // .append("\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /**
     * 将从数据库遍历出来list转化成JSON
     * @param list
     * @return
     */
    public String transListToJSON(List<Object> list){
        if(list == null || list.size() < 1){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Object o : list){
            stringBuilder.append(transObjToJSON(o)).append(",");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * 通过JDBC从数据库获取数据 sql为预先写好的sql语句
     * @param url
     * @param userName
     * @param password
     * @param sql
     * @return
     */
    public String getDataFromDB(String url, String userName, String password, String sql){
        Connection connection = getConnection(url, userName, password);
        if(connection != null){
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                List<Object> list = new ArrayList<>();
                while (resultSet.next()){
                    //创建你自己定义的对象
                    Object object = new Object();
                    //像这样从结果集中拿数据库中的记录字段
                    //object.setServerName(resultSet.getString("server_name"));
                    list.add(object);
                }

                return transListToJSON(list);

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(resultSet != null){
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        resultSet = null;
                    }
                }

                if(statement != null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        statement = null;
                    }
                }

                if(connection != null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        connection = null;
                    }
                }
            }
        }
        return "[]";
    }

    public static void main(String[] args){
        String url = "数据库连接url";
        String userName = "数据库用户名";
        String password = "数据库密码";
        String sql = "select * from 表名";
        //这个JSON就是前端想要的json串，用来展示数据
        String json = new SimpleJDBCDemo().getDataFromDB(url, userName, password, sql);
    }
}
