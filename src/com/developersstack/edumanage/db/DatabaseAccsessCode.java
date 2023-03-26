package com.developersstack.edumanage.db;

import com.developersstack.edumanage.model.User;
import com.developersstack.edumanage.util.security.PasswordManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAccsessCode {
    public boolean saveUSer(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
        pstm.setString(1, user.getEmail());
        pstm.setString(2, user.getFirstName());
        pstm.setString(3, user.getLastName());
        pstm.setString(4,new PasswordManager().encrypt(user.getPassword()));
        return pstm.executeUpdate()>0;
    }
}
