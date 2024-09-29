/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionDB;

import classes.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author jorda
 */
public class ConnectionLoginDB {

    Connection conn;

    public static Connection conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//localhost:3306/cafetarypan", "root", "");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se pudo conectar a la base de datos" + e);
            alert.showAndWait();
            return null;
        }
    }

    public static ObservableList<User> getDataUsuario() {

        Connection conn = conn();
        ObservableList<User> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from user");
            ResultSet rs = ps.executeQuery();

            addLoginToList(rs, list);

        } catch (SQLException | NumberFormatException e) {

            System.out.println(e);

        }
        return list;
    }

    private static void addLoginToList(ResultSet rs,
            ObservableList<User> list) throws SQLException {
        if (rs.next()) {
            list.add(new User(Integer.parseInt(rs.getString("id_person")),
                    rs.getDate("birth_date"),
                    rs.getString("identification"),
                    rs.getString("name"),
                    rs.getString("lastName"),
                    rs.getString("secondName"),
                    Integer.parseInt(rs.getString("telephone")),
                    Integer.parseInt(rs.getString("id_user")),
                    rs.getString("correo"), rs.getString("password")));
            addLoginToList(rs, list);
        }
    }
}
