/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicagodata;

import java.net.URL;
import javafx.scene.chart.BarChart;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.google.gson.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.chart.XYChart;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;



/**
 *
 * @author Ashwin
 */
public class FXMLDocumentController implements Initializable {
    private static DataSet data;
    @FXML
    private BarChart chart;
    @FXML
    private Slider max;
    @FXML
    private Slider min;
    @FXML
    private Label minimumLabel;
    @FXML
    private Label maximumLabel;
    @FXML
    private Label Menu;
    @FXML
    private Label yAxis;
    @FXML
    private Label xAxis;
    @FXML
    private TextField textfield;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yAxis.setRotate(-90);
        
        //String swoosh = getClass().getResource("audio/swoosh.mp3");
        max.setValue(20.0);
        //AudioClip startUpSound = new AudioClip(swoosh);
        String s = "https://data.cityofchicago.org/api/views/kn9c-c2s2/rows.json?accessType=DOWNLOAD";
        URL myUrl = null;
        try {
            myUrl = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
        
        //read from the url
        Scanner scan = null;
        try {
            scan = new Scanner(myUrl.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();

        Gson gson = new Gson();
        data = gson.fromJson(str, DataSet.class);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
        
        System.out.println(data.toString());
        XYChart.Series<String, Number> failedSeries = new XYChart.Series();
        String[] capitas = data.getCapita();
        String[] NBs = data.getNBs();
        
        for(int i=0; i<NBs.length; i++){
            
            for(String NBnum : NBs){
                if(i >= min.getValue() && i <= max.getValue()){
                    failedSeries.getData().add(new XYChart.Data(NBs[i], Integer.parseInt(capitas[i])));
            
                }   
            }
        }
        
        
        chart.getData().add(failedSeries);
        
        
    }
    
    @FXML
    public void updateGraph(int minimum, int maximum){
        
    }
    
    @FXML
    private void handleReset(ActionEvent event){
        //updateData();
    }
    
    
    
    @FXML
    public void onMouseReleased(){
        
        System.out.println(data.toString());
        XYChart.Series<String, Number> failedSeries = new XYChart.Series();
        String[] capitas = data.getCapita();
        String[] NBs = data.getNBs();
        for(int i=0; i<NBs.length; i++){
            if(i >= min.getValue() && i <= max.getValue()){
                failedSeries.getData().add(new XYChart.Data(NBs[i], Integer.parseInt(capitas[i])));
            }
            
            
        }
        chart.getData().setAll(failedSeries);
    }
    
    public void onSearch(){   
        XYChart.Series<String, Number> failedSeries = new XYChart.Series();
        String text = textfield.getText();
        String[] capitas = data.getCapita();
        String[] NBs = data.getNBs();
        System.out.println(NBs[0].substring(0,text.length()) + text);
        for(int i=0; i<NBs.length; i++){
            if(text.length() > NBs[i].length()){
                
            }
            else if(NBs[i].substring(0,text.length()).equals(text) || NBs[i].substring(0,text.length()-1).equals(text)){
                failedSeries.getData().add(new XYChart.Data(NBs[i], Integer.parseInt(capitas[i])));
                
            }else if(text.equals("")){
                failedSeries.getData().add(new XYChart.Data(NBs[i], Integer.parseInt(capitas[i])));
            }
            
            
        }
        chart.getData().setAll(failedSeries);
    
    
    }
    
    
    /*
    Uncomment this to make it run!!!!
    @FXML
    Alert alert = new Alert(AlertType.INFORMATION);
    @FXML
    public void handleAbout(ActionEvent event){
        alert.setTitle("About");
        alert.setHeaderText("About this program!");
        alert.setContentText("Completed by Ashwin Aggarwal on May 3rd, 2016");
        alert.showAndWait();
    }
    */
    @FXML
    public void handleCloseButton(ActionEvent event){
        Platform.exit();
    }
    
}
