/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private Label label_users;
    @FXML
    private Label label_books;
    @FXML
    private Label label_laptos;
    @FXML
    private Label label_tablets;
    @FXML
    private Label label_Ptablets;
    @FXML
    private Label label_Plaptos;
    @FXML
    private Label label_Pbooks;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
