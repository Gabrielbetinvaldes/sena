package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.itextpdf.text.DocumentException;
import jfxtras.scene.control.LocalTimePicker;





import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Empleado;
import model.cliente;
import model.cotizacion;
import model.factura;
import model.pdfCliente;
import model.pdfCotizacion;
import model.pdfFactura;
import model.pdfNomina;

public class ContabilidadRegistrosController implements Initializable {
    @FXML
    private TextField TxNombresCliente1;

    @FXML
    private TextField TxEmail;

    @FXML
    private TextField txWhatSapp;

    @FXML
    private TextField txTelCliente1;

    
    @FXML
    private TextField TxNumIdentidad1;

    @FXML
    private TextField txTelCliente2;

    @FXML
    private TextField TxDocIde1;

    @FXML
    private Button ButtonLimpiarCliente;

    @FXML
    private Button ButtonGuardar4;

    @FXML
    private Button txBuscar4;

    @FXML
    private Button txBuscar6;

    @FXML
    private Button ButtonModificar3;



    @FXML
    private Button buttonBusCliente;

    @FXML
    private Button ButthonLimpiarCLiente2;
   
    @FXML
    private Button ButtonGuardar5;

    @FXML
    private Button bthome5;

    @FXML
    private DatePicker tfFechaCotizacion;

    @FXML
    private TextField tfCliente2;

    @FXML
    private TextField tfCotizacion1;

    @FXML
    private Button btBuscar9;

    @FXML
    private Button btModificar9;

    @FXML
    private Button btRetirar9;

    @FXML
    private Button btImprimir9;

    @FXML
    private TextField tfNombreCLiente3;

    @FXML
    private TextField tfEmail2;

    @FXML
    private TextField tfWtSapp2;

    @FXML
    private TextField tfTelefonoCliente1;

    @FXML
    private TextField tfTelefonoCliente2;

    @FXML
    private TextField tfBarrio1;

    @FXML
    private TextField tfCiudad2;

    @FXML
    private TextField tfDireccionCliente1;

    @FXML
    private TextField tfHomenajeado1;

    @FXML
    private TextField tfQuien1;

     

    @FXML
    private TextField tfCostoServicio1;

    @FXML
    private TextField tfPreObsequio1;

    @FXML
    private TextField tfPrecioSonido1;



    @FXML
    private Button btGuardar51;

    @FXML
    private Button bthome51;

    @FXML
    private DatePicker tfFechaCotizacion2;

    @FXML
    private TextField tfIdFactura;

    @FXML
    private TextField tfCotizacion11;

    @FXML
    private Button btBuscar91;

    @FXML
    private Button btModificar91;

    @FXML
    private Button btRetirar91;

    @FXML
    private Button btImprimir91;

    @FXML
    private TextField tfNombreCLiente31;

    @FXML
    private TextField tfEmail21;

    @FXML
    private TextField tfWtSapp21;

    @FXML
    private TextField tfTelefonoCliente11;

    @FXML
    private TextField tfTelefonoCliente21;

    @FXML
    private TextField tfBarrio11;

    @FXML
    private TextField tfCiudad21;

    @FXML
    private TextField tfDireccionCliente11;

    @FXML
    private ChoiceBox<String> chMotivos11;

    @FXML
    private TextField tfHomenajeado11;

    @FXML
    private TextField tfQuien11;

    @FXML
    private LocalTimePicker horaSerenata2;

    @FXML
    private TextField transporteFactura;

    @FXML
    private TextField totalFactura;
    
    @FXML
    private Button ButtonBorraCtz;

    @FXML
    private Button buttonBuscarFactura;

    @FXML
    private Button buttonBorrarFactura;


    @FXML
    private ChoiceBox<String> chParentezco11;

    @FXML
    private ChoiceBox<String> chObsequio11;

    @FXML
    private TextField tfCostoServicio11;

    @FXML
    private TextField tfPreObsequio11;

    @FXML
    private TextField tfPrecioSonido11;

   
    @FXML
    private Spinner<Integer> spCantidadMusicos11;


    @FXML
    private Spinner<Integer> spCantidadMusicos1;

    @FXML
    private ChoiceBox<String> chMotivos1;


    @FXML
    private ChoiceBox<String> ChMedio;  
    
    @FXML
    private ChoiceBox<String> chParentezco1;

    @FXML
    private ChoiceBox<String> chObsequio1;

    @FXML
    private ToggleButton tgButtonFactura;

    @FXML
    private ToggleButton tgButtonCotizacion;

    @FXML
    private Button ButtonImprimir3;

    @FXML
    private Button ButtonRetirar3;

    @FXML
    private TextField tfTransporte;

    
    @FXML
    private TextField totalCotizacion;

    @FXML
    private Button buttonCalculaCotiz;

    @FXML
    private LocalTimePicker horaSerenata;

    @FXML
    private Button ButLimpiarCotizacionCalculo;

    @FXML
    private Button buttonLimpiarCotizacionG;

    @FXML
    private TextField idClienteFactura;





    @FXML
    void imprimirFactura(ActionEvent event) throws FileNotFoundException, DocumentException {

        String fechaCotizacion= "" + tfFechaCotizacion2.getValue();
        String idCliente = idClienteFactura.getText();
        String nombreCliente =  tfNombreCLiente31.getText();
        String emailCliente  =  tfEmail21.getText();
        String wtCliente  =  tfWtSapp21.getText();
        String telDosClie  = tfTelefonoCliente21.getText();
        String telUnoClie = tfTelefonoCliente11.getText();
        String barrio = tfBarrio11.getText();
        String ciudad = tfCiudad21.getText();
        String direccion= tfDireccionCliente11.getText();
        String motivo =  chMotivos11.getValue();
        String homenajeado = tfHomenajeado11.getText();
        String parentezco = chParentezco11.getValue();
        String quien =  tfQuien11.getText();
        String obsequio = chObsequio11.getValue();
        String precioVenta =  tfCostoServicio11.getText();
        String sonido =  tfPrecioSonido11.getText();
        String preObsequio=  tfPreObsequio11.getText();
        String cantMusico = "" + spCantidadMusicos11.getValue();
        String estado =  tgButtonCotizacion.getText();
        String transporte = transporteFactura.getText();
        String total =  totalFactura.getText();
        String idCotizacion = tfCotizacion11.getText();
        String hora = "" + horaSerenata2.getLocalTime() + "";
        String idfacturacion = tfIdFactura.getText();

   

        pdfFactura certificado = new pdfFactura (fechaCotizacion,idCliente,nombreCliente,emailCliente,
        wtCliente,telDosClie,telUnoClie,barrio,ciudad,direccion,motivo,homenajeado,parentezco,quien, 
        obsequio,precioVenta,sonido,preObsequio,cantMusico,estado,transporte,total,idCotizacion,hora,idfacturacion);

        certificado.imprimirCertificado();



    }





    @FXML
    void crearFactura(ActionEvent event) {



        String fechaFactura= "'" + tfFechaCotizacion2.getValue() + "'";
        String idCotizacion = "'" + tfCotizacion11.getText() + "'";           
        String estado =  "'" + tgButtonFactura.getText() + "'";
        
           
          
          

           factura ingFactura = new factura (fechaFactura,idCotizacion,estado);
            
           ingFactura.cargaFactura(); 

            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CREACIÓN DE FACTURA");
            dialogoAlerta.setHeaderText("Desea crear una nueva factura?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("CREACIÓN DE FACTURA");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();


            tfFechaCotizacion2.setValue(null);        
            tfNombreCLiente31.clear();
            tfEmail21.clear();
            tfWtSapp21.clear();
            tfTelefonoCliente21.clear();
            tfTelefonoCliente11.clear();
            tfBarrio11.clear();
            tfCiudad21.clear();
            tfDireccionCliente11.clear();
            chMotivos11.getSelectionModel().clearSelection(); 
            tfHomenajeado11.clear();
            chParentezco11.getSelectionModel().clearSelection(); 
            tfQuien11.clear();
            chObsequio11.getSelectionModel().clearSelection(); 
            tfCostoServicio11.setText("0");
            tfPrecioSonido11.setText("0");
            tfPreObsequio11.setText("0");
            SpinnerValueFactory<Integer> valuesMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
            valuesMusicos1.setValue(0);
            spCantidadMusicos11.setValueFactory(valuesMusicos1);
            totalFactura.clear();
            tfCotizacion11.clear();
            transporteFactura.setText("0");
            tfIdFactura.setText(factura.idFactura());
            idClienteFactura.clear();
           

    }


    @FXML
    void imprimirCotizacion(ActionEvent event) throws FileNotFoundException, DocumentException {

        
        String fechaCotizacion= "" + tfFechaCotizacion.getValue();
        String idCliente = tfCliente2.getText();
        String nombreCliente =  tfNombreCLiente3.getText();
        String emailCliente  =  tfEmail2.getText();
        String wtCliente  =  tfWtSapp2.getText();
        String telDosClie  = tfTelefonoCliente2.getText();
        String telUnoClie = tfTelefonoCliente1.getText();
        String barrio = tfBarrio1.getText();
        String ciudad = tfCiudad2.getText();
        String direccion= tfDireccionCliente1.getText();
        String motivo =  chMotivos1.getValue();
        String homenajeado = tfHomenajeado1.getText();
        String parentezco = chParentezco1.getValue();
        String quien =  tfQuien1.getText();
        String obsequio = chObsequio1.getValue();
        String precioVenta =  tfCostoServicio1.getText();
        String sonido =  tfPrecioSonido1.getText();
        String preObsequio=  tfPreObsequio1.getText();
        String cantMusico = "" + spCantidadMusicos1.getValue();
        String estado =  tgButtonCotizacion.getText();
        String transporte = tfTransporte.getText();
        String total =  totalCotizacion.getText();
        String idCotizacion = tfCotizacion1.getText();
        String hora = "" + horaSerenata.getLocalTime() + "";

   

        pdfCotizacion certificado = new pdfCotizacion (fechaCotizacion,idCliente,nombreCliente,emailCliente,
        wtCliente,telDosClie,telUnoClie,barrio,ciudad,direccion,motivo,homenajeado,parentezco,quien, 
        obsequio,precioVenta,sonido,preObsequio,cantMusico,estado,transporte,total,idCotizacion,hora);

        certificado.imprimirCertificado();

    }

    @FXML
    void retirarCotizacion(ActionEvent event) {

        Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("ELIMINAR COTIZACION");
        dialogoAlerta.setHeaderText("Desea eliminar un registro de la base de datos?");           
        dialogoAlerta.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta.showAndWait();

   

        cotizacion.eliminarCotizacion(tfCotizacion1.getText());

        Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
        dialogoAlerta1.setTitle("ELIMINAR COTIZACION");
        dialogoAlerta1.setHeaderText("Operacion exitosa");           
        dialogoAlerta1.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta1.showAndWait();


        tfFechaCotizacion.setValue(null);
        tfCliente2.clear();
        tfNombreCLiente3.clear();
        tfEmail2.clear();
        tfWtSapp2.clear();
        tfTelefonoCliente2.clear();
        tfTelefonoCliente1.clear();
        tfBarrio1.clear();
        tfCiudad2.clear();
        tfDireccionCliente1.clear();
        chMotivos1.getSelectionModel().clearSelection(); 
        tfHomenajeado1.clear();
        chParentezco1.getSelectionModel().clearSelection(); 
        tfQuien1.clear();
        chObsequio1.getSelectionModel().clearSelection(); 
        tfCostoServicio1.setText("0");
        tfPrecioSonido1.setText("0");
        tfPreObsequio1.setText("0");
        SpinnerValueFactory<Integer> spCantidadMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
        spCantidadMusicos1.setValue(0);
        totalCotizacion.clear();
        tfTransporte.setText("0");
        tfCotizacion1.setText(cotizacion.idCotizacion()); 

    }


    @FXML
    void retirarFactura(ActionEvent event) {

        Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("ELIMINAR FACTURA");
        dialogoAlerta.setHeaderText("Desea eliminar un registro de la base de datos?");           
        dialogoAlerta.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta.showAndWait();

   

        factura.eliminarFactura(tfIdFactura.getText());

        Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
        dialogoAlerta1.setTitle("ELIMINAR FACTURA");
        dialogoAlerta1.setHeaderText("Operacion exitosa");           
        dialogoAlerta1.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta1.showAndWait();




        tfFechaCotizacion2.setValue(null);        
        tfNombreCLiente31.clear();
        tfEmail21.clear();
        tfWtSapp21.clear();
        tfTelefonoCliente21.clear();
        tfTelefonoCliente11.clear();
        tfBarrio11.clear();
        tfCiudad21.clear();
        tfDireccionCliente11.clear();
        chMotivos11.getSelectionModel().clearSelection(); 
        tfHomenajeado11.clear();
        chParentezco11.getSelectionModel().clearSelection(); 
        tfQuien11.clear();
        chObsequio11.getSelectionModel().clearSelection(); 
        tfCostoServicio11.setText("0");
        tfPrecioSonido11.setText("0");
        tfPreObsequio11.setText("0");
        SpinnerValueFactory<Integer> valuesMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
        valuesMusicos1.setValue(0);
        spCantidadMusicos11.setValueFactory(valuesMusicos1);
        totalFactura.clear();
        tfCotizacion11.clear();
        transporteFactura.setText("0");
        tfIdFactura.setText(factura.idFactura());
        idClienteFactura.clear();

    }

    @FXML
    void modificarFactura(ActionEvent event) {


       
        String fechaFactura= "'" + tfFechaCotizacion2.getValue() + "'";
        String idCotizacion = "'" + tfCotizacion11.getText() + "'";           
        String estado =  "'" + tgButtonFactura.getText() + "'";
        
        factura ingFactura = new factura (fechaFactura,idCotizacion,estado);
            
        ingFactura.editarFactura("'" + tfIdFactura.getText()+ "'"); 
           

              
        
   
          
           Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("MODIFICAR FACTURA");
            dialogoAlerta.setHeaderText("Desea modificar la factura?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("MODIFICAR FACTURA");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();


    }

    @FXML
    void modificarCotizacion(ActionEvent event) {


        String fechaCotizacion= "'" + tfFechaCotizacion.getValue() + "'";
           String idCliente = "'" + tfCliente2.getText() + "'";
           String nombreCliente = "'" + tfNombreCLiente3.getText() + "'";
           String emailCliente  = "'" + tfEmail2.getText() + "'";
           String wtCliente  = "'" + tfWtSapp2.getText() + "'";
           String telDosClie  = "'" + tfTelefonoCliente2.getText() + "'";
           String telUnoClie = "'" + tfTelefonoCliente1.getText() + "'";
           String barrio = "'" + tfBarrio1.getText() + "'";
           String ciudad = "'" + tfCiudad2.getText() + "'";
           String direccion= "'" + tfDireccionCliente1.getText() + "'";
           String motivo = "'" + chMotivos1.getValue() + "'";
           String homenajeado = "'" + tfHomenajeado1.getText() + "'";
           String parentezco = "'" + chParentezco1.getValue() + "'";
           String quien = "'" + tfQuien1.getText() + "'";
           String obsequio = "'" + chObsequio1.getValue() + "'";
           String precioVenta = "'" + tfCostoServicio1.getText() + "'";
           String sonido = "'" + tfPrecioSonido1.getText() + "'";
           String preObsequio= "'" + tfPreObsequio1.getText() + "'";
           String cantMusico = "'" + spCantidadMusicos1.getValue() + "'";
           String estado =  "'" + tgButtonCotizacion.getText() + "'";
           String transporte = "'" + tfTransporte.getText() + "'";
           String total =  "'" + totalCotizacion.getText() + "'";
           String hora = "'" + horaSerenata.getLocalTime() + "'";
           


           cotizacion ingCotizacion = new cotizacion (fechaCotizacion,idCliente,nombreCliente,emailCliente,
           wtCliente,telDosClie,telUnoClie,barrio,ciudad,direccion,motivo,homenajeado,parentezco,quien, 
           obsequio,precioVenta,sonido,preObsequio,cantMusico,estado,transporte,total,hora);
            
           ingCotizacion.editarCotizacion( "'" + tfCotizacion1.getText()+ "'"); 
   
          
           Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("MODIFICAR COTIZACION");
            dialogoAlerta.setHeaderText("Desea modificar la cotizacion?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("MODIFICAR COTIZACION");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();


    }


    @FXML
    void limpiarCotizacionGeneral(ActionEvent event) {

        
        tfFechaCotizacion.setValue(null);
        tfCliente2.clear();
        tfNombreCLiente3.clear();
        tfEmail2.clear();
        tfWtSapp2.clear();
        tfTelefonoCliente2.clear();
        tfTelefonoCliente1.clear();
        tfBarrio1.clear();
        tfCiudad2.clear();
        tfDireccionCliente1.clear();
        chMotivos1.getSelectionModel().clearSelection(); 
        tfHomenajeado1.clear();
        chParentezco1.getSelectionModel().clearSelection(); 
        tfQuien1.clear();
        chObsequio1.getSelectionModel().clearSelection(); 
        tfCostoServicio1.setText("0");
        tfPrecioSonido1.setText("0");
        tfPreObsequio1.setText("0");
        SpinnerValueFactory<Integer> valuesMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
        valuesMusicos1.setValue(0);
        spCantidadMusicos1.setValueFactory(valuesMusicos1);
        totalCotizacion.clear();
        tfCotizacion1.clear();
        tfTransporte.setText("0");
        

    }


    @FXML
    void limpiarCotizacionGeneralFactura(ActionEvent event) {

        
        tfFechaCotizacion2.setValue(null);        
        tfNombreCLiente31.clear();
        tfEmail21.clear();
        tfWtSapp21.clear();
        tfTelefonoCliente21.clear();
        tfTelefonoCliente11.clear();
        tfBarrio11.clear();
        tfCiudad21.clear();
        tfDireccionCliente11.clear();
        chMotivos11.getSelectionModel().clearSelection(); 
        tfHomenajeado11.clear();
        chParentezco11.getSelectionModel().clearSelection(); 
        tfQuien11.clear();
        chObsequio11.getSelectionModel().clearSelection(); 
        tfCostoServicio11.setText("0");
        tfPrecioSonido11.setText("0");
        tfPreObsequio11.setText("0");
        SpinnerValueFactory<Integer> valuesMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
        valuesMusicos1.setValue(0);
        spCantidadMusicos11.setValueFactory(valuesMusicos1);
        totalFactura.clear();
        tfCotizacion11.clear();
        transporteFactura.setText("0");
        idClienteFactura.clear();

              

    }

    @FXML
    void limpiarFactura(ActionEvent event) {

        tfIdFactura.clear();
        tfCotizacion11.clear();
        tfFechaCotizacion2.setValue(null);        
        tfNombreCLiente31.clear();
        tfEmail21.clear();
        tfWtSapp21.clear();
        tfTelefonoCliente21.clear();
        tfTelefonoCliente11.clear();
        tfBarrio11.clear();
        tfCiudad21.clear();
        tfDireccionCliente11.clear();
        chMotivos11.getSelectionModel().clearSelection(); 
        tfHomenajeado11.clear();
        chParentezco11.getSelectionModel().clearSelection(); 
        tfQuien11.clear();
        chObsequio11.getSelectionModel().clearSelection(); 
        tfCostoServicio11.setText("0");
        tfPrecioSonido11.setText("0");
        tfPreObsequio11.setText("0");
        SpinnerValueFactory<Integer> valuesMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
        valuesMusicos1.setValue(0);
        spCantidadMusicos11.setValueFactory(valuesMusicos1);
        totalFactura.clear();
        tfCotizacion11.clear();
        transporteFactura.setText("0");
        idClienteFactura.clear();

              

    }

    @FXML
    void buscarCotizacionGeneralFactura(ActionEvent event) {


        String datos;
        String[] vector;
         
        if (tfCotizacion11.getLength() > 0 ){

            datos = cotizacion.buscarCotizacionId(tfCotizacion11.getText());
            vector = datos.split(",");
            System.out.println(datos);

            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DE LA COTIZACION");
                dialogoAlerta.setHeaderText("LA COTIZACION  #" + tfCotizacion11.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el numero correcto de la cotizacion");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{     
                
                               
               idClienteFactura.setText(vector[0]);
               tfNombreCLiente31.setText(vector[1]);
               tfEmail21.setText(vector[3]);
               tfTelefonoCliente11.setText(vector[4]);
               tfTelefonoCliente21.setText(vector[5]);           
               tfWtSapp21.setText(vector[6]);
               tfBarrio11.setText(vector[8]);
               tfCiudad21.setText(vector[9]);
               tfDireccionCliente11.setText(vector[10]);
               chMotivos11.setValue(vector[11]);
               tfHomenajeado11.setText(vector[12]);
               chParentezco11.setValue(vector[13]);
               tfQuien11.setText(vector[14]);
               chObsequio11.setValue(vector[15]);
               tfCostoServicio11.setText(vector[16]);
               tfPrecioSonido11.setText(vector[17]);
               tfPreObsequio11.setText(vector[18]);
               transporteFactura.setText(vector[19]);
               SpinnerValueFactory<Integer> ValuesspCantidadMusicos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
               ValuesspCantidadMusicos.setValue(Integer.parseInt(vector[20]));
               spCantidadMusicos11.setValueFactory(ValuesspCantidadMusicos);
               
               tfFechaCotizacion2.setValue(Empleado.LocalDateStringConverter(vector[22])); 
               totalFactura.setText(vector[23]);
               horaSerenata2.setLocalTime((Empleado.LocalTimeStringConverter(vector[24])));
                
                              
               

            }                
         }   

    }

    
    @FXML
    void buscarFactura(ActionEvent event) {


        String datos;
        String[] vector;
        String datos2;
        String[] vector2;
         
        if (tfIdFactura.getLength() > 0 ){

     

            datos2 = factura.buscarFacturaId(tfIdFactura.getText());
            vector2 = datos2.split(",");

            datos = cotizacion.buscarCotizacionId(vector2[0]);
            vector = datos.split(",");
            System.out.println(datos);

            

            if (datos2.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DE LA FACTURA");
                dialogoAlerta.setHeaderText("LA COTIZACION  #" + tfIdFactura.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el numero correcto de la factura");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{     
                
               idClienteFactura.setText(vector[0]);                
               tfCotizacion11.setText(vector2[0]);
               tfNombreCLiente31.setText(vector[1]);
               tfEmail21.setText(vector[3]);
               tfTelefonoCliente11.setText(vector[4]);
               tfTelefonoCliente21.setText(vector[5]);           
               tfWtSapp21.setText(vector[6]);
               tfBarrio11.setText(vector[8]);
               tfCiudad21.setText(vector[9]);
               tfDireccionCliente11.setText(vector[10]);
               chMotivos11.setValue(vector[11]);
               tfHomenajeado11.setText(vector[12]);
               chParentezco11.setValue(vector[13]);
               tfQuien11.setText(vector[14]);
               chObsequio11.setValue(vector[15]);
               tfCostoServicio11.setText(vector[16]);
               tfPrecioSonido11.setText(vector[17]);
               tfPreObsequio11.setText(vector[18]);
               transporteFactura.setText(vector[19]);
               SpinnerValueFactory<Integer> ValuesspCantidadMusicos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
               ValuesspCantidadMusicos.setValue(Integer.parseInt(vector[20]));
               spCantidadMusicos11.setValueFactory(ValuesspCantidadMusicos);
               tgButtonFactura.setText(vector2[2]);
               tfFechaCotizacion2.setValue(Empleado.LocalDateStringConverter(vector2[1])); 
               totalFactura.setText(vector[23]);

               if(tgButtonFactura.getText().equals("Activa")){               
                tgButtonFactura.setStyle("-fx-background-color: #008000;");                       
                                    
                }else if(tgButtonFactura.getText().equals("Anulada")){
                    tgButtonFactura.setStyle("-fx-background-color: #ff0000;");                   
                }

                horaSerenata2.setLocalTime((Empleado.LocalTimeStringConverter(vector[24])));


                
                

               
               

            }                
         }   

    }

    @FXML
    void buscarCotizacionGeneral(ActionEvent event) {


        String datos;
        String[] vector;
         
        if (tfCotizacion1.getLength() > 0 ){

            datos = cotizacion.buscarCotizacionId(tfCotizacion1.getText());
            vector = datos.split(",");
            System.out.println(datos);

            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DE LA COTIZACION");
                dialogoAlerta.setHeaderText("LA COTIZACION  #" + tfCotizacion1.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el numero correcto de la cotizacion");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{     
                
                               
               tfCliente2.setText(vector[0]);
               tfNombreCLiente3.setText(vector[1]);
               tfEmail2.setText(vector[3]);
               tfTelefonoCliente1.setText(vector[4]);
               tfTelefonoCliente2.setText(vector[5]);           
               tfWtSapp2.setText(vector[6]);
               tfBarrio1.setText(vector[8]);
               tfCiudad2.setText(vector[9]);
               tfDireccionCliente1.setText(vector[10]);
               chMotivos1.setValue(vector[11]);
               tfHomenajeado1.setText(vector[12]);
               chParentezco1.setValue(vector[13]);
               tfQuien1.setText(vector[14]);
               chObsequio1.setValue(vector[15]);
               tfCostoServicio1.setText(vector[16]);
               tfPrecioSonido1.setText(vector[17]);
               tfPreObsequio1.setText(vector[18]);
               tfTransporte.setText(vector[19]);
               SpinnerValueFactory<Integer> ValuesspCantidadMusicos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
               ValuesspCantidadMusicos.setValue(Integer.parseInt(vector[20]));
               spCantidadMusicos1.setValueFactory(ValuesspCantidadMusicos);
               tgButtonCotizacion.setText(vector[21]);
               tfFechaCotizacion.setValue(Empleado.LocalDateStringConverter(vector[22])); 
               totalCotizacion.setText(vector[23]);

               if(tgButtonCotizacion.getText().equals("Activa")){               
                tgButtonCotizacion.setStyle("-fx-background-color: #008000;");                       
                                    
                }else if(tgButtonCotizacion.getText().equals("Anulada")){
                    tgButtonCotizacion.setStyle("-fx-background-color: #ff0000;");                   
                }

                horaSerenata.setLocalTime((Empleado.LocalTimeStringConverter(vector[24])));
                
                

               
               

            }                
         }   

    }


    @FXML
    void calcularCotizacion(ActionEvent event) {

        String precioVenta = tfCostoServicio1.getText();
        String sonido = tfPrecioSonido1.getText();
        String preObsequio= tfPreObsequio1.getText();
        String transporte = tfTransporte.getText();
        
       
        String total = String.valueOf(Integer.parseInt(precioVenta) + Integer.parseInt(sonido) + Integer.parseInt(preObsequio) + Integer.parseInt(transporte));

        totalCotizacion.setText(total);
        totalCotizacion.setEditable(false);



    }

    @FXML
    void limpiarCalculoCotizacion(ActionEvent event) {


        tfCostoServicio1.setText("0");
        tfPrecioSonido1.setText("0");
        tfPreObsequio1.setText("0");
        tfTransporte.setText("0");
        totalCotizacion.setEditable(true);
        totalCotizacion.clear();  
     
         }



    @FXML
    void guardarCotizacion(ActionEvent event) {

           String fechaCotizacion= "'" + tfFechaCotizacion.getValue() + "'";
           String idCliente = "'" + tfCliente2.getText() + "'";
           String nombreCliente = "'" + tfNombreCLiente3.getText() + "'";
           String emailCliente  = "'" + tfEmail2.getText() + "'";
           String wtCliente  = "'" + tfWtSapp2.getText() + "'";
           String telDosClie  = "'" + tfTelefonoCliente2.getText() + "'";
           String telUnoClie = "'" + tfTelefonoCliente1.getText() + "'";
           String barrio = "'" + tfBarrio1.getText() + "'";
           String ciudad = "'" + tfCiudad2.getText() + "'";
           String direccion= "'" + tfDireccionCliente1.getText() + "'";
           String motivo = "'" + chMotivos1.getValue() + "'";
           String homenajeado = "'" + tfHomenajeado1.getText() + "'";
           String parentezco = "'" + chParentezco1.getValue() + "'";
           String quien = "'" + tfQuien1.getText() + "'";
           String obsequio = "'" + chObsequio1.getValue() + "'";
           String precioVenta = "'" + tfCostoServicio1.getText() + "'";
           String sonido = "'" + tfPrecioSonido1.getText() + "'";
           String preObsequio= "'" + tfPreObsequio1.getText() + "'";
           String cantMusico = "'" + spCantidadMusicos1.getValue() + "'";
           String estado =  "'" + tgButtonCotizacion.getText() + "'";
           String transporte = "'" + tfTransporte.getText() + "'";
           String total =  "'" + totalCotizacion.getText() + "'";
           String hora = "'" + horaSerenata.getLocalTime() + "'";
           
          
          

           cotizacion ingCotizacion = new cotizacion (fechaCotizacion,idCliente,nombreCliente,emailCliente,
           wtCliente,telDosClie,telUnoClie,barrio,ciudad,direccion,motivo,homenajeado,parentezco,quien, 
           obsequio,precioVenta,sonido,preObsequio,cantMusico,estado,transporte,total,hora);
            
           ingCotizacion.cargaCotizacion(); 

            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CREACIÓN DE COTIZACION");
            dialogoAlerta.setHeaderText("Desea crear una nueva cotizacion?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("CREACIÓN DE COTIZACION");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();

           tfFechaCotizacion.setValue(null);
           tfCliente2.clear();
           tfNombreCLiente3.clear();
           tfEmail2.clear();
           tfWtSapp2.clear();
           tfTelefonoCliente2.clear();
           tfTelefonoCliente1.clear();
           tfBarrio1.clear();
           tfCiudad2.clear();
           tfDireccionCliente1.clear();
           chMotivos1.getSelectionModel().clearSelection(); 
           tfHomenajeado1.clear();
           chParentezco1.getSelectionModel().clearSelection(); 
           tfQuien1.clear();
           chObsequio1.getSelectionModel().clearSelection(); 
           tfCostoServicio1.setText("0");
           tfPrecioSonido1.setText("0");
           tfPreObsequio1.setText("0");
           SpinnerValueFactory<Integer> spCantidadMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
           spCantidadMusicos1.setValue(0);
           totalCotizacion.clear();
           tfTransporte.setText("0");
           tfCotizacion1.setText(cotizacion.idCotizacion()); 
           
                 
          

    }



    @FXML
    void guardarCliente(ActionEvent event) {

           String nomCliente = "'" + TxNombresCliente1.getText() + "'";
           String docCliente = "'" + TxNumIdentidad1.getText() + "'";
           String emailCliente = "'" + TxEmail.getText() + "'";
           String telDosClie  = "'" + txTelCliente2.getText() + "'";
           String telUnoClie = "'" + txTelCliente1.getText() + "'";
           String wtCliente = "'" + txWhatSapp.getText() + "'";
           String refCliente = "'" + ChMedio.getValue() + "'";
           
                   

           cliente ingCliente = new cliente (nomCliente,docCliente,emailCliente,telDosClie,telUnoClie,wtCliente,refCliente );
            
           ingCliente.cargaCliente(); 

            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CREACIÓN DE CLIENTE");
            dialogoAlerta.setHeaderText("Desea crear el nuevo cliente?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("CREACIÓN DE CLIENTE");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();
           
            TxNombresCliente1.clear();
            TxNumIdentidad1.clear();
            TxEmail.clear();
            txTelCliente2.clear();            
            ChMedio.getSelectionModel().clearSelection();       
            txWhatSapp.clear();
            txTelCliente1.clear();
            TxDocIde1.setText(cliente.idCliente()); 
           

    }

    @FXML
    void limpiarCliente(ActionEvent event) {


            TxNombresCliente1.clear();
            TxNumIdentidad1.clear();
            TxEmail.clear();
            txTelCliente2.clear();            
            ChMedio.getSelectionModel().clearSelection();       
            txWhatSapp.clear();
            txTelCliente1.clear();
            TxDocIde1.clear();  
     
         }


         @FXML
         void limpiarClienteDos(ActionEvent event) {
     
            tfCliente2.clear();
            tfNombreCLiente3.clear();
            tfEmail2.clear();
            tfWtSapp2.clear();
            tfTelefonoCliente1.clear();             
            tfTelefonoCliente2.clear();
             
          
              }


         @FXML
         void buscarClientesCotizacion(ActionEvent event) {
     
             String datos;
             String[] vector;
              
             if (TxDocIde1.getLength() > 0 ){
     
                 datos = cliente.buscarClienteId(tfCliente2.getText());
                 vector = datos.split(",");
                 System.out.println(datos);
     
                 if (datos.equals("")){
     
                     Alert dialogoAlerta = new Alert(AlertType.ERROR);
                     dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL CLIENTE");
                     dialogoAlerta.setHeaderText("LEL CLIENTE  #" + tfCliente2.getText() + " NO EXISTE");
                     dialogoAlerta.setContentText("Validar el id correcto del cliente");
                     dialogoAlerta.initStyle(StageStyle.UTILITY);
                     java.awt.Toolkit.getDefaultToolkit().beep();
                     dialogoAlerta.showAndWait();
                 }else{           
                                 
                    tfNombreCLiente3.setText(vector[0]);
                    tfEmail2.setText(vector[2]);
                    tfTelefonoCliente1.setText(vector[3]);
                    tfTelefonoCliente2.setText(vector[4]);           
                    tfWtSapp2.setText(vector[5]);
                    
     
                 }                
              }   
            }         

    @FXML
    void buscarClientes(ActionEvent event) {

        String datos;
        String[] vector;
         
        if (TxDocIde1.getLength() > 0 ){

            datos = cliente.buscarClienteId(TxDocIde1.getText());
            vector = datos.split(",");
            System.out.println(datos);

            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL CLIENTE");
                dialogoAlerta.setHeaderText("LEL CLIENTE  #" + TxDocIde1.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el id correcto del cliente");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{           
                            
                TxNombresCliente1.setText(vector[0]);
                TxNumIdentidad1.setText(vector[1]);
                TxEmail.setText(vector[2]);
                txTelCliente1.setText(vector[3]);
                txTelCliente2.setText(vector[4]);           
                txWhatSapp.setText(vector[5]);
                ChMedio.setValue(vector[6]);

                             
                
            }     
     
        }else{

            Alert dialogoAlerta = new Alert(AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL LA NOMINA");
            dialogoAlerta.setHeaderText("ES NECESARIO DIGITAR EL CAMPO ID");
            dialogoAlerta.setContentText("Validar el ID correcto de la nomina");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
                   
        }




     
         }    
         
         @FXML
         void editarCliente(ActionEvent event) {   
  
                        
            String nomCliente = "'" + TxNombresCliente1.getText() + "'";
            String docCliente = "'" + TxNumIdentidad1.getText() + "'";
            String emailCliente = "'" + TxEmail.getText() + "'";
            String telDosClie  = "'" + txTelCliente2.getText() + "'";
            String telUnoClie = "'" + txTelCliente1.getText() + "'";
            String wtCliente = "'" + txWhatSapp.getText() + "'";
            String refCliente = "'" + ChMedio.getValue() + "'";
                                
 
            cliente ingCliente = new cliente (nomCliente,docCliente,emailCliente,telDosClie,telUnoClie,wtCliente,refCliente );
             
            ingCliente.editarCliente(TxDocIde1.getText() );  
                       


            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("GESTION DE CLIEMTE");
            dialogoAlerta.setHeaderText("Desea editar al cliente?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
         
           Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
           dialogoAlerta1.setTitle("MODIFICACIÓN DE EMPLEADOS");
           dialogoAlerta1.setHeaderText("Operacion exitosa");           
           dialogoAlerta1.initStyle(StageStyle.UTILITY);
           java.awt.Toolkit.getDefaultToolkit().beep();
           dialogoAlerta1.showAndWait();

      
  
  
  
         }     
    

         @FXML
         void retirarCliente(ActionEvent event) {
     
             Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
             dialogoAlerta.setTitle("ELIMINAR CLIENTE");
             dialogoAlerta.setHeaderText("Desea eliminar el cliente de la base de datos?");           
             dialogoAlerta.initStyle(StageStyle.UTILITY);
             java.awt.Toolkit.getDefaultToolkit().beep();
             dialogoAlerta.showAndWait();
     
        
     
            cliente.eliminarCliente(TxDocIde1.getText());
        
            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("CLIENTE ELIMINADO");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();
     
         }


         @FXML
         void imprimirCliente(ActionEvent event) throws FileNotFoundException, DocumentException {
     
            String nomCliente = TxNombresCliente1.getText();
            String docCliente = TxNumIdentidad1.getText();
            String emailCliente = TxEmail.getText();
            String telDosClie  = txTelCliente2.getText();
            String telUnoClie = txTelCliente1.getText();
            String wtCliente =  txWhatSapp.getText();
            String idCliente =  TxDocIde1.getText();
            String refCliente =  ChMedio.getValue();
        
     
            pdfCliente certificado = new pdfCliente (nomCliente,docCliente, emailCliente, telDosClie , telUnoClie, wtCliente, refCliente, idCliente);
     
         
            certificado.imprimirCertificado();
     
         }









    @FXML
    void ButtonEstadoDoc(ActionEvent event) {

        

        if(tgButtonFactura.isSelected()){

            tgButtonFactura.setStyle("-fx-background-color: #008000;");
            tgButtonFactura.setText("Activa");   
               
               
        }else{
            tgButtonFactura.setStyle("-fx-background-color: #ff0000;");
            tgButtonFactura.setText("Anulada");

        }

        if(tgButtonCotizacion.isSelected()){

            tgButtonCotizacion.setStyle("-fx-background-color: #008000;");
            tgButtonCotizacion.setText("Activa");   
               
               
        }else{
            tgButtonCotizacion.setStyle("-fx-background-color: #ff0000;");
            tgButtonCotizacion.setText("Anulada");

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
    
    String[] motivo = {"Cumpleaños", "Quinceañero", "Matrimonio", "Amor y amistad", "Dia de las madres", "Dia del padre", "Reconciliacion","Pedida de mano", "Carnavales", "Semana santa", "Dia de la virgen", "Amigos", "Novios","Aniversario", "Cementerio","Despedida","Graduacion","Navidad" };
    String[] medio = {"Tarjeta", "Recomendando", "Facebook", "Instagram", "Google", "Familiar", "En un servicio"};
    String[] parentezco = {"Mama", "Papa", "Amigos", "Esposo", "Hermanos", "Familiar", "Sobrinos", "Tios", "Nietos", "Abuelos", "Vecinos"};
    String[] obsequio = {"Ramillete de flores", "Peluche", "Video", "Fotografia","Caja de chocolate","Combo completo"};
    


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ChMedio.getItems().addAll(medio);
        chMotivos1.getItems().addAll(motivo);
        chParentezco1.getItems().addAll(parentezco);
        chObsequio1.getItems().addAll(obsequio);
        chMotivos11.getItems().addAll(motivo);
        chParentezco11.getItems().addAll(parentezco);
        chObsequio11.getItems().addAll(obsequio);



        SpinnerValueFactory<Integer> ValueSpCantidadMusicos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        SpinnerValueFactory<Integer> ValueSpCantidadMusicos2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
          
        
        ValueSpCantidadMusicos1.setValue(0);
        ValueSpCantidadMusicos2.setValue(0);
        
        
        spCantidadMusicos1.setValueFactory(ValueSpCantidadMusicos1);
        spCantidadMusicos11.setValueFactory(ValueSpCantidadMusicos2);

        TxDocIde1.setText(cliente.idCliente()); 
        tfCotizacion1.setText(cotizacion.idCotizacion()); 
        tfIdFactura.setText(factura.idFactura()); 

       
       
    }

    
}
