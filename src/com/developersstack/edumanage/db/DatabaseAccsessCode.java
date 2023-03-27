package com.developersstack.edumanage.db;

import com.developersstack.edumanage.model.Student;
import com.developersstack.edumanage.model.User;
import com.developersstack.edumanage.util.security.PasswordManager;

import java.sql.*;

public class DatabaseAccsessCode {
    public boolean saveUSer(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
        pstm.setString(1, user.getEmail());
        pstm.setString(2, user.getFirstName());
        pstm.setString(3, user.getLastName());
        pstm.setString(4,user.getPassword());
        return pstm.executeUpdate()>0;
    }

    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");
        pstm.setString(1,student.getStudentId());
        pstm.setString(2,student.getFullName());
        pstm.setDate(3, (Date) student.getDateOfBirth());
        pstm.setString(4,student.getAddress());
        return pstm.executeUpdate()>0;
    }

    public User loginUser(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM user WHERE email=?");
        pstm.setString(1,email);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new User(rst.getString(2),
                    rst.getString(3),
                    rst.getString(1),
                    rst.getString(4));
        }else {
            return null;
        }
    }
}
