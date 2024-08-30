/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private PasswordField txt_password;
    @FXML
    private ComboBox<?> cmbType;
    @FXML
    private TextField txt_search;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private TableView<?> tbw_users;
    @FXML
    private TableColumn<?, ?> column_id;
    @FXML
    private TableColumn<?, ?> column_birthDay;
    @FXML
    private TableColumn<?, ?> column_identification;
    @FXML
    private TableColumn<?, ?> column_name;
    @FXML
    private TableColumn<?, ?> column_lastName;
    @FXML
    private TableColumn<?, ?> column_secondName;
    @FXML
    private TableColumn<?, ?> column_phone;
    @FXML
    private TableColumn<?, ?> column_idUser;
    @FXML
    private TableColumn<?, ?> column_correo;
    @FXML
    private TableColumn<?, ?> column_password;
    @FXML
    private TableColumn<?, ?> column_type;
    @FXML
    private TextField txt_idPerson;
    @FXML
    private TextField txt_idUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void search(KeyEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void Items(MouseEvent event) {
    }
    
}
