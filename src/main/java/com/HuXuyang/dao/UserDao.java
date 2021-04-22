package com.HuXuyang.dao;

import com.HuXuyang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements  IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ..into usertable --- write code yourself
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ....where id=?
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update ... where id=?

        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ... where id=?----weite jdbc code yourself

        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        //select --- where username=? and password=?--- i will show y hou now
        String sql="SELECT id,usename,password,email,gender,birthdate,from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model;
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));

        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //insert ..into username --- write code yourself
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //insert ..into password --- write code yourself
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //insert ..into email --- write code yourself
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //insert ..into gender --- write code yourself
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //insert ..into birthdate --- write code yourself
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //insert ..into usertable --- write code yourself
        return null;
    }
}
