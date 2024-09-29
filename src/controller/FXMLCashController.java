/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connectionDB.OrdersDB;
import controller.FXMLCoffesController.OrderItem;
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
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLCashController implements Initializable {

    @FXML
    private TextField txt_search;
    @FXML
    private TableColumn<OrderItem, Integer> column_id;
    @FXML
    private TableColumn<OrderItem, String> column_observations;
    @FXML
    private TextField txt_cod;
    @FXML
    private TextField txt_price;
    @FXML
    private TextField txt_quantity;
    @FXML
    private TextField txt_observ;
    @FXML
    private TextField txt_descripcion;
    @FXML
    private TableView<OrderItem> tbw_order;
    @FXML
    private TableColumn<OrderItem, Integer> column_cod;
    @FXML
    private TableColumn<OrderItem, String> column_name;
    @FXML
    private TableColumn<OrderItem, Double> column_price;
    @FXML
    private TableColumn<OrderItem, Integer> column_quantity;
    @FXML
    private TableColumn<OrderItem, Double> column_totalAmount;
    @FXML
    private TextField txt_IVA;
    @FXML
    private TextField txt_totalAmount;
    
    private ObservableList<OrderItem> orders = FXCollections.observableArrayList();

    private Integer index;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private double totalAmount = 0.0;
    private double IVA = 0.13;
    @FXML
    private TextField txt_total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
        int numRand = (int)(Math.random()*10000+1);
        txt_cod.setText(String.valueOf(numRand));
        loadPriceTotal();
    }

    @FXML
    private void search(KeyEvent event) {
    }

    @FXML
    private void btn_add(ActionEvent event) {
    }

    @FXML
    private void btn_pay(ActionEvent event) {
    }

    @FXML
    private void btn_bill(ActionEvent event) {
    }

    @FXML
    private void btn_cancel(ActionEvent event) {
    }

    private void loadData() {
        conn = OrdersDB.OrdersConn();
        column_id.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                Integer> ("id_order"));
        column_cod.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                Integer>("code_product"));
        column_name.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                String>("product_name"));
        column_price.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                Double> ("unit_price"));
        column_quantity.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                Integer>("quantity"));
        column_observations.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                String>("observations"));
        column_totalAmount.setCellValueFactory(new PropertyValueFactory<OrderItem, 
                Double>("total_amount"));
        orders = OrdersDB.getDataOrder();
        tbw_order.setItems(orders);
       
    }
    private void loadPriceTotal (){
        conn = OrdersDB.OrdersConn();
        String sql = "select total_amount from orders";
        try{
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while (rs.next()){
            totalAmount += rs.getDouble("total_amount");
        }
        txt_total.setText(String.format("₡ %.2f", totalAmount));
        double iva = totalAmount * IVA;
        txt_IVA.setText(String.format("₡ %.2f", iva));
        double total = iva + totalAmount;
        txt_totalAmount.setText(String.format("₡ %.2f", total));
        } catch (SQLException ex){
            System.out.println(""+ex);
        }
    }
}
