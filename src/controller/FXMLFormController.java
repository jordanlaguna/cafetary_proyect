package controller;

import classes.Coffe;
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

public class FXMLFormController implements Initializable {

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
    private Coffe currentCoffe;
    private FXMLCoffesController coffesController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imagePicker.setOnMouseClicked(event -> chooseImage());

        btnAdd.setOnAction(event -> addCoffee());
        btnModif.setOnAction(event -> modifyCoffee());
    }

    // Método para elegir la imagen
    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
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
    private void addCoffee() {
        String name = textFieldName.getText();
        float price = Float.parseFloat(textFieldPrice.getText());

        if (imagePath == null || imagePath.isEmpty()) {
            System.out.println("Por favor selecciona una imagen.");
            return;
        }

        try (Connection conn = ConnectionCoffesDB.conn()) {
            String sql = "INSERT INTO coffes (name, price, image) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setString(3, imagePath);  // Guarda la ruta de la imagen
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
                alert.setContentText("Café agregado con éxito.");
                alert.showAndWait();
            }

            System.out.println("Café agregado correctamente.");

            // Actualizar la lista en el controlador principal
            coffesController.refreshCoffees();
            closeWindow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para modificar un café existente en la base de datos
    private void modifyCoffee() {
        String name = textFieldName.getText();
        float price = Float.parseFloat(textFieldPrice.getText());

        if (currentCoffe == null) {
            System.out.println("No hay café seleccionado para modificar.");
            return;
        }

        try (Connection conn = ConnectionCoffesDB.conn()) {
            String sql = "UPDATE coffes SET name = ?, price = ?, image = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);

            // Si no se seleccionó una nueva imagen, usar la imagen actual
            if (imagePath == null || imagePath.isEmpty()) {
                ps.setString(3, currentCoffe.getImage());
            } else {
                ps.setString(3, imagePath);
            }

            ps.setInt(4, currentCoffe.getId());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("CONFIRMACIÓN");
            alert.setContentText("¿Deseas modificar los datos?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                ps.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Café modificado con éxito.");
                alert.showAndWait();
            }

            // Actualizar la lista en el controlador principal
            coffesController.refreshCoffees();
            closeWindow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar el formulario con los datos del café seleccionado
    public void setCoffee(Coffe coffee) {
        this.currentCoffe = coffee;
        textFieldName.setText(coffee.getName());
        textFieldPrice.setText(String.valueOf(coffee.getPrice()));

        // Cargar la imagen actual del café
        imagePath = coffee.getImage();
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
    public void setCoffesController(FXMLCoffesController coffesController) {
        this.coffesController = coffesController;
    }
}
