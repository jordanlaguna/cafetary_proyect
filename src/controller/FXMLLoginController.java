/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author jorda
 */
public class FXMLLoginController implements Initializable {

    private Label label;
    @FXML
    private Label label2;
    @FXML
    private PasswordField passwordRegis;
    @FXML
    private TextField emailLogin;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private Label labelLogin;
    @FXML
    private Label labelUno;
    @FXML
    private Button buttonRegis;
    @FXML
    private Button buttonLogin;
    @FXML
    private AnchorPane paneDos;
    @FXML
    private AnchorPane paneUno;
    @FXML
    private Label forgotPassword;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonInicio;
    private ComboBox cmbBox;
    @FXML
    private ImageView iconLogin;
    @FXML
    private ImageView iconPass;
    @FXML
    private TextField userName;
    @FXML
    private TextField identification;
    @FXML
    private TextField secondName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField name;
    @FXML
    private DatePicker birthDay;
    private ComboBox cmbType;
    @FXML
    private TextField telephone;

    @FXML
    private Label textRegis;
    @FXML
    private Label textRegis1;
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_exit1;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @FXML
    private AnchorPane containerLogin;
    /**
     * FXML Controller class
     *
     * @author jorda
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Desplazar paneUno para mostrar el formulario de inicio de sesión
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(paneUno);

        slide.setToX(570);
        slide.play();

        paneDos.setTranslateX(-400);
        labelLogin.setVisible(true);
        emailLogin.setVisible(true);
        passwordLogin.setVisible(true);
        buttonLogin.setVisible(true);
        forgotPassword.setVisible(true);
        buttonInicio.setVisible(true);
        iconLogin.setVisible(true);
        iconPass.setVisible(true);
        btn_exit1.setVisible(true);

        textRegis.setVisible(false);
        textRegis1.setVisible(false);
        label2.setVisible(false);
        passwordRegis.setVisible(false);
        buttonRegister.setVisible(false);
        buttonRegis.setVisible(false);

        identification.setVisible(false);
        name.setVisible(false);
        lastName.setVisible(false);
        secondName.setVisible(false);
        birthDay.setVisible(false);
        telephone.setVisible(false);
        userName.setVisible(false);
        btn_exit.setVisible(false);

        slide.setOnFinished((e -> {
            // Aquí puedes agregar cualquier lógica adicional al finalizar la animación
        }));
    }

    @FXML
    private void iniciarSesion(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(paneUno);

        slide.setToX(570);
        slide.play();

        paneDos.setTranslateX(-400);
        labelLogin.setVisible(true);
        emailLogin.setVisible(true);
        passwordLogin.setVisible(true);
        buttonLogin.setVisible(true);
        forgotPassword.setVisible(true);
        buttonInicio.setVisible(true);
        iconLogin.setVisible(true);
        iconPass.setVisible(true);
        btn_exit1.setVisible(true);

        textRegis.setVisible(false);
        textRegis1.setVisible(false);
        label2.setVisible(false);
        passwordRegis.setVisible(false);
        buttonRegister.setVisible(false);
        buttonRegis.setVisible(false);

        identification.setVisible(false);
        name.setVisible(false);
        lastName.setVisible(false);
        secondName.setVisible(false);
        birthDay.setVisible(false);
        telephone.setVisible(false);
        userName.setVisible(false);
        btn_exit.setVisible(false);

        slide.setOnFinished((e -> {

        }));
    }

    @FXML
    private void registrarUsuario(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(paneUno);

        slide.setToX(0);
        slide.play();

        paneDos.setTranslateX(10);
        labelLogin.setVisible(false);
        emailLogin.setVisible(false);
        passwordLogin.setVisible(false);
        buttonLogin.setVisible(false);
        forgotPassword.setVisible(false);
        buttonInicio.setVisible(false);
        iconLogin.setVisible(false);
        iconPass.setVisible(false);
        btn_exit1.setVisible(false);

        label2.setVisible(true);
        userName.setVisible(true);
        passwordRegis.setVisible(true);
        buttonRegister.setVisible(true);
        buttonRegis.setVisible(true);
        identification.setVisible(true);
        name.setVisible(true);
        lastName.setVisible(true);
        secondName.setVisible(true);
        birthDay.setVisible(true);
        telephone.setVisible(true);
        userName.setVisible(true);
        btn_exit.setVisible(true);

        slide.setOnFinished((e -> {

        }));
    }

    /**
     *
     * @param event is event of login
     * @throws IOException
     */
    @FXML
    private void Login(ActionEvent event) throws IOException {
        String email = emailLogin.getText();
        String password = passwordLogin.getText();

        User user = new User(0, null, null, null, null, null, 0, 0, email,
                password);
        boolean loginSuccessful = user.login(email, password);
        try {
            if (loginSuccessful) {
                buttonInicio.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource(""
                        + "/view/FXMLDashboardAdmin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                Image icon = new Image(getClass().getResourceAsStream("/image/"
                        + "login/logoTienda.png"));
                mainStage.getIcons().add(icon);
                mainStage.setTitle("Cafetería Pan");
                mainStage.show();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Bienvenido de nuevo! "+ email);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Usuario/Contraseña incorrectos");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("No se puede iniciar sesión, "
                    + "ingrese los datos en la caja de texto. " + e);
            alert.showAndWait();
        }

    }

    /**
     *
     * @param event event of register
     * @throws SQLException
     */
    @FXML
    private void registrarUser(ActionEvent event) throws SQLException {
        LocalDate localDate = birthDay.getValue();
        Date dateOfBirth = Date.valueOf(localDate);
        User user = new User(0,dateOfBirth, identification.getText(),
                name.getText(), lastName.getText(), secondName.getText(),
                Integer.parseInt(telephone.getText()),0, userName.getText(),
                passwordRegis.getText());
        user.registrarse();
        cleanData();
         
    }

    /**
     * {
     *
     * @param event event for the button
     */
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    private void cleanData() {
        birthDay.setValue(null);
        identification.clear();
        name.clear();
        lastName.clear();
        secondName.clear();
        telephone.clear();
        userName.clear();
        passwordRegis.clear();
        cmbType.setValue(null);
    }

    /**
     *
     * @param event is event forgotPassword
     * @throws IOException
     */

    @FXML
    private void lb_olvidar(MouseEvent event) throws IOException {
        // Regresa al inicio LOGIN 
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista"
                + "/FXMLForgetPassword.fxml"));
        Parent root = loader.load();
        ForgetPasswordController ac = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
        });

        Stage myStage = (Stage) this.containerLogin.getScene().getWindow();
        myStage.close();
         */

    }
}
