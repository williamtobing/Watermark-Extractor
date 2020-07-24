package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import app.*;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author
 */
public class PageWatermarkController implements Initializable {

    @FXML
    private AnchorPane pageWatermark;
    @FXML
    private Button btnAttack;
    @FXML
    private Button btnUpload;
    @FXML
    private Button btnBack;
    @FXML
    private TextArea textGraf;
    @FXML
    private TextArea textGrafAttacked;
    @FXML
    private TextField textWatermark;
    @FXML
    private TextField textWatermarkAttacked;
    @FXML
    private Label labelAngka;
    @FXML
    private Label labelWatermark;
    @FXML
    private Label labelNamafile;  
    @FXML
    private Label labelJudul;  
    
    @FXML
    private Label labelHasil;
    
    List<String> listEdge;
    
    File txtfile;
  
    /**
     * Initializes the controller class. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Todo
    }    

    @FXML
    private void upload(ActionEvent event) throws IOException 
    {
        cleanLabelandField();
        
        try{
            txtfile  = FileManager.getUploadedFile();
         
            setFileName(labelNamafile, txtfile);
            
            extractWatermark(txtfile);
        }catch(Exception e){
            labelNamafile.setText("An error has occurred in the .txt file!");
        }        
    }
    @FXML
    private void attackWatermark(ActionEvent event) throws IOException 
    {
        Attack.randomizeTheList(listEdge);
     
        setTextOnTextFieldWatermark(textWatermarkAttacked); 
        
        setTextOnTextAreaGraphBuilder(textGrafAttacked);
                
        setLabelHasil();
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
         
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/pageHome.fxml"));
        
        pageWatermark.getChildren().setAll(panes);
        
    }
    
    private void cleanLabelandField(){
        labelHasil.setText("");
        textWatermark.setText("");
        textWatermarkAttacked.setText("");
        textGraf.setText("");
        textGrafAttacked.setText("");
    }
    private void setLabelHasil(){
        if(compareString()){
            labelHasil.setText("Same");
        }else{
            labelHasil.setText("Not the same");
        }     
    } 
    
    private boolean compareString(){
        if( textWatermark.getText().equals(textWatermarkAttacked.getText())){
            return true;
        }
        return false;
    }

    private void extractWatermark(File file) throws IOException
    {       
        FileManager fileManager = new FileManager();
        
        listEdge =new ArrayList<>();

        listEdge = fileManager.readFileAndGetTheList(txtfile, listEdge);
                
        setTextOnTextFieldWatermark(textWatermark);
                
        setTextOnTextAreaGraphBuilder(textGraf); 
    }
  
    private void setTextOnTextFieldWatermark(TextField field)
    {   
        String text = Hasil.getWatermark(listEdge); 
        
        field.setText(text);
       
        field.setEditable(false);
    }
    private void setTextOnTextAreaGraphBuilder(TextArea area)
    {
        String grafBuilder = Hasil.getGraphBuilder(listEdge);

        area.setText(grafBuilder);
        
        area.setEditable(false);
    }
  
    private void setFileName(Label label, File file)
    {
        FileManager.setFileName(file);  
        
        label.setText(FileManager.getFileName());
    }   
}
