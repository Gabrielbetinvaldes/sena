package controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class sesionController   {

    @FXML
    private TextField TextUsuario;

    @FXML
    private PasswordField TextContraseña;

    @FXML
    private Button ButtonIngresar;

    @FXML
    private Button ButtonSalir;

    @FXML
    private Label lMensajeError;

    @FXML
    void ingresar(ActionEvent event) throws IOException {


        String usuario = TextUsuario.getText();
        String contrasena = TextContraseña.getText();
                
        
        if (  usuario.equals("Gabriel Betin") && contrasena.equals( "123456" ) ){
          
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuPrincipal.fxml"));

            Parent root = fxmlLoader.load();
            
            MenuController controlador = fxmlLoader.getController();

            Scene scene = new Scene(root);
            Stage secondaryStage = new Stage(); 
            secondaryStage.initModality(Modality.WINDOW_MODAL);           

            secondaryStage.setTitle("MENU DE OPCIONES.");
            secondaryStage.setScene(scene);
            secondaryStage.show();
            secondaryStage.setMaximized(false);
            secondaryStage.setResizable(false);

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();


            
       
                 
            
                        
          
        }else{


            Alert dialogoAlerta = new Alert(AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
            dialogoAlerta.setHeaderText("USUARIO NO ENCONTRADO");
            dialogoAlerta.setContentText("Validar usuario y contraseña para ingresar al sistema");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
           
           
           
        }
        
        
           
    }

    
    

    @FXML
    void salir(ActionEvent event) {
        
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

  

}