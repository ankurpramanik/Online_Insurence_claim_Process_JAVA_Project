/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pailan.dao;

import com.pailan.dto.Menu;
import com.pailan.dto.UserDto;
import com.pailan.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ankur
 */
public class UserDao {

    public static boolean validateUser(String username, String password) {
        boolean result = false;

        DbUtil myDbUtil = DbUtil.getInstance();
        try {
            Connection conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  username,\n"
                    + "  PASSWORD\n"
                    + " FROM\n"
                    + " user"
                    + " where username=? and password=?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            System.out.println("SQL ==>" + stmt);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static ArrayList getMenues(String userName) {
        ArrayList menuList = new ArrayList();
        DbUtil myDbUtil = DbUtil.getInstance();
        try {
            Connection conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT menuName,menuUrl FROM menu \n";
            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Menu menu = new Menu();
                menu.setMenuName(rs.getString("menuName"));
                menu.setMenuUrl(rs.getString("menuUrl"));

                menuList.add(menu);
            }

        } catch (Exception ex) {

            ex.printStackTrace();;
        }

        return menuList;

    }

    public static boolean addUser(UserDto userDto) {
        boolean result = false;
        DbUtil myDbUtil = DbUtil.getInstance();
        try {
            Connection conn = (Connection) myDbUtil.getDbConnection();
            String sql = "INSERT INTO user (username, password)\n"
                    + " VALUES\n"
                    + "  (?,?);\n";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, userDto.getUserName());
            stmt.setString(2, userDto.getPassword());
            
            System.out.println("Sql statement= "+stmt);

            int row = stmt.executeUpdate();

            if (row > 0) {
                result = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
