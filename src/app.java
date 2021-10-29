import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class app extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Inicio.fxml"));

        Parent root = fxmlLoader.load();        
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login - Mariachi Pasion Mexicana.");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        
    }
   
   
}