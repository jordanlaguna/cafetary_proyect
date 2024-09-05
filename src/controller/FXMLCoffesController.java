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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLCoffesController implements Initializable {

    @FXML
    private TextField txt_numLoan;
    @FXML
    private TextField txt_numLoan1;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_email1;
    @FXML
    private TextField txt_search;
    @FXML
    private TableView<?> tbw_libros;
    @FXML
    private TableColumn<?, ?> column_id;
    @FXML
    private TableColumn<?, ?> column_numLoan;
    @FXML
    private TableColumn<?, ?> colum_dateLoan;
    @FXML
    private TableColumn<?, ?> column_dateReturn;
    @FXML
    private TableColumn<?, ?> column_editorial;
    @FXML
    private TableColumn<?, ?> column_observations;
    @FXML
    private TableColumn<?, ?> column_fullName;
    @FXML
    private TextField txt_numLoan11;
    @FXML
    private TextField txt_numLoan111;
    @FXML
    private TextField txt_numLoan1111;

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
    private void btn_add(ActionEvent event) {
    }
    
}
