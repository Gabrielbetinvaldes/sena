package controller;


import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateStringConverter;
import model.Empleado;
import model.nomina;
import model.pdfEmpleados;
import model.pdfNomina;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class RecursosHumanoController implements Initializable{

    private String rolUsuario;

    @FXML
    private TextField tfCiudad2;
    
  

    
    @FXML
    private ChoiceBox<String> ChEstadoCivil1;

    @FXML
    private ChoiceBox<String> chMetodoPago1;

    @FXML
    private ChoiceBox<String> chGenero1;

    @FXML
    private ChoiceBox<String> chGenero2;

    @FXML
    private ChoiceBox<String> ChEstadoCivil2;
    
    @FXML
    private TextField tfTelefonos2;

    @FXML
    private TextField tfCargo2;

    @FXML
    private TextField tfSueldo2;

    @FXML
    private TextField tfIdEmpleado2;

    @FXML
    private TextField tfNombres2;

    @FXML
    private TextField tfNumIdentidad2;

    @FXML
    private TextField tfDireccion2;
  
    @FXML
    private TextField tfIdEmpleado1;

    @FXML
    private TextField tfNombres1;

    @FXML
    private TextField tfNumIdentidad1;

    @FXML
    private TextField tfIdFacturas;

    @FXML
    private TextField tfIdEmpleado3;

    @FXML
    private TextField tfTotal1;

    @FXML
    private TextField tfNombres3;

    @FXML
    private TextField tfValor1;
    @FXML
    private TextField IdNomina1;


    @FXML
    private TextField tfNumIdentidad3;


    @FXML
    private TextField tfDireccion1;
    @FXML
    private TextField tfTelefonos1;

    @FXML
    private TextField tfCargo1;

    @FXML
    private TextField tfSueldo1;

    @FXML
    private TextField tfCiudad1;
   

    @FXML
    private Spinner<Integer> spCantidadHijos1;
    
    @FXML
    private Spinner<Integer> spCantidadHijos2;

    @FXML
    private Spinner<Integer> spEdad1;

    @FXML
    private Spinner<Integer> spEdad2;

    
    @FXML
    private Spinner<Integer> spCantidad1;

    
    @FXML
    private DatePicker fechaPago1;


    @FXML
    private DatePicker dpFechaNacimiento1;

    @FXML
    private DatePicker dpFechaIngreso2;

    @FXML
    private DatePicker dpFechaIngreso1;

    @FXML
    private DatePicker dpFechaNacimiento2;

    @FXML
    private DatePicker dpFechaRetiro1;


    @FXML
    private DatePicker dpFechaRetiro2;

    @FXML
    private Button ButtonGuardar2;

    @FXML
    private Button ButtonBorrarIDNomina;

    @FXML
    private Button Buttonhome2;

    
    @FXML
    private Button ButtonBuscar1;

    
    @FXML
    private Button btBuscar3;

    @FXML
    private Button ButtonRetirar2;

    @FXML
    private Button buttonAgregar;

      

    @FXML
    private Button ButtonModificar2;

    @FXML
    private Button ButtonGuardar3;

    

    @FXML
    private Button ButtonLimpiarNominaGeneral;

    @FXML
    private Button ButtonModificar1;

    @FXML
    private Button ButtonImprimir1;

    @FXML
    private Button ButtonRetirar1;

    @FXML
    private Button ButtonGuardar1;

    @FXML
    private Button Buttonhome1;

    @FXML
    private Button btImprimir2;

    @FXML
    private Button Buttonhome3;

    @FXML
    private Button btBuscar2;

    @FXML
    private ToggleButton ButtonEstado1;

    @FXML
    private ToggleButton ButtonEstado2;

    @FXML
    private Button buttonLimpiar1;

    
    @FXML
    private Button ButtonLiquidar;

    @FXML
    private TextField tfSerenatas;

    @FXML
    private TextField tfSalud;

    @FXML
    private TextField tfPension;

    @FXML
    private TextField tfAhorro;

    @FXML
    private TextField tfNomina;

    @FXML
    private TextField tfDescuento;

    @FXML
    private TextField tfCultural;

    @FXML
    private Button ButtonLimṕiarNomina;



    @FXML
    void crearNomina(ActionEvent event) {

    

        String idFactura = "'" + tfIdFacturas.getText() + "'";
        String idEmpleado = "'" + tfIdEmpleado3.getText() + "'";
        String nomEmpleado = "'" + tfNombres3.getText() + "'";
        String cedulaEmpleado  = "'" + tfNumIdentidad3.getText() + "'";
        String totalNomina = "'" + tfTotal1.getText() + "'";
        String metodo = "'" + chMetodoPago1.getValue() + "'";
        String fechaPago = "'" + fechaPago1.getValue() + "'";
        String cSerenatas = "'" + tfSerenatas.getText() + "'";
        String vNomina = "'" + tfNomina.getText()+ "'";
        String salud = "'" + tfSalud.getText()+ "'";
        String  pension = "'" + tfPension.getText() + "'";
        String descuentos = "'" + tfDescuento.getText() + "'";
        String cultural = "'" + tfCultural.getText()+ "'";
        String ahorro = "'" + tfAhorro.getText()+ "'";

        
        nomina ingNomina = new nomina (idFactura,idEmpleado,cSerenatas,vNomina,pension,salud,descuentos,
        ahorro,cultural,fechaPago,metodo,totalNomina);
         
        ingNomina.cargarNomina(); 

         Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
         dialogoAlerta.setTitle("CONTABILIZAR NOMINA");
         dialogoAlerta.setHeaderText("Desea grabar la nomina?");           
         dialogoAlerta.initStyle(StageStyle.UTILITY);
         java.awt.Toolkit.getDefaultToolkit().beep();
         dialogoAlerta.showAndWait();

         Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
         dialogoAlerta1.setTitle("CONTABILIZAR NOMINA");
         dialogoAlerta1.setHeaderText("Operacion exitosa");           
         dialogoAlerta1.initStyle(StageStyle.UTILITY);
         java.awt.Toolkit.getDefaultToolkit().beep();
         dialogoAlerta1.showAndWait();
        
         
        tfIdFacturas.clear();
        tfIdEmpleado3.clear();
        tfNombres3.clear();
        tfNumIdentidad3.clear();
        tfTotal1.clear();
        chMetodoPago1.getSelectionModel().clearSelection(); 
        fechaPago1.setValue(null);
        tfSerenatas.clear();
        tfNomina.clear();
        tfSalud.clear();
        tfPension.clear();
        tfDescuento.clear();
        tfCultural.clear();
        tfAhorro.clear();
        IdNomina1.setText(nomina.idNomina());
    }




    @FXML
    void liquidarNomina(ActionEvent event) {

        String cSerenatas = tfSerenatas.getText();
        String vNomina = tfNomina.getText();     
        String descuentos = tfDescuento.getText();
        String cultural = tfCultural.getText();
        String ahorro = tfAhorro.getText();

        
        double saludLiq = Double.parseDouble(vNomina) * 0.04;
        double pensionLiq = Double.parseDouble(vNomina) * 0.04;
 
        String total = String.valueOf( Double.parseDouble(vNomina)- (saludLiq  + Double.parseDouble(ahorro) + pensionLiq + Double.parseDouble(descuentos) +Double.parseDouble(cultural)));

        int tSalud = (int)saludLiq; 
        int tPension = (int)pensionLiq;
        int tTotal = (int)Double.parseDouble(total);


        tfSalud.setText(String.valueOf(tSalud));
        tfPension.setText(String.valueOf(tPension));
        tfTotal1.setText(String.valueOf(tTotal));
        tfTotal1.setEditable(false);


    }

    @FXML
    void buscarNominaGeneral(ActionEvent event) {

        String datos;
        String[] vector;
         
        if (IdNomina1.getLength() > 0 ){

            datos = nomina.buscarNominaId(IdNomina1.getText());
            vector = datos.split(",");
            System.out.println(datos);

            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DE LA NOMINA");
                dialogoAlerta.setHeaderText("LA NOMINA  #" + IdNomina1.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el numero correcto de la nomina");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{           
                String datosEmpleado = Empleado.buscarEmpleadoId(vector[1]);
                String[] vectorEmpleado = datosEmpleado.split(",");
            
                tfIdEmpleado3.setText(vector[1]);
                tfNombres3.setText(vectorEmpleado[0]);
                tfNumIdentidad3.setText(vectorEmpleado[1]);

                tfIdFacturas.setText(vector[0]);           
                tfTotal1.setText(vector[11]);
                chMetodoPago1.setValue(vector[10]);
                fechaPago1.setValue(Empleado.LocalDateStringConverter(vector[9])); 
                tfSerenatas.setText(vector[2]);
                tfNomina.setText(vector[3]);
                tfSalud.setText(vector[5]);
                tfPension.setText(vector[4]);
                tfDescuento.setText(vector[6]);
                tfCultural.setText(vector[8]);
                tfAhorro.setText(vector[7]);
                
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
    void modificarNomina(ActionEvent event) {


        String idFactura = "'" + tfIdFacturas.getText() + "'";
        String idEmpleado = "'" + tfIdEmpleado3.getText() + "'";
        String nomEmpleado = "'" + tfNombres3.getText() + "'";
        String cedulaEmpleado  = "'" + tfNumIdentidad3.getText() + "'";
        String totalNomina = "'" + tfTotal1.getText() + "'";
        String metodo = "'" + chMetodoPago1.getValue() + "'";
        String fechaPago = "'" + fechaPago1.getValue() + "'";
        String cSerenatas = "'" + tfSerenatas.getText() + "'";
        String vNomina = "'" + tfNomina.getText()+ "'";
        String salud = "'" + tfSalud.getText()+ "'";
        String  pension = "'" + tfPension.getText() + "'";
        String descuentos = "'" + tfDescuento.getText() + "'";
        String cultural = "'" + tfCultural.getText()+ "'";
        String ahorro = "'" + tfAhorro.getText()+ "'";

        
        nomina ingNomina = new nomina (idFactura,idEmpleado,cSerenatas,vNomina,pension,salud,descuentos,
        ahorro,cultural,fechaPago,metodo,totalNomina);
         
        ingNomina.editarNomina(IdNomina1.getText()); 

         Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
         dialogoAlerta.setTitle("CONTABILIZAR NOMINA");
         dialogoAlerta.setHeaderText("Desea modificar la nomina?");           
         dialogoAlerta.initStyle(StageStyle.UTILITY);
         java.awt.Toolkit.getDefaultToolkit().beep();
         dialogoAlerta.showAndWait();

         Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
         dialogoAlerta1.setTitle("CONTABILIZAR NOMINA");
         dialogoAlerta1.setHeaderText("Operacion exitosa");           
         dialogoAlerta1.initStyle(StageStyle.UTILITY);
         java.awt.Toolkit.getDefaultToolkit().beep();
         dialogoAlerta1.showAndWait();
        
         
        tfIdFacturas.clear();
        tfIdEmpleado3.clear();
        tfNombres3.clear();
        tfNumIdentidad3.clear();
        tfTotal1.clear();
        chMetodoPago1.getSelectionModel().clearSelection(); 
        fechaPago1.setValue(null);
        tfSerenatas.clear();
        tfNomina.clear();
        tfSalud.clear();
        tfPension.clear();
        tfDescuento.clear();
        tfCultural.clear();
        tfAhorro.clear();

    }
    
    @FXML
    void retirarNomina(ActionEvent event) {

        Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("ELIMINAR NOMINA");
        dialogoAlerta.setHeaderText("Desea eliminar un registro de la base de datos?");           
        dialogoAlerta.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta.showAndWait();

   

    nomina.eliminarNomina(IdNomina1.getText());

    Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
    dialogoAlerta1.setTitle("ELIMINAR NOMINA");
    dialogoAlerta1.setHeaderText("Operacion exitosa");           
    dialogoAlerta1.initStyle(StageStyle.UTILITY);
    java.awt.Toolkit.getDefaultToolkit().beep();
    dialogoAlerta1.showAndWait();

    }

    @FXML
    void imprimirEmpleado(ActionEvent event) throws FileNotFoundException, DocumentException {

        String nombre = tfNombres2.getText();
        String cedula = tfNumIdentidad2.getText();
        String inicio = " " + dpFechaIngreso2.getValue()+ " ";
        
        String cargo =  tfCargo2.getText();
        LocalDate hoy = LocalDate.now();

        pdfEmpleados certificado = new pdfEmpleados (nombre,cedula,inicio,cargo,hoy);

        certificado.imprimirCertificado();
    }


    @FXML
    void imprimirNomina(ActionEvent event) throws FileNotFoundException, DocumentException {

        
    String idFactura = tfIdFacturas.getText();
    String idEmpleado =  tfIdEmpleado3.getText();
    String nomEmpleado = tfNombres3.getText();
    String cedulaEmpleado  =  tfNumIdentidad3.getText();
    String totalNomina = tfTotal1.getText();
    String metodo = chMetodoPago1.getValue();
    String fechaPago = "" + fechaPago1.getValue() + "";
    String cSerenatas =  tfSerenatas.getText();
    String vNomina =  tfNomina.getText();
    String salud =  tfSalud.getText();
    String  pension =  tfPension.getText();
    String descuentos = tfDescuento.getText();
    String cultural = tfCultural.getText();
    String ahorro = tfAhorro.getText();
    String idNomina = IdNomina1.getText();

   

    pdfNomina certificado = new pdfNomina (idFactura,idEmpleado,cSerenatas,vNomina,pension,salud,descuentos,
    ahorro,cultural,fechaPago,metodo,totalNomina,nomEmpleado,cedulaEmpleado,idNomina);

    certificado.imprimirCertificado();

    }






    @FXML
    void guardar(ActionEvent event) {          
      
           
           String EmpNombres = "'" + tfNombres1.getText() + "'";
           String EmpDocIdentidad = "'" + tfNumIdentidad1.getText() + "'";
           String EmpDireccion = "'" + tfDireccion1.getText() + "'";
           String EmpCiudad  = "'" + tfCiudad1.getText() + "'";
           String  EmpEstadoCivil = "'" + ChEstadoCivil1.getValue() + "'"; 
           String EmpNumerosTelefono = "'" + tfTelefonos1.getText() + "'";
           String EmpCargo = "'" + tfCargo1.getText() + "'";
           String EmpSueldo = "'" + tfSueldo1.getText() + "'";
           int EmpHijos = spCantidadHijos1.getValue();
           String EmpGenero = "'" + chGenero1.getValue() + "'";
           int EmpEdad = spEdad1.getValue(); 
           String EmpNacimiento = "'" + dpFechaNacimiento1.getValue() + "'";
           String EmpIngreso = "'" + dpFechaIngreso1.getValue()+ "'";
           String EmpRetiro = "'" + dpFechaRetiro1.getValue()+ "'";
           String EmpEstado = "'" + ButtonEstado2.getText() + "'";


          

           Empleado ingEmpleado = new Empleado (EmpNombres,EmpDocIdentidad,EmpDireccion,EmpCiudad,EmpEstadoCivil,
           EmpNumerosTelefono, EmpCargo, EmpSueldo, EmpHijos,EmpGenero,EmpEdad,EmpNacimiento, EmpIngreso,EmpEstado,EmpRetiro);
            
           ingEmpleado.cargaEmpleado(); 

            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CREACIÓN DE EMPLEADOS");
            dialogoAlerta.setHeaderText("Desea crear el nuevo empleado?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
            dialogoAlerta1.setTitle("CREACIÓN DE EMPLEADOS");
            dialogoAlerta1.setHeaderText("Operacion exitosa");           
            dialogoAlerta1.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta1.showAndWait();
           
            tfNombres1.clear();
            tfNumIdentidad1.clear();
            tfDireccion1.clear();
            tfCiudad1.clear();            
            ChEstadoCivil1.getSelectionModel().clearSelection();       
            tfTelefonos1.clear();
            tfCargo1.clear();
            tfSueldo1.clear();  
            SpinnerValueFactory<Integer> ValuesspCantidadHijos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
            ValuesspCantidadHijos1.setValue(0);
            spCantidadHijos1.setValueFactory(ValuesspCantidadHijos1);                 
            SpinnerValueFactory<Integer> ValuespEdad1= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
            ValuespEdad1.setValue(0);
            spEdad1.setValueFactory(ValuespEdad1);     
            chGenero1.getSelectionModel().clearSelection();                      
            dpFechaIngreso1.setValue(null);
            dpFechaNacimiento1.setValue(null);
            tfIdEmpleado1.setText(Empleado.idEmpleado());
   
       
        
       }

       @FXML
       void Limpiar(ActionEvent event) {

        tfIdEmpleado2.clear();
        tfNombres2.clear();
        tfNumIdentidad2.clear();
        tfDireccion2.clear();
        tfCiudad2.clear();
        ChEstadoCivil2.getSelectionModel().clearSelection();       
        tfTelefonos2.clear();
        tfCargo2.clear();
        tfSueldo2.clear();  
        SpinnerValueFactory<Integer> ValuesspCantidadHijos2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
        ValuesspCantidadHijos2.setValue(0);
        spCantidadHijos2.setValueFactory(ValuesspCantidadHijos2);                 
        SpinnerValueFactory<Integer> ValuespEdad2= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        ValuespEdad2.setValue(0);
        spEdad2.setValueFactory(ValuespEdad2);     
        chGenero2.getSelectionModel().clearSelection();                      
        dpFechaNacimiento2.setValue(null);
        dpFechaIngreso2.setValue(null);
   
       }


       @FXML
       void limpiarNomina(ActionEvent event) {


       tfSerenatas.setText("0");
        tfNomina.setText("0");
        tfSalud.setText("0");
       tfPension.setText("0");
        tfDescuento.setText("0");
       tfCultural.setText("0");
       tfAhorro.setText("0");
       tfTotal1.setEditable(true);
       tfTotal1.clear();   
            
        
          
       }

       @FXML
       void limpiarNominaGeneral(ActionEvent event) {

        tfIdFacturas.clear();
        tfIdEmpleado3.clear();
        tfNombres3.clear();
        tfNumIdentidad3.clear();

        tfSerenatas.setText("0");
        tfNomina.setText("0");
        tfSalud.setText("0");
        tfPension.setText("0");
        tfDescuento.setText("0");
        tfCultural.setText("0");
        tfAhorro.setText("0");
        tfTotal1.setEditable(true);
        tfTotal1.clear(); 
        IdNomina1.clear(); 
        fechaPago1.setValue(null);
        chMetodoPago1.setValue(null);
   
       }


       @FXML
       void limpiarIDempleadoNomina(ActionEvent event) {

        tfIdEmpleado3.clear();
        tfNombres3.clear();
        tfNumIdentidad3.clear();
   
       }





       @FXML
       void ButtonBuscar2(ActionEvent event) {  
           
        String datos;
        String[] vector;
         
        if (tfIdEmpleado3.getLength() > 0 ){

            datos = Empleado.buscarEmpleadoId(tfIdEmpleado3.getText());
            vector = datos.split(",");
            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
                dialogoAlerta.setHeaderText("EL USUARIO  #" + tfIdEmpleado3.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el id correcto del usuario");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{ 

            tfNombres3.setText(vector[0]);
            tfNumIdentidad3.setText(vector[1]);
                    
            }      
     
        }else{

            Alert dialogoAlerta = new Alert(AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
            dialogoAlerta.setHeaderText("USUARIO NO ENCONTRADO");
            dialogoAlerta.setContentText("Debe llenar el campo ID para realizar la busqueda");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
                   
        }
           
       }

       @FXML
       void ButtonBuscar1(ActionEvent event) {  
           
        String datos;
        String[] vector;
         
        if (tfIdEmpleado2.getLength() > 0 && tfNumIdentidad2.getLength() == 0 ){

            datos = Empleado.buscarEmpleadoId(tfIdEmpleado2.getText());
            vector = datos.split(",");

            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
                dialogoAlerta.setHeaderText("EL USUARIO  #" + tfIdEmpleado2.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el id correcto del usuario");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{   

                tfNombres2.setText(vector[0]);
                tfNumIdentidad2.setText(vector[1]);
                tfDireccion2.setText(vector[2]);
                tfCiudad2.setText(vector[3]);
                ChEstadoCivil2.setValue(vector[4]);          
                tfTelefonos2.setText(vector[5]);
                tfCargo2.setText(vector[6]);
                tfSueldo2.setText(vector[7]); 
                SpinnerValueFactory<Integer> ValuesspCantidadHijos2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);           
                ValuesspCantidadHijos2.setValue(Integer.parseInt(vector[8]));
                spCantidadHijos2.setValueFactory(ValuesspCantidadHijos2);
                chGenero2.setValue(vector[9]);           
                SpinnerValueFactory<Integer> ValuespEdad2= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
                ValuespEdad2.setValue(Integer.parseInt(vector[10]));
                spEdad2.setValueFactory(ValuespEdad2);
                dpFechaNacimiento2.setValue(Empleado.LocalDateStringConverter(vector[11]));           
                dpFechaIngreso2.setValue(Empleado.LocalDateStringConverter(vector[12])); 
                ButtonEstado2.setText(vector[13]); 
                if(ButtonEstado2.getText().equals("Activo")){               
                    ButtonEstado2.setStyle("-fx-background-color: #008000;");                       
                                        
                }else if(ButtonEstado2.getText().equals("Inactivo")){
                    ButtonEstado2.setStyle("-fx-background-color: #ff0000;");                   
                }

                if(vector[14].equals("null")){
                    System.out.println("Empleado activo");
                    
                }else{
                    dpFechaRetiro2.setValue(Empleado.LocalDateStringConverter(vector[14]));
                }
            }    
                      
            
                  
     
        }else if (tfIdEmpleado2.getLength() == 0 && tfNumIdentidad2.getLength() > 0 ){

            datos = Empleado.buscarEmpleadoCed(tfNumIdentidad2.getText());
            vector = datos.split(",");
            if (datos.equals("")){

                Alert dialogoAlerta = new Alert(AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
                dialogoAlerta.setHeaderText("EL USUARIO  #" + tfNumIdentidad2.getText() + " NO EXISTE");
                dialogoAlerta.setContentText("Validar el id correcto del usuario");
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialogoAlerta.showAndWait();
            }else{   

                tfNombres2.setText(vector[0]);
                tfIdEmpleado2.setText(vector[1]);
                tfDireccion2.setText(vector[2]);
                tfCiudad2.setText(vector[3]);
                ChEstadoCivil2.setValue(vector[4]);          
                tfTelefonos2.setText(vector[5]);
                tfCargo2.setText(vector[6]);
                tfSueldo2.setText(vector[7]); 
                SpinnerValueFactory<Integer> ValuesspCantidadHijos2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);           
                ValuesspCantidadHijos2.setValue(Integer.parseInt(vector[8]));
                spCantidadHijos2.setValueFactory(ValuesspCantidadHijos2);
                chGenero2.setValue(vector[9]);           
                SpinnerValueFactory<Integer> ValuespEdad2= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
                ValuespEdad2.setValue(Integer.parseInt(vector[10]));
                spEdad2.setValueFactory(ValuespEdad2);
                dpFechaNacimiento2.setValue(Empleado.LocalDateStringConverter(vector[11]));           
                dpFechaIngreso2.setValue(Empleado.LocalDateStringConverter(vector[12])); 
                ButtonEstado2.setText(vector[13]); 
                if(ButtonEstado2.getText().equals("Activo")){               
                    ButtonEstado2.setStyle("-fx-background-color: #008000;");                       
                                        
                }else if(ButtonEstado2.getText().equals("Inactivo")){
                    ButtonEstado2.setStyle("-fx-background-color: #ff0000;");                   
                }            
                if(vector[14].equals("null")){
                    System.out.println("Empleado activo");
                    
                }else{
                    dpFechaRetiro2.setValue(Empleado.LocalDateStringConverter(vector[14]));
                }

            }
        }
           
       }

       @FXML
       void modificarEmpleado(ActionEvent event) {

            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("MODIFICACIÓN DE DATOS DE EMPLEADOS");
            dialogoAlerta.setHeaderText("Desea modificar un dato de algun empleado?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

            tfNombres2.setEditable(true);
            tfNumIdentidad2.setEditable(true);
            tfDireccion2.setEditable(true);
            tfCiudad2.setEditable(true);                    
            tfTelefonos2.setEditable(true);
            tfCargo2.setEditable(true);
            tfSueldo2.setEditable(true);           
            dpFechaNacimiento2.setEditable(true);          
            dpFechaIngreso2.setEditable(true);                 
            dpFechaRetiro2.setEditable(true); 
   
       }



       @FXML
       void editarEmpleado(ActionEvent event) {   

        String EmpNombres = "'" + tfNombres2.getText() + "'";
        String EmpDocIdentidad = "'" + tfNumIdentidad2.getText() + "'";
        String EmpDireccion = "'" + tfDireccion2.getText() + "'";
        String EmpCiudad  = "'" + tfCiudad2.getText() + "'";
        String  EmpEstadoCivil = "'" + ChEstadoCivil2.getValue() + "'"; 
        String EmpNumerosTelefono = "'" + tfTelefonos2.getText() + "'";
        String EmpCargo = "'" + tfCargo2.getText() + "'";
        String EmpSueldo = "'" + tfSueldo2.getText() + "'";
        int EmpHijos = spCantidadHijos2.getValue();
        String EmpGenero = "'" + chGenero2.getValue() + "'";
        int EmpEdad = spEdad2.getValue(); 
        String EmpNacimiento = "'" + dpFechaNacimiento2.getValue() + "'";
        String EmpIngreso = "'" + dpFechaIngreso2.getValue()+ "'";
        String EmpRetiro = "'" + dpFechaRetiro2.getValue()+ "'";
        String EmpEstado = "'" + ButtonEstado2.getText() + "'";
        String idEmpleado = tfIdEmpleado2.getText();

        Empleado ingEmpleado = new Empleado (EmpNombres,EmpDocIdentidad,EmpDireccion,EmpCiudad,EmpEstadoCivil,
        EmpNumerosTelefono, EmpCargo, EmpSueldo, EmpHijos,EmpGenero,EmpEdad,EmpNacimiento, EmpIngreso,EmpEstado,EmpRetiro);
         
        ingEmpleado.editarEmpleado(idEmpleado); 

       
         Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
         dialogoAlerta1.setTitle("MODIFICACIÓN DE EMPLEADOS");
         dialogoAlerta1.setHeaderText("Operacion exitosa");           
         dialogoAlerta1.initStyle(StageStyle.UTILITY);
         java.awt.Toolkit.getDefaultToolkit().beep();
         dialogoAlerta1.showAndWait();



       }
 
       @FXML
        void retirarEmpleado(ActionEvent event) {


            Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("ELIMINAR EMPLEADOS");
            dialogoAlerta.setHeaderText("Desea eliminar un empleado de la base de dato?");           
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();

        String idEmpleado = tfIdEmpleado2.getText();

        Empleado.eliminarEmpleado(idEmpleado);

        Alert dialogoAlerta1 = new Alert(AlertType.INFORMATION);
        dialogoAlerta1.setTitle("ELIMINAR EMPLEADOS");
        dialogoAlerta1.setHeaderText("Operacion exitosa");           
        dialogoAlerta1.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta1.showAndWait();




         } 

     

    @FXML
    void ButtonEstado(ActionEvent event) {        

        if(ButtonEstado2.isSelected()){

            ButtonEstado2.setStyle("-fx-background-color: #008000;");
            ButtonEstado2.setText("Activo");                 
               
               
        }else{
            ButtonEstado2.setStyle("-fx-background-color: #ff0000;");
            ButtonEstado2.setText("Inactivo");

        }

        if(ButtonEstado2.isSelected()){

            ButtonEstado2.setStyle("-fx-background-color: #008000;");
            ButtonEstado2.setText("Activo");   
               
               
        }else{
            ButtonEstado2.setStyle("-fx-background-color: #ff0000;");
            ButtonEstado2.setText("Inactivo");

        }

    }

    @FXML
    void homeUno(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuPrincipal.fxml"));

        Parent root = fxmlLoader.load();
        
        MenuController controlador = fxmlLoader.getController();
        controlador.setRolUsuario(rolUsuario.toString());

        Scene scene = new Scene(root);
        Stage secondaryStage = new Stage();            

        secondaryStage.setTitle("MENU DE OPCIONES.");
        secondaryStage.setScene(scene);
        secondaryStage.show();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();


    }
    String[] gen = {"F", "M", "Otro"};
    String[] estaCivil = {"Soltero", "Casado", "Union Libre"};
    
    String[] metPago = {"Efectivo", "Sin Pago", "Daviplata", "Neqqui", "Bancolombia a la mano"};



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

      
        ChEstadoCivil1.getItems().addAll(estaCivil);
        ChEstadoCivil2.getItems().addAll(estaCivil);
        
        chMetodoPago1.getItems().addAll(metPago);
        chGenero1.getItems().addAll(gen);
        chGenero2.getItems().addAll(gen);

       
        SpinnerValueFactory<Integer> ValueSpCantidadHijos1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        SpinnerValueFactory<Integer> ValuespEdad1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        SpinnerValueFactory<Integer> ValuespEdad2= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        SpinnerValueFactory<Integer> ValuesspCantidadHijos2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        
        

        
        ValueSpCantidadHijos1.setValue(0);
        ValuespEdad1.setValue(0);
        ValuespEdad2.setValue(0);
        ValuesspCantidadHijos2.setValue(0);
       

        
        spCantidadHijos1.setValueFactory(ValueSpCantidadHijos1);
        spEdad1.setValueFactory(ValuespEdad1);
        spEdad2.setValueFactory(ValuespEdad2);
        spCantidadHijos2.setValueFactory(ValuesspCantidadHijos2);
        

                     
        tfIdEmpleado1.setText(Empleado.idEmpleado());
        IdNomina1.setText(nomina.idNomina());           
               

    }


    public String getRolUsuario() {
        return rolUsuario;
    }




    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

}

