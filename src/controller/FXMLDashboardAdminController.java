/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLDashboardAdminController implements Initializable {

    @FXML
    private AnchorPane paneDash;
    @FXML
    private AnchorPane slider;
    @FXML
    private StackPane containerMenu;
    @FXML
    private Button btnCash;
    @FXML
    private Button btnDash;
    @FXML
    private Button btnCoffee;
    @FXML
    private Button btnDessert;
    @FXML
    private Button btnMilkShake;
    @FXML
    private Button btnReport;
    @FXML
    private Button btnUsers;
    @FXML
    private ImageView menuHamb;
    @FXML
    private Button btnMenuHamb;
    @FXML
    private VBox VBoxSlider;
    private boolean isMenuVisible = true;
    private List<Button> menuButtons;
    @FXML
    private Button btnLogOut;
    @FXML
    private Pane paneName;
    @FXML
    private Label lblTitle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // Cargar la vista del dashboard al inicio
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/view/FXMLHome.fxml"));
            containerMenu.getChildren().clear(); // 
            containerMenu.getChildren().add(root); //
        } catch (IOException ex) {
            System.out.println("" + ex);

        }
    menuButtons = new ArrayList<>();
    menuButtons.add(btnDash);
    menuButtons.add(btnCash);
    menuButtons.add(btnCoffee);
    menuButtons.add(btnDessert);
    menuButtons.add(btnMilkShake);
    menuButtons.add(btnReport);
    menuButtons.add(btnUsers);
    menuButtons.add(btnLogOut);
    }    

    @FXML
    private void openDash(MouseEvent event) {
    resetAllSelections();
    btnDash.getStyleClass().add("selected");
     try {
            // Cargar la vista del dashboard al inicio
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/view/FXMLHome.fxml"));
            containerMenu.getChildren().clear(); // 
            containerMenu.getChildren().add(root); //
        } catch (IOException ex) {
            System.out.println("" + ex);
        }
    }


    @FXML
    private void openUsers(MouseEvent event) {
        resetAllSelections();
        btnUsers.getStyleClass().add("selected");
        try {
            // Cargar la vista del dashboard al inicio
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/view/FXMLUsers.fxml"));
            containerMenu.getChildren().clear(); // 
            containerMenu.getChildren().add(root); //
        } catch (IOException ex) {
            System.out.println("" + ex);
        }
    }

    @FXML
    private void loginBack(ActionEvent event) {
    }

    @FXML
    private void openCash(MouseEvent event) {
    resetAllSelections();
    btnCash.getStyleClass().add("selected");
     try {
            // Cargar la vista del dashboard al inicio
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/view/FXMLCash.fxml"));
            containerMenu.getChildren().clear(); // 
            containerMenu.getChildren().add(root); //
        } catch (IOException ex) {
            System.out.println("" + ex);

        }
    
    }

    @FXML
    private void openCoffee(MouseEvent event) {
        resetAllSelections();
        btnCoffee.getStyleClass().add("selected");
    }

    @FXML
    private void openDessert(MouseEvent event) {
        resetAllSelections();
        btnDessert.getStyleClass().add("selected");
    }

    @FXML
    private void openMilkShake(MouseEvent event) {
        resetAllSelections();
        btnMilkShake.getStyleClass().add("selected");
    }

    @FXML
    private void openReports(MouseEvent event) {
        resetAllSelections();
        btnReport.getStyleClass().add("selected");
    }
    
    private void resetAllSelections() {
    btnCash.getStyleClass().remove("selected");
    btnDash.getStyleClass().remove("selected");
    btnCoffee.getStyleClass().remove("selected");
    btnDessert.getStyleClass().remove("selected");
    btnMilkShake.getStyleClass().remove("selected");
    btnReport.getStyleClass().remove("selected");
    btnUsers.getStyleClass().remove("selected");
}

    @FXML
    private void toggleMenu(MouseEvent event) {
         if (isMenuVisible) {
        slider.setPrefWidth(50);
        slider.setMinWidth(50);
        paneName.setPrefWidth(50);
        paneName.setMinWidth(50);
        lblTitle.setText("");

        for (Button button : menuButtons) {
            button.setText(""); // Oculta el texto en los botones
            button.getStyleClass().add("button-collapsed"); // Aplica la clase CSS
        }
    } else {
        slider.setPrefWidth(178);
        slider.setMinWidth(178);
        paneName.setPrefWidth(178);
        paneName.setMinWidth(178);
        lblTitle.setText("Cafetería Pan");
        menuButtons.get(0).setText("Dashboard");
        menuButtons.get(1).setText("Caja");
        menuButtons.get(2).setText("Cafés");
        menuButtons.get(3).setText("Postres");
        menuButtons.get(4).setText("Batidos");
        menuButtons.get(5).setText("Ventas");
        menuButtons.get(6).setText("Usuarios");
        menuButtons.get(7).setText("Salir");

        for (Button button : menuButtons) {
            button.getStyleClass().remove("button-collapsed"); // Quita la clase CSS
        }
    }
    isMenuVisible = !isMenuVisible; // Cambia el estado
    }
}
