package controller;

import classes.Coffe;
import static connectionDB.ConnectionCoffesDB.getDataCoffe;
import connectionDB.OrdersDB;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Button;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

public class FXMLCoffesController implements Initializable {

    @FXML
    private Label lblname1;
    @FXML
    private Label lblprice1;
    @FXML
    private StackPane image1;
    @FXML
    private Spinner<Integer> Spinner1;
    @FXML
    private Label lblname2;
    @FXML
    private Label lblprice2;
    @FXML
    private StackPane image2;
    @FXML
    private Spinner<Integer> Spinner2;
    @FXML
    private Label lblname3;
    @FXML
    private Label lblprice3;
    @FXML
    private StackPane image3;
    @FXML
    private Spinner<Integer> Spinner3;
    @FXML
    private Label lblname4;
    @FXML
    private Label lblprice4;
    @FXML
    private StackPane image4;
    @FXML
    private Spinner<Integer> Spinner4;
    @FXML
    private Label lblname5;
    @FXML
    private Label lblprice5;
    @FXML
    private StackPane image5;
    @FXML
    private Spinner<Integer> Spinner5;
    @FXML
    private Label lblname6;
    @FXML
    private Label lblprice6;
    @FXML
    private StackPane image6;
    @FXML
    private Spinner<Integer> Spinner6;
    @FXML
    private Label lblname7;
    @FXML
    private Label lblprice7;
    @FXML
    private StackPane image7;
    @FXML
    private Spinner<Integer> Spinner7;
    @FXML
    private Label lblname8;
    @FXML
    private Label lblprice8;
    @FXML
    private StackPane image8;
    @FXML
    private Spinner<Integer> Spinner8;
    @FXML
    private Label lblname9;
    @FXML
    private Label lblprice9;
    @FXML
    private StackPane image9;
    @FXML
    private Spinner<Integer> Spinner9;
    @FXML
    private Label lblname10;
    @FXML
    private Label lblprice10;
    @FXML
    private StackPane image10;
    @FXML
    private Spinner<Integer> Spinner10;
    @FXML
    private Label lblname11;
    @FXML
    private Label lblprice11;
    @FXML
    private StackPane image11;
    @FXML
    private Spinner<Integer> Spinner11;
    @FXML
    private Label lblname12;
    @FXML
    private Label lblprice12;
    @FXML
    private StackPane image12;
    @FXML
    private Spinner<Integer> Spinner12;
    @FXML
    private TableView<OrderItem> coffeeTable;
    @FXML
    private TableColumn<OrderItem, Double> columnPrice;
    @FXML
    private TableColumn<OrderItem, String> columnName;
    @FXML
    private TableColumn<OrderItem, Integer> columnQuantity;
    @FXML
    private Label lblTotal;
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

    private ObservableList<OrderItem> orderItems;
    private double totalAmount = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Cargar y mostrar los cafés desde la base de datos
        refreshCoffees();

        // Asignar manejadores de clic a las imágenes para abrir el formulario de agregar café
        assignClickHandlers();
        configureSpinner();
        columnName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("total_amount"));
        orderItems = FXCollections.observableArrayList();
        coffeeTable.setItems(orderItems);

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
    private void openFormEmptySlot() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/"
                    + "FXMLForm.fxml"));
            Parent root = loader.load();

            FXMLFormController formController = loader.getController();

            // Pasar el controlador principal para refrescar la lista al agregar café
            formController.setCoffesController(this);

            Stage stage = new Stage();
            stage.setTitle("Agregar Café");
            stage.initStyle(StageStyle.UNDECORATED);
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
    private void assignCoffeToLabelAndImage(Coffe coffee, Label nameLabel,
            Label priceLabel, StackPane imagePane) {
        nameLabel.setText(coffee.getName());
        priceLabel.setText("" + coffee.getPrice());
        ImageView imageView = new ImageView(new Image(new File(coffee.
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

    private void configureSpinner() {
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

    private void addCoffeTableOrder(Button clickedButton) {
        String product_name = "";
        int quantity = 0;
        double unit_price = 0.0;
        if (clickedButton == btn1) {
            product_name = lblname1.getText();
            quantity = Spinner1.getValue();
            unit_price = Double.parseDouble(lblprice1.getText());
        } else if (clickedButton == btn2) {
            product_name = lblname2.getText();
            quantity = Spinner2.getValue();
            unit_price = Double.parseDouble(lblprice2.getText());
        } else if (clickedButton == btn3) {
            product_name = lblname3.getText();
            quantity = Spinner3.getValue();
            unit_price = Double.parseDouble(lblprice3.getText());
        } else if (clickedButton == btn4) {
            product_name = lblname4.getText();
            quantity = Spinner4.getValue();
            unit_price = Double.parseDouble(lblprice4.getText());
        } else if (clickedButton == btn5) {
            product_name = lblname5.getText();
            quantity = Spinner5.getValue();
            unit_price = Double.parseDouble(lblprice5.getText());
        } else if (clickedButton == btn6) {
            product_name = lblname6.getText();
            quantity = Spinner6.getValue();
            unit_price = Double.parseDouble(lblprice6.getText());
        } else if (clickedButton == btn7) {
            product_name = lblname7.getText();
            quantity = Spinner7.getValue();
            unit_price = Double.parseDouble(lblprice7.getText());
        } else if (clickedButton == btn8) {
            product_name = lblname8.getText();
            quantity = Spinner8.getValue();
            unit_price = Double.parseDouble(lblprice8.getText());
        } else if (clickedButton == btn9) {
            product_name = lblname9.getText();
            quantity = Spinner9.getValue();
            unit_price = Double.parseDouble(lblprice9.getText());
        } else if (clickedButton == btn10) {
            product_name = lblname10.getText();
            quantity = Spinner10.getValue();
            unit_price = Double.parseDouble(lblprice10.getText());
        } else if (clickedButton == btn11) {
            product_name = lblname11.getText();
            quantity = Spinner11.getValue();
            unit_price = Double.parseDouble(lblprice11.getText());
        } else if (clickedButton == btn12) {
            product_name = lblname12.getText();
            quantity = Spinner12.getValue();
            unit_price = Double.parseDouble(lblprice12.getText());
        }

        double total_amount = unit_price * quantity;
        orderItems.add(new OrderItem(product_name, quantity, total_amount));

        totalAmount += total_amount;

        lblTotal.setText(String.format("₡ %.2f", totalAmount));

        coffeeTable.refresh();

    }

    @FXML
    private void addCoffeTable1(ActionEvent event) {
        addCoffeTableOrder(btn1);
    }

    @FXML
    private void addCoffeTable2(ActionEvent event) {
        addCoffeTableOrder(btn2);
    }

    @FXML
    private void addCoffeTable3(ActionEvent event) {
        addCoffeTableOrder(btn3);
    }

    @FXML
    private void btnCancel(ActionEvent event) {
        coffeeTable.getItems().clear();
        totalAmount = 0.0;
        lblTotal.setText(String.format("₡ %.2f", totalAmount));
    }

    @FXML
    private void addCoffeTable4(ActionEvent event) {
        addCoffeTableOrder(btn4);
    }

    @FXML
    private void addCoffeTable5(ActionEvent event) {
        addCoffeTableOrder(btn5);
    }

    @FXML
    private void addCoffeTable6(ActionEvent event) {
        addCoffeTableOrder(btn6);
    }

    @FXML
    private void addCoffeTable7(ActionEvent event) {
        addCoffeTableOrder(btn7);
    }

    @FXML
    private void addCoffeTable8(ActionEvent event) {
        addCoffeTableOrder(btn8);
    }

    @FXML
    private void addCoffeTable9(ActionEvent event) {
        addCoffeTableOrder(btn9);
    }

    @FXML
    private void addCoffeTable10(ActionEvent event) {
        addCoffeTableOrder(btn10);
    }

    @FXML
    private void addCoffeTable11(ActionEvent event) {
        addCoffeTableOrder(btn11);
    }

    @FXML
    private void addCoffeTable12(ActionEvent event) {
        addCoffeTableOrder(btn12);
    }

    public static class OrderItem {

        private final SimpleStringProperty product_name;
        private final SimpleIntegerProperty quantity;
        private final SimpleDoubleProperty total_amount;
        private SimpleIntegerProperty id_order;
        private SimpleDoubleProperty unit_price;
        private SimpleStringProperty observations;
        private SimpleStringProperty code_product;

        public OrderItem(String product_name, int quantity,
                double total_amount) {
            this.product_name = new SimpleStringProperty(product_name);
            this.quantity = new SimpleIntegerProperty(quantity);
            this.total_amount = new SimpleDoubleProperty(total_amount);
        }

        public OrderItem(int id_order, String code_product, String product_name, 
                int quantity, String observations, double unit_price, 
                double total_amount) {
            this.id_order = new SimpleIntegerProperty(id_order);
            this.code_product = new SimpleStringProperty(code_product);
            this.product_name = new SimpleStringProperty(product_name);
            this.quantity = new SimpleIntegerProperty(quantity);
            this.observations = new SimpleStringProperty(observations);
            this.unit_price = new SimpleDoubleProperty(unit_price);
            this.total_amount = new SimpleDoubleProperty(total_amount);
        
          
           
            
        }

        public String getProduct_name() {
            return product_name.get();
        }

        public int getQuantity() {
            return quantity.get();
        }

        public double getTotal_amount() {
            return total_amount.get();
        }

        public int getId_order() {
            return id_order.get();
        }

        public double getUnit_price() {
            return unit_price.get();
        }
        public String getCode_product(){
            return code_product.get();
        }
        public String getObservations(){
            return observations.get();
        }
    }
}
