/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionDB;

import controller.FXMLCoffesController.OrderItem;
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
public class OrdersDB {

    Connection conn;

    public static Connection OrdersConn() {
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

    public static ObservableList<OrderItem> getDataOrder() {
        Connection conn = null;
        ObservableList<OrderItem> list = FXCollections.observableArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = OrdersConn();
            ps = conn.prepareStatement("select * from orders");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new OrderItem(Integer.parseInt(rs.getString(
                        "id_order")), Integer.parseInt(rs.getString(
                        "code_product")),rs.getString("product_name"), 
                        Integer.parseInt(rs.getString("quantity")), 
                        rs.getString("observations"),Double.parseDouble(rs.
                        getString("unit_price")),Double.parseDouble(rs.
                        getString("total_amount"))
                ));
            }

        } catch (SQLException ex) {
            System.out.println("No se pudieron cargar los datos" + 
                    ex.getMessage());
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
