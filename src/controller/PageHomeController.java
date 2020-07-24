package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author
 */
public class PageHomeController implements Initializable {

    @FXML
    private AnchorPane pageHome;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showImage();
    }

    @FXML
    private void getHome(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/pageWatermark.fxml"));

        pageHome.getChildren().setAll(panes);
    }

    public void showImage() {

        try {

            Image image = new Image("/img/del.png");

            imageView.setImage(image);

            imageView.setCache(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
