/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.User;
import connectionDB.ConnectionUserDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLUsersController implements Initializable {
      
    @FXML
    private TextField txt_identification;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_lastName;
    @FXML
    private TextField txt_secondName;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_password;
    private ComboBox cmbType;
    @FXML
    private TextField txt_search;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private TableView<User> tbw_users;
    @FXML
    private TableColumn<User, Integer> column_id;
    @FXML
    private TableColumn<User, java.sql.Date> column_birthDay;
    @FXML
    private TableColumn<User, String> column_identification;
    @FXML
    private TableColumn<User, String> column_name;
    @FXML
    private TableColumn<User, String> column_lastName;
    @FXML
    private TableColumn<User, String> column_secondName;
    @FXML
    private TableColumn<User, Integer> column_phone;
    @FXML
    private TableColumn<User, Integer> column_idUser;
    @FXML
    private TableColumn<User, String> column_correo;
    @FXML
    private TableColumn<User, String> column_password;

    private ObservableList<User> users = FXCollections.observableArrayList();
    @FXML
    private TextField txt_idPerson;
    @FXML
    private TextField txt_idUser;

    private Integer index;
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        loadData();
    }

    @FXML
    private void search(KeyEvent event) {
        FilteredList<User> filterData = new FilteredList<>(users, p -> true);
        txt_search.textProperty().addListener((obsevable, oldvalue, newvalue)
                -> {
            filterData.setPredicate(User -> {
                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String tipoTexto = newvalue.toLowerCase();
                if (User.getBirth_date().toString().contains(tipoTexto)) {

                    return true;
                }
                if (User.getIdentification().toLowerCase().indexOf(tipoTexto)
                        != -1) {

                    return true;
                }
                if (User.getName().toLowerCase().indexOf(tipoTexto) != -1) {

                    return true;
                }

                if (User.getLastName().toLowerCase().indexOf(tipoTexto) != -1) {

                    return true;
                }
                if (User.getSecondName().toLowerCase().indexOf(tipoTexto)
                        != -1) {

                    return true;
                }
                if (String.valueOf(User.getTelephone()).toLowerCase().
                        indexOf(tipoTexto) != -1) {

                    return true;
                }
                if (User.getEmail().toLowerCase().indexOf(tipoTexto) != -1) {

                    return true;
                }
                if (User.getPassword().toLowerCase().indexOf(tipoTexto) != -1) {

                    return true;
                }
              
                return false;
            });
            SortedList<User> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(tbw_users.comparatorProperty());
            tbw_users.setItems(sortedList);
        });
        
    }

    @FXML
    private void update(ActionEvent event) {
          try {
            conn = ConnectionUserDB.getConnection();
            String value1 = txt_identification.getText();
            String value2 = txt_name.getText();
            String value3 = txt_lastName.getText();
            String value4 = txt_secondName.getText();
            String value5 = txt_phone.getText();
            String value6 = txt_email.getText();
            String value7 = txt_password.getText();
            int idUser = Integer.parseInt(txt_idUser.getText()); 

            // Consulta para actualizar la tabla person
            String sqlPerson = "update person set identification = ?,"
                + " name = ?, lastName = ?, secondName = ?, telephone = ? "
                + "where id_person = ?";

            // Consulta para actualizar la tabla user
            String sqlUser = "update user set email = ?, password = ?, "
                    + "where id_user = ?";

            PreparedStatement psPerson = conn.prepareStatement(sqlPerson);
            PreparedStatement psUser = conn.prepareStatement(sqlUser);

            // Personas
            psPerson.setString(1, value1);
            psPerson.setString(2, value2);
            psPerson.setString(3, value3);
            psPerson.setString(4, value4);
            psPerson.setString(5, value5);
            psPerson.setInt(6, idUser); 
            //Usurios
            psUser.setString(1, value6);
            psUser.setString(2, value7);
            psUser.setInt(4, idUser); 

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("CONFIRMACIÓN");
            alert.setContentText("¿Desea modificar los datos?");
            Optional<ButtonType> opcion = alert.showAndWait();

            if (opcion.get().equals(ButtonType.OK)) {
                psPerson.executeUpdate();
                psUser.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Datos modificados con éxito.");
                alert.showAndWait();
            }
            //Cerramos las conexiones
            psPerson.close();
            psUser.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("No se pudo modificar el usuario. " + e);
            alert.showAndWait();
        }
        loadData();
    }

    @FXML
    private void delete(ActionEvent event) {
         String sqlDeletePerson = "delete from person where id_person = ?";
        String sqlDeleteUser = "delete from user where id_user = ?";

        try {
            conn = ConnectionUserDB.getConnection();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("CONFIRMACIÓN");
            alert.setContentText("¿Desea eliminar los datos?");
            Optional<ButtonType> opcion = alert.showAndWait();

            if (opcion.get().equals(ButtonType.OK)) {
                // Eliminar primero los registros relacionados en la tabla user
                ps1 = conn.prepareStatement(sqlDeleteUser);
                ps1.setInt(1, Integer.parseInt(txt_idUser.getText()));
                ps1.execute();

                // Luego eliminar la fila en la tabla person
                ps = conn.prepareStatement(sqlDeletePerson);
                ps.setInt(1, Integer.parseInt(txt_idPerson.getText()));
                ps.execute();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Datos eliminados con éxito.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Los datos no se pudieron eliminar. " + e);
            alert.showAndWait();
        }
        loadData();
    }

    @FXML
    private void Items(MouseEvent event) {
        index = tbw_users.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        Integer idValue = column_id.getCellData(index);
        txt_idPerson.setText(String.valueOf(idValue));
        Integer idUser = column_idUser.getCellData(index);
        txt_idUser.setText(String.valueOf(idUser));
        java.sql.Date sqlDate = (java.sql.Date) column_birthDay.
                getCellData(index);
        // Convierte java.sql.Date a LocalDate
        LocalDate dateValue = sqlDate.toLocalDate();
        // Establece la fecha en el DatePicker
        datePicker.setValue(dateValue);
        txt_identification.setText(column_identification.getCellData(index));
        txt_name.setText(column_name.getCellData(index));
        txt_lastName.setText(column_lastName.getCellData(index));
        txt_secondName.setText(column_secondName.getCellData(index));
        txt_phone.setText(column_phone.getCellData(index).toString());
        txt_email.setText(column_correo.getCellData(index));
        txt_password.setText(column_password.getCellData(index));
    }
    
    private void loadData() {

        conn = ConnectionUserDB.getConnection();
        column_id.setCellValueFactory(new PropertyValueFactory<User,
                Integer>("id_person"));
        column_birthDay.setCellValueFactory(new PropertyValueFactory<User,
                java.sql.Date>("birth_date"));
        column_identification.setCellValueFactory(new PropertyValueFactory<
                User, String>("identification"));
        column_name.setCellValueFactory(new PropertyValueFactory<User,
                String>("name"));
        column_lastName.setCellValueFactory(new PropertyValueFactory<User,
                String>("lastName"));
        column_secondName.setCellValueFactory(new PropertyValueFactory<User,
                String>("secondName"));
        column_phone.setCellValueFactory(new PropertyValueFactory<User,
                Integer>("telephone"));
        column_idUser.setCellValueFactory(new PropertyValueFactory<User,
                Integer>("id_user"));
        column_correo.setCellValueFactory(new PropertyValueFactory<User,
                String>("email"));
        column_password.setCellValueFactory(new PropertyValueFactory<User,
                String>("password"));
        users = ConnectionUserDB.getDataUser();
        tbw_users.setItems(users);
    }

}
