/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionDB;

import classes.User;
import static connectionDB.ConnectionLoginDB.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jorda
 */
public class ConnectionUserDB {

   
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/"
            + "cafetarypan";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() {
         Connection conn = null;
         try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
           
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de "
                    + "datos: " + e.getMessage());

            System.err.println("Error al conectar a la base de datos: "
                    + e.getMessage());
        }
           return conn;

    }
     public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la "
                        + "conexión: " + e.getMessage());
            }
        }
    }

    public static ObservableList<User> getDataUser() {
        Connection conn = conn();
        ObservableList<User> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("select "
                    + "person.id_person, "
                    + "birth_date, identification, name, lastName, secondName, "
                    + "telephone, email, password, type, user.id_user "
                    + "from person "
                    + "inner join user on person.id_person = user.id_user");
            ResultSet rs = ps.executeQuery();

            addUserToList(rs, list);

        } catch (SQLException | NumberFormatException e) {

            System.out.println(e);

        }

        return list;
    }

    private static void addUserToList(ResultSet rs, ObservableList<User> list) throws SQLException {
        if (rs.next()) {
            list.add(new User(Integer.parseInt(rs.getString("id_person")),
                    rs.getDate("birth_date"),
                    rs.getString("identification"),
                    rs.getString("name"),
                    rs.getString("lastName"),
                    rs.getString("secondName"),
                    Integer.parseInt(rs.getString("telephone")),
                    Integer.parseInt(rs.getString("id_user")),
                    rs.getString("email"), rs.getString("password"),
                    rs.getString("type")));
            addUserToList(rs, list);
        }
    }
}
