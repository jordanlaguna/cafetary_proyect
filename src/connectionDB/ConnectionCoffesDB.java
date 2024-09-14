/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionDB;

import classes.Coffe;
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
public class ConnectionCoffesDB {

    private static String JDBC_URL = "jdbc:mysql://localhost:3306/"
            + "cafetarypan";
    private static String user = "root";
    private static String password = "";

    public static Connection conn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, user, password);

        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos " + ex);
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

    public static ObservableList<Coffe> getDataCoffe() {
        Connection conn = null;
        ObservableList<Coffe> list = FXCollections.observableArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = conn();
            ps = conn.prepareStatement("SELECT * FROM coffes");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Coffe(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Float.parseFloat(rs.getString("price")),
                        rs.getString("image")
                ));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
         
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return list;
    }

}
