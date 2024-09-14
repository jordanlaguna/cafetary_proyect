/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Dessert;
import connectionDB.ConnectionCoffesDB;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLFormDessertController implements Initializable {

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldPrice;
    @FXML
    private ImageView imagePicker;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnModif;
    private String imagePath;
    private Dessert currentDessert;
    private FXMLDessertController dessertController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imagePicker.setOnMouseClicked(event -> chooseImage());
        btnAdd.setOnAction(event -> addDessert());
        btnModif.setOnAction(event -> modifyDessert());
    }

    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", 
                        "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            imagePath = file.getAbsolutePath();  // Guarda la ruta de la imagen
            Image image = new Image(file.toURI().toString());  // Carga la imagen
            imagePicker.setImage(image);  // Muestra la imagen en el ImageView
            imagePicker.setFitWidth(110);
            imagePicker.setFitHeight(110);

        }
    }
      // Método para agregar el café a la base de datos
    private void addDessert() {
        String name = textFieldName.getText();
        float price = Float.parseFloat(textFieldPrice.getText());

        if (imagePath == null || imagePath.isEmpty()) {
            System.out.println("Por favor selecciona una imagen.");
            return;
        }

        try (Connection conn = ConnectionCoffesDB.conn()) {
            String sql = "INSERT INTO desserts (name, price, image) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setString(3, imagePath);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("CONFIRMACIÓN");
            alert.setContentText("¿Deseas agregar los datos?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                ps.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Postre agregado con éxito.");
                alert.showAndWait();
            }


            // Actualizar la lista en el controlador principal
            dessertController.refreshDessert();
            closeWindow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para modificar un café existente en la base de datos
    private void modifyDessert() {
        String name = textFieldName.getText();
        float price = Float.parseFloat(textFieldPrice.getText());

        if (currentDessert == null) {
            System.out.println("No hay postre seleccionado para modificar.");
            return;
        }

        try (Connection conn = ConnectionCoffesDB.conn()) {
            String sql = "UPDATE desserts SET name = ?, price = ?, image = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);

            // Si no se seleccionó una nueva imagen, usar la imagen actual
            if (imagePath == null || imagePath.isEmpty()) {
                ps.setString(3, currentDessert.getImage());
            } else {
                ps.setString(3, imagePath);
            }

            ps.setInt(4, currentDessert.getId()); 
            ps.executeUpdate();
            System.out.println("Postre modificado correctamente.");

            // Actualizar la lista en el controlador principal
            dessertController.refreshDessert();
            closeWindow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar el formulario con los datos del café seleccionado
    public void setDessert(Dessert dessert) {
        this.currentDessert = dessert;
        textFieldName.setText(dessert.getName());
        textFieldPrice.setText(String.valueOf(dessert.getPrice()));

        // Cargar la imagen actual del postre
        imagePath = dessert.getImage();
        if (imagePath != null && !imagePath.isEmpty()) {
            Image image = new Image(new File(imagePath).toURI().toString());
            imagePicker.setImage(image);
        }
    }

    // Método para cerrar la ventana después de agregar o modificar un café
    private void closeWindow() {
        Stage stage = (Stage) textFieldName.getScene().getWindow();
        stage.close();
    }

    // Método para pasar el controlador principal para poder refrescar la lista
    public void setDessertController(FXMLDessertController dessertsController) {
        this.dessertController = dessertsController;
    }
}
