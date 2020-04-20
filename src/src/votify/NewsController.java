package votify;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * Controller for the News page of the app. Handles all clicks on the page and displays newsPage.fxml
 */
public class NewsController implements Initializable {
    // Common button menu on the left side of every page
    public VBox sideMenu;
    public Button homeButton;
    public Button pollButton;
    public Button newsButton;

    // News page specific button
    public WebView newsWebView;
    public Button toggleWebView;

    public Label newsTitle;

    // Images and captions for each of the 20 news stories
    public ImageView news00;
    public ImageView news01;
    public ImageView news02;
    public ImageView news03;
    public ImageView news04;
    public ImageView news05;
    public ImageView news06;
    public ImageView news07;
    public ImageView news08;
    public ImageView news09;
    public ImageView news10;
    public ImageView news11;
    public ImageView news12;
    public ImageView news13;
    public ImageView news14;
    public ImageView news15;
    public ImageView news16;
    public ImageView news17;
    public ImageView news18;
    public ImageView news19;
    public Label label00;
    public Label label01;
    public Label label02;
    public Label label03;
    public Label label04;
    public Label label05;
    public Label label06;
    public Label label07;
    public Label label08;
    public Label label09;
    public Label label10;
    public Label label11;
    public Label label12;
    public Label label13;
    public Label label14;
    public Label label15;
    public Label label16;
    public Label label17;
    public Label label18;
    public Label label19;

    // Arrays to store all of the above buttons and labels
    private ImageView[] newsButtons = new ImageView[20];
    private Label[] newsLabels = new Label[20];

    // JSONs for each search term that can be loaded on click
    private newsApiJson generalElection = null;
    private newsApiJson joeBiden = null;
    private newsApiJson donaldTrump = null;

    private newsApiJson currentJSON = null;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Changes the window to the home page on click from the news page
     * @param actionEvent Mouse click on Home button
     * @throws IOException if the homePage.fxml file cannot load
     */
    public void homeClick(ActionEvent actionEvent) throws IOException {


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Changes the window to the poll page on click from the news page
     * @param actionEvent Mouse click on the Latest Polls button
     * @throws IOException if the pollPage.fxml file cannot load
     */
    public void pollClick(ActionEvent actionEvent) throws IOException {


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("pollPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Reloads the news page on click from the news page
     * @param actionEvent Mouse click on the News button
     * @throws IOException if the newsPage.fxml file cannot be loaded
     */
    public void newsClick(ActionEvent actionEvent) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("newsPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Fills the newsButtons and newsLabels arrays with the individual buttons
     */
    private void initializeNewsButtonsArray()
    {
        newsButtons[0] = news00;
        newsButtons[1] = news01;
        newsButtons[2] = news02;
        newsButtons[3] = news03;
        newsButtons[4] = news04;
        newsButtons[5] = news05;
        newsButtons[6] = news06;
        newsButtons[7] = news07;
        newsButtons[8] = news08;
        newsButtons[9] = news09;
        newsButtons[10] = news10;
        newsButtons[11] = news11;
        newsButtons[12] = news12;
        newsButtons[13] = news13;
        newsButtons[14] = news14;
        newsButtons[15] = news15;
        newsButtons[16] = news16;
        newsButtons[17] = news17;
        newsButtons[18] = news18;
        newsButtons[19] = news19;
        newsLabels[0] = label00;
        newsLabels[1] = label01;
        newsLabels[2] = label02;
        newsLabels[3] = label03;
        newsLabels[4] = label04;
        newsLabels[5] = label05;
        newsLabels[6] = label06;
        newsLabels[7] = label07;
        newsLabels[8] = label08;
        newsLabels[9] = label09;
        newsLabels[10] = label10;
        newsLabels[11] = label11;
        newsLabels[12] = label12;
        newsLabels[13] = label13;
        newsLabels[14] = label14;
        newsLabels[15] = label15;
        newsLabels[16] = label16;
        newsLabels[17] = label17;
        newsLabels[18] = label18;
        newsLabels[19] = label19;
    }

    /**
     * Helper function that fills the individual news buttons and labels with information from the current JSON
     * Sets the button text and image, and sets visibility on if the button is available
     */
    private void updateNews()
    {
        for (int i = 0; i < newsButtons.length; i++)
        {
            if (currentJSON.getImgURL(i) != null)
            {
                newsLabels[i].setVisible(true);
                newsButtons[i].setImage(new Image(currentJSON.getImgURL(i)));
                newsLabels[i].setText(currentJSON.getSource(i)+": "+currentJSON.getTitle(i));
                newsLabels[i].setWrapText(true);
                newsLabels[i].setContentDisplay(ContentDisplay.TOP);
                newsLabels[i].setGraphic(newsButtons[i]);
            }
            else if (currentJSON.getTitle(i) != null)
            {
                newsLabels[i].setVisible(true);
                newsLabels[i].setText(currentJSON.getSource(i)+": "+currentJSON.getTitle(i));
                newsLabels[i].setWrapText(true);
                newsLabels[i].setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
            else
            {
                newsLabels[i].setVisible(false);
            }
        }
    }

    /**
     * Creates a newsApiJson for each of the three default search terms and initializes all of the buttons
     * Defaults to generalElection as the search term
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newsWebView.setVisible(false);
        //ToDo: sorting by bias
        try {
            generalElection = new newsApiJson("American+Presidential+Election");
            joeBiden = new newsApiJson("Joe+Biden+2020");
            donaldTrump = new newsApiJson("Donald+Trump+2020");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        initializeNewsButtonsArray();

        currentJSON = generalElection;
        updateNews();
    }

    /**
     * Toggles the visibility of the webView on mouse click
     * @param mouseEvent on click
     */
    public void toggleWebview(MouseEvent mouseEvent) {

        if (newsWebView.isVisible()) {
            newsWebView.setVisible(false);
        }
        else{
            newsWebView.setVisible(true);
        }

    }

    /**
     * Changes currentJSON to general election if it isn't already and loads general election news
     * @param mouseEvent on click
     */
    public void loadGeneralNews(MouseEvent mouseEvent) {

        if (currentJSON != generalElection)
        {
            newsTitle.setText("General Presidential Election News 2020");
            currentJSON = generalElection;
            updateNews();
        }
    }

    /**
     * Changes the currentJSON to joe biden if it isn't already and loads joe biden news
     * @param mouseEvent on click
     */
    public void loadBidenNews(MouseEvent mouseEvent)
    {
        if (currentJSON != joeBiden)
        {
            newsTitle.setText("Joe Biden Election News 2020");
            currentJSON = joeBiden;
            updateNews();
        }
    }

    /**
     * Changes the currentJSON to donald trump if it isn't already and loads trump news
     * @param mouseEvent
     */
    public void loadTrumpNews(MouseEvent mouseEvent)
    {
        if (currentJSON != donaldTrump)
        {
            newsTitle.setText("Donald Trump Election News 2020");
            currentJSON = donaldTrump;
            updateNews();
        }

    }

    /**
     * Loads the webpage of the news article on button 0
     * @param mouseEvent click on button 0
     */
    public void openLabel00(MouseEvent mouseEvent) {
        if (currentJSON.getURL(0) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(0));
        }
    }

    /**
     * Loads the webpage of the news article on button 1
     * @param mouseEvent click on button 1
     */
    public void openLabel01(MouseEvent mouseEvent) {
        if (currentJSON.getURL(1) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(1));
        }
    }

    /**
     * Loads the webpage of the news article on button 2
     * @param mouseEvent click on button 2
     */
    public void openLabel02(MouseEvent mouseEvent) {
        if (currentJSON.getURL(2) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(2));
        }
    }

    /**
     * Loads the webpage of the news article on button 3
     * @param mouseEvent click on button 3
     */
    public void openLabel03(MouseEvent mouseEvent) {
        if (currentJSON.getURL(3) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(3));
        }
    }

    /**
     * Loads the webpage of the news article on button 4
     * @param mouseEvent click on button 4
     */
    public void openLabel04(MouseEvent mouseEvent) {
        if (currentJSON.getURL(4) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(4));
        }
    }

    /**
     * Loads the webpage of the news article on button 5
     * @param mouseEvent click on button 5
     */
    public void openLabel05(MouseEvent mouseEvent) {

        if (currentJSON.getURL(5) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(5));
        }
    }

    /**
     * Loads the webpage of the news article on button 6
     * @param mouseEvent click on button 6
     */
    public void openLabel06(MouseEvent mouseEvent) {
        if (currentJSON.getURL(6) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(6));
        }
    }

    /**
     * Loads the webpage of the news article on button 7
     * @param mouseEvent click on button 7
     */
    public void openLabel07(MouseEvent mouseEvent) {
        if (currentJSON.getURL(7) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(7));
        }
    }

    /**
     * Loads the webpage of the news article on button 8
     * @param mouseEvent click on button 8
     */
    public void openLabel08(MouseEvent mouseEvent) {
        if (currentJSON.getURL(8) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(8));
        }
    }

    /**
     * Loads the webpage of the news article on button 9
     * @param mouseEvent click on button 9
     */
    public void openLabel09(MouseEvent mouseEvent) {
        if (currentJSON.getURL(9) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(9));
        }
    }

    /**
     * Loads the webpage of the news article on button 10
     * @param mouseEvent click on button 10
     */
    public void openLabel10(MouseEvent mouseEvent) {
        if (currentJSON.getURL(10) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(10));
        }
    }

    /**
     * Loads the webpage of the news article on button 11
     * @param mouseEvent click on button 11
     */
    public void openLabel11(MouseEvent mouseEvent) {
        if (currentJSON.getURL(11) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(11));
        }
    }

    /**
     * Loads the webpage of the news article on button 12
     * @param mouseEvent click on button 12
     */
    public void openLabel12(MouseEvent mouseEvent) {
        if (currentJSON.getURL(12) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(12));
        }
    }

    /**
     * Loads the webpage of the news article on button 13
     * @param mouseEvent click on button 13
     */
    public void openLabel13(MouseEvent mouseEvent) {
        if (currentJSON.getURL(13) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(13));
        }
    }

    /**
     * Loads the webpage of the news article on button 14
     * @param mouseEvent click on button 14
     */
    public void openLabel14(MouseEvent mouseEvent) {
        if (currentJSON.getURL(14) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(14));
        }
    }

    /**
     * Loads the webpage of the news article on button 15
     * @param mouseEvent click on button 15
     */
    public void openLabel15(MouseEvent mouseEvent) {
        if (currentJSON.getURL(15) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(15));
        }
    }

    /**
     * Loads the webpage of the news article on button 16
     * @param mouseEvent click on button 16
     */
    public void openLabel16(MouseEvent mouseEvent) {
        if (currentJSON.getURL(16) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(16));
        }
    }

    /**
     * Loads the webpage of the news article on button 17
     * @param mouseEvent click on button 17
     */
    public void openLabel17(MouseEvent mouseEvent) {
        if (currentJSON.getURL(17) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(17));
        }
    }

    /**
     * Loads the webpage of the news article on button 18
     * @param mouseEvent click on button 18
     */
    public void openLabel18(MouseEvent mouseEvent) {
        if (currentJSON.getURL(18) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(18));
        }
    }

    /**
     * Loads the webpage of the news article on button 19
     * @param mouseEvent click on button 19
     */
    public void openLabel19(MouseEvent mouseEvent) {
        if (currentJSON.getURL(19) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(19));
        }
    }
}