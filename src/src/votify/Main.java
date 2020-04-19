package votify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to start the application. Opens to the home page using homePage.fxml
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        primaryStage.setTitle("Votify");
        // Sets the scene size and directs it to the fxml
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }


}


