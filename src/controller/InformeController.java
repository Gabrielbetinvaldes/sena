package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.ToggleGroup;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Timer;




import org.apache.log4j.BasicConfigurator;




public class InformeController {

    @FXML
    private DatePicker dTFechaIni;

    @FXML
    private DatePicker dTFechaFin;

    
    @FXML
    private ProgressBar brProgreso;

    @FXML
    private Button tfExcel;

         @FXML
    private Button btHome40;

    @FXML
    private Button buscarReporte;


    @FXML
    private RadioButton rBarrios;

    @FXML
    private RadioButton rCotizacion;

    @FXML
    private RadioButton rEmpleadoI;

    @FXML
    private RadioButton rEmpleados;

    @FXML
    private RadioButton rEmpleadosR;

    @FXML
    private RadioButton rFactura;

    @FXML
    private RadioButton rMotivos;

    @FXML
    private RadioButton rNomina;

    @FXML
    private ToggleGroup tg;




    @FXML
    void generarReporte(ActionEvent event) {
    
      String fechaIngreso= "'" + dTFechaIni.getValue() + "'";
      String fechaRetiro= "'" + dTFechaFin.getValue() + "'";
      
        if( rCotizacion.isSelected()){

          reportes cotizacion = new reportes ();
            
          cotizacion.exportarCotizacion(fechaIngreso,fechaRetiro);
  


        }
     
   

      
      
    }
    
 
 


      
      



    @FXML
    void homeUno(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuPrincipal.fxml"));

        Parent root = fxmlLoader.load();
        
        MenuController controlador = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage secondaryStage = new Stage();            

        secondaryStage.setTitle("MENU DE OPCIONES.");
        secondaryStage.setScene(scene);
        secondaryStage.show();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();



  }
}