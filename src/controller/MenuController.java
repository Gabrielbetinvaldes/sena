package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {

   
    private String rolUsuario;


   



    @FXML
    private Button RecursosHumanoButton;

    @FXML
    private Button ContabilidadRegistroButton;

    @FXML
    private Button GerenciaButton;

    @FXML
    private Button ButtonImagenGr;

    @FXML
    private Button ButtonImagenCont;

    @FXML
    private Button ButtonImagenRH;
  
  
    @FXML
    private Label labelRol;

    @FXML
    void Gerencia(ActionEvent event) throws IOException {


        if(  rolUsuario.toString().equals("1")){
        
            FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/view/Informes.fxml"));

            Parent root3 = fxmlLoader3.load();
            
            InformeController controlador3 = fxmlLoader3.getController();
            controlador3.setRolUsuario(rolUsuario.toString());

            Scene scene3 = new Scene(root3);
            Stage secundary = new Stage();            

            secundary.setTitle("Gerencia Administrativa.");
            secundary.setScene(scene3);
            secundary.show();
            secundary.setMaximized(false);
            secundary.setResizable(false);
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
       


        }else{


            Alert dialogoAlerta = new Alert(AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
            dialogoAlerta.setHeaderText("USUARIO NO AUTORIZADO");
            dialogoAlerta.setContentText("Esta usuario no tiene acceso al modulo de Gerencia");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
        



        }

    }





    @FXML
    void RecursosHumano(ActionEvent event) throws IOException {


        if(  rolUsuario.toString().equals("1") || rolUsuario.toString().equals("2") ){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/RecursosHumano.fxml"));

                Parent root = fxmlLoader.load();
                
                RecursosHumanoController controlador = fxmlLoader.getController();
                controlador.setRolUsuario(rolUsuario.toString());
                
            

                Scene scene = new Scene(root);
                Stage fifth = new Stage();            

                fifth.setTitle("Recursos Humano.");
                fifth.setScene(scene);
                fifth.show();
                fifth.setMaximized(false);
                fifth.setResizable(false);

                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            
        }else{


            Alert dialogoAlerta = new Alert(AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
            dialogoAlerta.setHeaderText("USUARIO NO AUTORIZADO");
            dialogoAlerta.setContentText("Esta usuario no tiene acceso al modulo de Gerencia");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();


        }    
    }

    @FXML
    void ContabilidadRegistros(ActionEvent event) throws IOException {

        if(  rolUsuario.toString().equals("1") || rolUsuario.toString().equals("3") ){

            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/view/ContabilidadRegistros.fxml"));

                Parent root2 = fxmlLoader2.load();
                
                ContabilidadRegistrosController controlador2 = fxmlLoader2.getController();
                controlador2.setRolUsuario(rolUsuario.toString());

                Scene scene2 = new Scene(root2);
                Stage quarter = new Stage();            

                quarter.setTitle("Contabilidad y registros.");
                quarter.setScene(scene2);
                quarter.show();
                quarter.setMaximized(false);
                quarter.setResizable(false);
                
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
        }else{



            Alert dialogoAlerta = new Alert(AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR EN LA VALIDACIÓN DEL USUARIO");
            dialogoAlerta.setHeaderText("USUARIO NO AUTORIZADO");
            dialogoAlerta.setContentText("Esta usuario no tiene acceso al modulo de Gerencia");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();



        }    

    }

    
    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
        
    }
    

}