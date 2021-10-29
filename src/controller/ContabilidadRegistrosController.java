package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

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
    private Button txBuscar5;

    @FXML
    private Button txBuscar4;

    @FXML
    private Button txBuscar6;

    @FXML
    private Button txBuscar7;

    @FXML
    private Button txBuscar8;

    @FXML
    private Button btGuardar5;

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
    private TextField tfSonido1;

    @FXML
    private TextField tfPrecioSerenata1;



    @FXML
    private Button btGuardar51;

    @FXML
    private Button bthome51;

    @FXML
    private DatePicker tfFechaCotizacion2;

    @FXML
    private TextField tfCliente21;

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
    private ChoiceBox<String> chParentezco11;

    @FXML
    private ChoiceBox<String> chObsequio11;

    @FXML
    private TextField tfCostoServicio11;

    @FXML
    private TextField tfSonido11;

    @FXML
    private TextField tfPrecioSerenata11;

   
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
            tgButtonCotizacion.setText("Activo");   
               
               
        }else{
            tgButtonCotizacion.setStyle("-fx-background-color: #ff0000;");
            tgButtonCotizacion.setText("Inactivo");

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
       
       
    }

    
}
