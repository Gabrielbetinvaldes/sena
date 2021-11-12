package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
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




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;






import org.apache.log4j.BasicConfigurator;





public class InformeController {

    @FXML
    private DatePicker dTFechaIni;

    @FXML
    private DatePicker dTFechaFin;

    @FXML
    private CheckBox ChecCotizacion;

    @FXML
    private CheckBox ChecFactura;

    @FXML
    private CheckBox ChecCliente;

    @FXML
    private CheckBox ChecNomina;

    @FXML
    private CheckBox ChecBarrios;

    @FXML
    private CheckBox ChecMotivos;

    @FXML
    private ProgressBar brProgreso;

    @FXML
    private Button tfExcel;

    @FXML
    private Button btBuscar20;

    @FXML
    private CheckBox ChecEmpleado;

    @FXML
    private TextField tfConsulta;

    @FXML
    private Button btHome40;

    @FXML
    private Button buscarReporte;



   



    @FXML
    void generarReporte(ActionEvent event) {
    
  

      reportes cotizacion = new reportes ();
         
      cotizacion.exportarCotizacion();

          
     
      
     
      
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