package controller;

import classes.Coffe;
import static connectionDB.ConnectionCoffesDB.getDataCoffe;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class FXMLCoffesController implements Initializable {

    @FXML
    private Label lblname1;
    @FXML
    private Label lblprice1;
    @FXML
    private StackPane image1;
    @FXML
    private Spinner<?> Spinner1;
    @FXML
    private Label lblname2;
    @FXML
    private Label lblprice2;
    @FXML
    private StackPane image2;
    @FXML
    private Spinner<?> Spinner2;
    @FXML
    private Label lblname3;
    @FXML
    private Label lblprice3;
    @FXML
    private StackPane image3;
    @FXML
    private Spinner<?> Spinner3;
    @FXML
    private Label lblname4;
    @FXML
    private Label lblprice4;
    @FXML
    private StackPane image4;
    @FXML
    private Spinner<?> Spinner4;
    @FXML
    private Label lblname5;
    @FXML
    private Label lblprice5;
    @FXML
    private StackPane image5;
    @FXML
    private Spinner<?> Spinner5;
    @FXML
    private Label lblname6;
    @FXML
    private Label lblprice6;
    @FXML
    private StackPane image6;
    @FXML
    private Spinner<?> Spinner6;
    @FXML
    private Label lblname7;
    @FXML
    private Label lblprice7;
    @FXML
    private StackPane image7;
    @FXML
    private Spinner<?> Spinner7;
    @FXML
    private Label lblname8;
    @FXML
    private Label lblprice8;
    @FXML
    private StackPane image8;
    @FXML
    private Spinner<?> Spinner8;
    @FXML
    private Label lblname9;
    @FXML
    private Label lblprice9;
    @FXML
    private StackPane image9;
    @FXML
    private Spinner<?> Spinner9;
    @FXML
    private Label lblname10;
    @FXML
    private Label lblprice10;
    @FXML
    private StackPane image10;
    @FXML
    private Spinner<?> Spinner10;
    @FXML
    private Label lblname11;
    @FXML
    private Label lblprice11;
    @FXML
    private StackPane image11;
    @FXML
    private Spinner<?> Spinner11;
    @FXML
    private Label lblname12;
    @FXML
    private Label lblprice12;
    @FXML
    private StackPane image12;
    @FXML
    private Spinner<?> Spinner12;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Cargar y mostrar los cafés desde la base de datos
        refreshCoffees();

        // Asignar manejadores de clic a las imágenes para abrir el formulario de agregar café
        assignClickHandlers();
    }

 
    // Método para llenar los espacios vacíos con imágenes y etiquetas por defecto
    private void fillEmptySpaces() {
        if (lblname1.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname1, lblprice1, image1);
        }
        if (lblname2.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname2, lblprice2, image2);
        }
        if (lblname3.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname3, lblprice3, image3);
        }
        if (lblname4.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname4, lblprice4, image4);
        }
        if (lblname5.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname5, lblprice5, image5);
        }
        if (lblname6.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname6, lblprice6, image6);
        }
        if (lblname7.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname7, lblprice7, image7);
        }
        if (lblname8.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname8, lblprice8, image8);
        }
        if (lblname9.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname9, lblprice9, image9);
        }
        if (lblname10.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname10, lblprice10, image10);
        }
        if (lblname11.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname11, lblprice11, image11);
        }
        if (lblname12.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblname12, lblprice12, image12);
        }
    }

    // Método para asignar imágenes y etiquetas por defecto a los espacios vacíos
    private void assignDefaultLabelAndImage(Label nameLabel, Label priceLabel, StackPane imagePane) {
        nameLabel.setText("Espacio vacío");
        priceLabel.setText("$0.00");

        // Asigna una imagen por defecto
        ImageView defaultImageView = new ImageView(new Image(new File("path/to/default/image.png").toURI().toString()));
        defaultImageView.setFitWidth(110);
        defaultImageView.setFitHeight(110);
        imagePane.getChildren().add(defaultImageView);
    }

    // Asignar manejadores de clic para abrir el formulario de agregar café en espacios vacíos
    private void assignClickHandlers() {
        image1.setOnMouseClicked(event -> openFormEmptySlot());
        image2.setOnMouseClicked(event -> openFormEmptySlot());
        image3.setOnMouseClicked(event -> openFormEmptySlot());
        image4.setOnMouseClicked(event -> openFormEmptySlot());
        image5.setOnMouseClicked(event -> openFormEmptySlot());
        image6.setOnMouseClicked(event -> openFormEmptySlot());
        image7.setOnMouseClicked(event -> openFormEmptySlot());
        image8.setOnMouseClicked(event -> openFormEmptySlot());
        image9.setOnMouseClicked(event -> openFormEmptySlot());
        image10.setOnMouseClicked(event -> openFormEmptySlot());
        image11.setOnMouseClicked(event -> openFormEmptySlot());
        image12.setOnMouseClicked(event -> openFormEmptySlot());
    }

    // Método para abrir el formulario para agregar un nuevo café en los espacios vacíos
    // Método para abrir el formulario para agregar un nuevo café en los espacios vacíos
    private void openFormEmptySlot() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLForm.fxml"));
            Parent root = loader.load();

            FXMLFormController formController = loader.getController();

            // Pasar el controlador principal para refrescar la lista al agregar café
            formController.setCoffesController(this);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Agregar Café");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para refrescar la lista de cafés
    public void refreshCoffees() {
        ObservableList<Coffe> coffees = getDataCoffe();

        // Limpiar todos los espacios antes de actualizarlos
        image1.getChildren().clear();
        lblname1.setText("");
        lblprice1.setText("");
        image2.getChildren().clear();
        lblname2.setText("");
        lblprice2.setText("");
        image3.getChildren().clear();
        lblname3.setText("");
        lblprice3.setText("");
        image4.getChildren().clear();
        lblname4.setText("");
        lblprice4.setText("");
        image5.getChildren().clear();
        lblname5.setText("");
        lblprice5.setText("");
        image6.getChildren().clear();
        lblname6.setText("");
        lblprice6.setText("");
        image7.getChildren().clear();
        lblname7.setText("");
        lblprice7.setText("");
        image8.getChildren().clear();
        lblname8.setText("");
        lblprice8.setText("");
        image9.getChildren().clear();
        lblname9.setText("");
        lblprice9.setText("");
        image10.getChildren().clear();
        lblname10.setText("");
        lblprice10.setText("");
        image11.getChildren().clear();
        lblname11.setText("");
        lblprice11.setText("");
        image12.getChildren().clear();
        lblname12.setText("");
        lblprice12.setText("");

        // Actualizar los espacios ocupados
        if (coffees != null && !coffees.isEmpty()) {
            if (coffees.size() > 0) {
                assignCoffeToLabelAndImage(coffees.get(0), lblname1, lblprice1, image1);
            }
            if (coffees.size() > 1) {
                assignCoffeToLabelAndImage(coffees.get(1), lblname2, lblprice2, image2);
            }
            if (coffees.size() > 2) {
                assignCoffeToLabelAndImage(coffees.get(2), lblname3, lblprice3, image3);
            }
            if (coffees.size() > 3) {
                assignCoffeToLabelAndImage(coffees.get(3), lblname4, lblprice4, image4);
            }
            if (coffees.size() > 4) {
                assignCoffeToLabelAndImage(coffees.get(4), lblname5, lblprice5, image5);
            }
            if (coffees.size() > 5) {
                assignCoffeToLabelAndImage(coffees.get(5), lblname6, lblprice6, image6);
            }
            if (coffees.size() > 6) {
                assignCoffeToLabelAndImage(coffees.get(6), lblname7, lblprice7, image7);
            }
            if (coffees.size() > 7) {
                assignCoffeToLabelAndImage(coffees.get(7), lblname8, lblprice8, image8);
            }
            if (coffees.size() > 8) {
                assignCoffeToLabelAndImage(coffees.get(8), lblname9, lblprice9, image9);
            }
            if (coffees.size() > 9) {
                assignCoffeToLabelAndImage(coffees.get(9), lblname10, lblprice10, image10);
            }
            if (coffees.size() > 10) {
                assignCoffeToLabelAndImage(coffees.get(10), lblname11, lblprice11, image11);
            }
            if (coffees.size() > 11) {
                assignCoffeToLabelAndImage(coffees.get(11), lblname12, lblprice12, image12);
            }
        }

        // Llenar los espacios vacíos con valores predeterminados
        fillEmptySpaces();
    }

    // Método auxiliar para asignar café a etiquetas e imagenes
    private void assignCoffeToLabelAndImage(Coffe coffee, Label nameLabel, Label priceLabel, StackPane imagePane) {
        nameLabel.setText(coffee.getName());
        priceLabel.setText(""+coffee.getPrice());
        ImageView imageView = new ImageView(new Image(new File(coffee.getImage()).toURI().toString()));
        imageView.setFitWidth(110);
        imageView.setFitHeight(110);
        imagePane.getChildren().add(imageView);
    }

    @FXML
    private void btn_add(ActionEvent event) {
        // Lógica para agregar un nuevo café
    }
}
