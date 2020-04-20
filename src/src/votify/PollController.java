package votify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controller for the Poll page. Handles button clicks to the other tabs
 *
 * @author Zach Rooney
 * @version 4/19/20
 */
public class PollController implements Initializable {
    public VBox sideMenu;
    public Button homeButton;
    public Button pollButton;
    public Button newsButton;
    public WebView pollView;
    public AnchorPane pollPane;
    private Stage stage;

    /**
     * Changes the window to the home page on click from the Poll page
     * @param actionEvent Mouse click on home button
     * @throws IOException if the sample.fxml file cannot load
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
     * Reloads the poll page on click from the poll page already
     * @param actionEvent Mouse click on the Latest Polls button
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
     * Changes the window to the news page on click from the poll page
     * @param actionEvent Mouse click on the news button
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

    /**
     * Initializes the poll page and fetches the data from the specified link
     * @param url unused
     * @param resourceBundle unused
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        WebEngine engine = pollView.getEngine();
        engine.load("https://www.realclearpolitics.com/epolls/2020/president/us/general_election_trump_vs_biden-6247.html");
    }

}