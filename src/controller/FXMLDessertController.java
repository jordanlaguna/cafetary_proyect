/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Dessert;
import static connectionDB.ConnectionDessertDB.getDataDessert;
import connectionDB.OrdersDB;
import controller.FXMLCoffesController.OrderItem;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLDessertController implements Initializable {
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblName1;
    @FXML
    private Label lblPrice1;
    @FXML
    private StackPane image1;
    @FXML
    private Label lblName2;
    @FXML
    private Label lblPrice2;
    @FXML
    private StackPane image2;
    @FXML
    private Label lblName3;
    @FXML
    private Label lblPrice3;
    @FXML
    private StackPane image3;
    @FXML
    private Label lblName4;
    @FXML
    private Label lblPrice4;
    @FXML
    private StackPane image4;
    @FXML
    private Label lblName5;
    @FXML
    private Label lblPrice5;
    @FXML
    private StackPane image5;
    @FXML
    private Label lblName6;
    @FXML
    private Label lblPrice6;
    @FXML
    private StackPane image6;
    @FXML
    private Label lblName7;
    @FXML
    private Label lblPrice7;
    @FXML
    private StackPane image7;
    @FXML
    private Label lblName8;
    @FXML
    private Label lblPrice8;
    @FXML
    private StackPane image8;
    @FXML
    private Label lblName9;
    @FXML
    private Label lblPrice9;
    @FXML
    private StackPane image9;
    @FXML
    private Label lblName10;
    @FXML
    private Label lblPrice10;
    @FXML
    private StackPane image10;
    @FXML
    private Label lblName11;
    @FXML
    private Label lblPrice11;
    @FXML
    private StackPane image11;
    @FXML
    private Label lblName12;
    @FXML
    private Label lblPrice12;
    @FXML
    private StackPane image12;
    @FXML
    private Spinner<Integer> Spinner1;
    @FXML
    private Spinner<Integer> Spinner2;
    @FXML
    private Spinner<Integer> Spinner3;
    @FXML
    private Spinner<Integer> Spinner4;
    @FXML
    private Spinner<Integer> Spinner5;
    @FXML
    private Spinner<Integer> Spinner6;
    @FXML
    private Spinner<Integer> Spinner7;
    @FXML
    private Spinner<Integer> Spinner8;
    @FXML
    private Spinner<Integer> Spinner9;
    @FXML
    private Spinner<Integer> Spinner10;
    @FXML
    private Spinner<Integer> Spinner11;
    @FXML
    private Spinner<Integer> Spinner12;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private TableView<OrderItem> dessertTable;
    @FXML
    private TableColumn<OrderItem, String> columnName;
    @FXML
    private TableColumn<OrderItem, Integer> columnQuantity;
    @FXML
    private TableColumn<OrderItem, Double> columnPrice;

    /**
     * Initializes the controller class.
     */
    private ObservableList<OrderItem> orderItems;
    private double totalAmount = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshDessert();
        assignClickHandlers();
        loadSpinner();
        columnName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("total_amount"));
        orderItems = FXCollections.observableArrayList();
        dessertTable.setItems(orderItems);
    }
    // Método para llenar los espacios vacíos con imágenes y etiquetas por defecto

    private void fillEmptySpaces() {
        if (lblName1.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName1, lblPrice1, image1);
        }
        if (lblName2.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName2, lblPrice2, image2);
        }
        if (lblName3.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName3, lblPrice3, image3);
        }
        if (lblName4.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName4, lblPrice4, image4);
        }
        if (lblName5.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName5, lblPrice5, image5);
        }
        if (lblName6.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName6, lblPrice6, image6);
        }
        if (lblName7.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName7, lblPrice7, image7);
        }
        if (lblName8.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName8, lblPrice8, image8);
        }
        if (lblName9.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName9, lblPrice9, image9);
        }
        if (lblName10.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName10, lblPrice10, image10);
        }
        if (lblName11.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName11, lblPrice11, image11);
        }
        if (lblName12.getText().isEmpty()) {
            assignDefaultLabelAndImage(lblName12, lblPrice12, image12);
        }
    }

    // Método para asignar imágenes y etiquetas por defecto a los espacios vacíos
    private void assignDefaultLabelAndImage(Label nameLabel, Label priceLabel,
            StackPane imagePane) {
        nameLabel.setText("Espacio vacío");
        priceLabel.setText("$0.00");

        // Asigna una imagen por defecto
        ImageView defaultImageView = new ImageView(new Image(new File("path/to/"
                + "default/image.png").toURI().toString()));
        defaultImageView.setFitWidth(110);
        defaultImageView.setFitHeight(110);
        imagePane.getChildren().add(defaultImageView);
    }

    /* Asignar manejadores de clic para abrir el formulario de agregar postres 
    en espacios vacíos
     */
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
    private void openFormEmptySlot() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view"
                    + "/FXMLFormDessert.fxml"));
            Parent root = loader.load();

            FXMLFormDessertController formDessertController = loader.getController();

            /* Pasar el controlador principal para refrescar la lista al 
            agregar postre
             */
            formDessertController.setDessertController(this);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Agregar Postre");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para refrescar la lista de cafés
    public void refreshDessert() {
        ObservableList<Dessert> desserts = getDataDessert();

        // Limpiar todos los espacios antes de actualizarlos
        image1.getChildren().clear();
        lblName1.setText("");
        lblPrice1.setText("");
        image2.getChildren().clear();
        lblName2.setText("");
        lblPrice2.setText("");
        image3.getChildren().clear();
        lblName3.setText("");
        lblPrice3.setText("");
        image4.getChildren().clear();
        lblName4.setText("");
        lblPrice4.setText("");
        image5.getChildren().clear();
        lblName5.setText("");
        lblPrice5.setText("");
        image6.getChildren().clear();
        lblName6.setText("");
        lblPrice6.setText("");
        image7.getChildren().clear();
        lblName7.setText("");
        lblPrice7.setText("");
        image8.getChildren().clear();
        lblName8.setText("");
        lblPrice8.setText("");
        image9.getChildren().clear();
        lblName9.setText("");
        lblPrice9.setText("");
        image10.getChildren().clear();
        lblName10.setText("");
        lblPrice10.setText("");
        image11.getChildren().clear();
        lblName11.setText("");
        lblPrice11.setText("");
        image12.getChildren().clear();
        lblName12.setText("");
        lblPrice12.setText("");

        // Actualizar los espacios ocupados
        if (desserts != null && !desserts.isEmpty()) {
            if (desserts.size() > 0) {
                assignDessertToLabelAndImage(desserts.get(0), lblName1,
                        lblPrice1, image1);
            }
            if (desserts.size() > 1) {
                assignDessertToLabelAndImage(desserts.get(1), lblName2,
                        lblPrice2, image2);
            }
            if (desserts.size() > 2) {
                assignDessertToLabelAndImage(desserts.get(2), lblName3,
                        lblPrice3, image3);
            }
            if (desserts.size() > 3) {
                assignDessertToLabelAndImage(desserts.get(3), lblName4,
                        lblPrice4, image4);
            }
            if (desserts.size() > 4) {
                assignDessertToLabelAndImage(desserts.get(4), lblName5,
                        lblPrice5, image5);
            }
            if (desserts.size() > 5) {
                assignDessertToLabelAndImage(desserts.get(5), lblName6,
                        lblPrice6, image6);
            }
            if (desserts.size() > 6) {
                assignDessertToLabelAndImage(desserts.get(6), lblName7,
                        lblPrice7, image7);
            }
            if (desserts.size() > 7) {
                assignDessertToLabelAndImage(desserts.get(7), lblName8,
                        lblPrice8, image8);
            }
            if (desserts.size() > 8) {
                assignDessertToLabelAndImage(desserts.get(8), lblName9,
                        lblPrice9, image9);
            }
            if (desserts.size() > 9) {
                assignDessertToLabelAndImage(desserts.get(9), lblName10,
                        lblPrice10, image10);
            }
            if (desserts.size() > 10) {
                assignDessertToLabelAndImage(desserts.get(10), lblName11,
                        lblPrice11, image11);
            }
            if (desserts.size() > 11) {
                assignDessertToLabelAndImage(desserts.get(11), lblName12,
                        lblPrice12, image12);
            }
        }

        // Llenar los espacios vacíos con valores predeterminados
        fillEmptySpaces();
    }

    // Método auxiliar para asignar postres a etiquetas e imagenes
    private void assignDessertToLabelAndImage(Dessert dessert, Label nameLabel,
            Label priceLabel, StackPane imagePane) {
        nameLabel.setText(dessert.getName());
        priceLabel.setText("" + dessert.getPrice());
        ImageView imageView = new ImageView(new Image(new File(dessert.
                getImage()).toURI().toString()));
        imageView.setFitWidth(110);
        imageView.setFitHeight(110);
        imagePane.getChildren().add(imageView);
    }

    @FXML
    private void btn_add(ActionEvent event) {
             // To Do
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = OrdersDB.OrdersConn();
        String code_product = "####";
        String observations = "Ninguna";

        for (OrderItem orderItem : orderItems) {
            String sql = "insert into orders (code_product, product_name,"
                    + "unit_price, quantity, observations, total_amount) values "
                    + "(?,?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, code_product);
                ps.setString(2, orderItem.getProduct_name());
                ps.setInt(4, orderItem.getQuantity());
                double price = orderItem.getTotal_amount()
                        / orderItem.getQuantity();
                ps.setDouble(3, price);
                ps.setDouble(6, orderItem.getTotal_amount());
                ps.setString(5, observations);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("" + ex);
            }
        }
    }
    @FXML
    private void btn_cancel(ActionEvent event) {
        dessertTable.getItems().clear();
        
        totalAmount = 0.0;
        lblTotal.setText(String.format("₡ %.2f", totalAmount));
    }

    private void loadSpinner() {
        Spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner7.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner8.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner9.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner10.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner11.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
        Spinner12.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));

    }
     private void addDessertTableOrder(Button clickedButton) {
        String product_name = "";
        int quantity = 0;
        double unit_price = 0.0;
        if (clickedButton == btn1) {
            product_name = lblName1.getText();
            quantity = Spinner1.getValue();
            unit_price = Double.parseDouble(lblPrice1.getText());
        } else if (clickedButton == btn2) {
            product_name = lblName2.getText();
            quantity = Spinner2.getValue();
            unit_price = Double.parseDouble(lblPrice2.getText());
        } else if (clickedButton == btn3) {
            product_name = lblName3.getText();
            quantity = Spinner3.getValue();
            unit_price = Double.parseDouble(lblPrice3.getText());
        } else if (clickedButton == btn4) {
            product_name = lblName4.getText();
            quantity = Spinner4.getValue();
            unit_price = Double.parseDouble(lblPrice4.getText());
        } else if (clickedButton == btn5) {
            product_name = lblName5.getText();
            quantity = Spinner5.getValue();
            unit_price = Double.parseDouble(lblPrice5.getText());
        } else if (clickedButton == btn6) {
            product_name = lblName6.getText();
            quantity = Spinner6.getValue();
            unit_price = Double.parseDouble(lblPrice6.getText());
        } else if (clickedButton == btn7) {
            product_name = lblName7.getText();
            quantity = Spinner7.getValue();
            unit_price = Double.parseDouble(lblPrice7.getText());
        } else if (clickedButton == btn8) {
            product_name = lblName8.getText();
            quantity = Spinner8.getValue();
            unit_price = Double.parseDouble(lblPrice8.getText());
        } else if (clickedButton == btn9) {
            product_name = lblName9.getText();
            quantity = Spinner9.getValue();
            unit_price = Double.parseDouble(lblPrice9.getText());
        } else if (clickedButton == btn10) {
            product_name = lblName10.getText();
            quantity = Spinner10.getValue();
            unit_price = Double.parseDouble(lblPrice10.getText());
        } else if (clickedButton == btn11) {
            product_name = lblName11.getText();
            quantity = Spinner11.getValue();
            unit_price = Double.parseDouble(lblPrice11.getText());
        } else if (clickedButton == btn12) {
            product_name = lblName12.getText();
            quantity = Spinner12.getValue();
            unit_price = Double.parseDouble(lblPrice12.getText());
        }

        double total_amount = unit_price * quantity;
        orderItems.add(new FXMLCoffesController.OrderItem(product_name, quantity, total_amount));

        totalAmount += total_amount;

        lblTotal.setText(String.format("₡ %.2f", totalAmount));

        dessertTable.refresh();

    }

    @FXML
    private void btnAddTable1(ActionEvent event) {
        addDessertTableOrder(btn1);
    }

    @FXML
    private void btnAddTable2(ActionEvent event) {
        addDessertTableOrder(btn2);
    }

    @FXML
    private void btnAddTable3(ActionEvent event) {
        addDessertTableOrder(btn3);
    }

    @FXML
    private void btnAddTable4(ActionEvent event) {
    }

    @FXML
    private void btnAddTable5(ActionEvent event) {
        addDessertTableOrder(btn5);
    }

    @FXML
    private void btnAddTable6(ActionEvent event) {
        addDessertTableOrder(btn6);
    }

    @FXML
    private void btnAddTable7(ActionEvent event) {
        addDessertTableOrder(btn7);
    }

    @FXML
    private void btnAddTable8(ActionEvent event) {
        addDessertTableOrder(btn8);
    }

    @FXML
    private void btnAddTable9(ActionEvent event) {
        addDessertTableOrder(btn9);
    }

    @FXML
    private void btnAddTable10(ActionEvent event) {
        addDessertTableOrder(btn10);
    }

    @FXML
    private void btnAddTable11(ActionEvent event) {
        addDessertTableOrder(btn11);
    }

    @FXML
    private void btnAddTable12(ActionEvent event) {
        addDessertTableOrder(btn12);
    }
}
