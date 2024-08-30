/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loading;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author jorda
 */
public class FXMLLoadScreenController implements Initializable {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator loading;
    @FXML
    private AnchorPane ScreenPane;
    
    private double xOffset = 0;
    private double yOffset = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Task progreso = taskWorker(10);
        progressBar.progressProperty().unbind();
        loading.progressProperty().unbind();
        progressBar.progressProperty().bind(progreso.progressProperty());
        progressBar.getStyleClass().add("progressBar");
        loading.progressProperty().bind(progreso.progressProperty());
        loading.getStyleClass().add("progressIndicator");
        Thread thread = new Thread(progreso);
        thread.start();

        progreso.setOnSucceeded(e -> {
            Stage stage = (Stage) ScreenPane.getScene().getWindow();
            stage.close();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml"));
                Stage stage2 = new Stage();
                Scene scene = new Scene(root);
                Image icon = new Image(getClass().getResourceAsStream("/image/logoTienda.png"));
                stage2.getIcons().add(icon);
                stage2.setTitle("Inicio De Sesión");
                stage2.setScene(scene);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(FXMLLoadScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
    } 
     private Task taskWorker(int segundos) {
        return new Task() {

            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < segundos; i++) {
                    updateProgress(i + 1, segundos);
                    Thread.sleep(400);
                }
                return true;
            };
        };
    }
}
