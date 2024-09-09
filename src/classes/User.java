/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import connectionDB.ConnectionLoginDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author jorda
 */
public class User extends Person {

    private int id_user;
    private String email;
    private String password;
    private String type;

    /**
     * @param id_person To request the id_person
     * @param birth_date =
     * @param identification = To request the user's ID
     * @param name = To request the name of the user
     * @param lastName = To request the last name of the user
     * @param secondName = To request the last name of the user
     * @param telephone = To request the last name of the user
     * @param id_user To request the id_user of the user
     * @param email =username: A String attribute that likely stores the
     * username of the user.
     * @param password = password: A String attribute that likely stores the
     * user's password.
     * @param type = type: A String attribute of user classification or
     * categorization, such as "teacher", "student".
     */
    public User(int id_person, Date birth_date, String identification,
            String name, String lastName, String secondName, int telephone,
            int id_user, String email, String password, String type) {
        super(id_person, birth_date, identification, name, lastName, secondName,
                telephone);
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {

    }

    public int getId_user() {
        return id_user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean login(String email, String password, String type) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionLoginDB.conn();
        String sql = "select * from user where email = ? and password = ? "
                + "and type = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.email);
            ps.setString(2, this.password);
            ps.setString(3, this.type);
            rs = ps.executeQuery();

            if (rs.next()) {
                if ("Admin".equals(this.type)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("INFORMACIÓN");
                    alert.setContentText("Bienvenido administrador "
                            + getEmail());
                    alert.showAndWait();
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * The function to register as a user, whether a person or student
     */
    public void registrarse() throws SQLException {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = ConnectionLoginDB.conn();
            conn.setAutoCommit(false);

            // Insertar en la tabla "person"
            String sqlPerson = "insert into person ( birth_date, "
                    + "identification, " + "name, "
                    + "lastName, secondName, telephone) "
                    + "values (?, ?, ?, ?, ?, ?)";
            ps1 = conn.prepareStatement(sqlPerson, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, this.getBirth_date().toString());
            ps1.setString(2, this.getIdentification());
            ps1.setString(3, this.getName());
            ps1.setString(4, this.getLastName());
            ps1.setString(5, this.getSecondName());
            ps1.setString(6, String.valueOf(this.getTelephone()));
            ps1.executeUpdate();

            ResultSet generatedKeys = ps1.getGeneratedKeys();
            int idPerson = -1;
            if (generatedKeys.next()) {
                idPerson = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID de persona"
                        + " generado.");
            }

            // Insertar en la tabla "user"
            String sqlUser = "insert into user (id_user, email, password, type)"
                    + " values (?, ?, ?, ?)";
            ps2 = conn.prepareStatement(sqlUser);
            ps2.setInt(1, idPerson); //Usar el ID de persona como ID de usuario
            ps2.setString(2, this.getEmail());
            ps2.setString(3, this.getPassword());
            ps2.setString(4, this.getType());
            ps2.executeUpdate();

            conn.commit();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Usuario agregado con éxito");
            alert.showAndWait();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se pudo agregar el usuario: ");
            alert.showAndWait();
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
