package votify;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
//import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller for the home page built with SceneBuilder
 */
public class Controller implements Initializable
{

    // Common buttons on the left side of the window
    public VBox sideMenu;
    public Button homeButton;
    public Button pollButton;
    public Button newsButton;

    // Home page specific labels and images
    public Label welcomeLabel;
    public ComboBox electionMenu;
    public ImageView candidateImage;
    public ImageView ballotImage;
    public Label titleLabel;
    // List for the dropdown menu
    ObservableList<String> cBoxList = FXCollections.observableArrayList("More coming soon!");

    /**
     * Initializes the javafx homepage
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        electionMenu.setItems(cBoxList); // Adds to the dropdown menu
        titleLabel.getStyleClass().add("outline"); // Allows for outlined text for readability
    }

    /**
     * Reloads the home page on click from the home page
     * @param actionEvent Mouse click on the Home button
     * @throws IOException if the homePage.fxml file cannot load
     */
    public void homeClick(ActionEvent actionEvent) throws IOException {


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        tableViewScene.getStylesheets().add(Controller.class.getResource("guiStyling.css").toExternalForm());
        window.show();
    }

    /**
     * Changes the window to the poll page on click from the home page
     * @param actionEvent Mouse click on Latest Polls button
     * @throws IOException if the pollPage.fxml file cannot load
     */
    public void pollClick(ActionEvent actionEvent) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("pollPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        tableViewScene.getStylesheets().add(Controller.class.getResource("guiStyling.css").toExternalForm());
        window.show();
    }

    /**
     * Changes the window to the news page on click from the home page
     * @param actionEvent Mouse click on the News button
     * @throws IOException if the newsPage.fxml file cannot load
     */
    public void newsClick(ActionEvent actionEvent) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("newsPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        tableViewScene.getStylesheets().add(Controller.class.getResource("guiStyling.css").toExternalForm());
        window.show();
    }
}
