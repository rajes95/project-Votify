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


public class NewsController implements Initializable {
    public VBox sideMenu;
    public Button homeButton;
    public Button pollButton;
    public Button newsButton;

    public WebView newsWebView;
    public Button toggleWebView;

    public Label newsTitle;

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

    private ImageView[] newsButtons = new ImageView[20];
    private Label[] newsLabels = new Label[20];

    private newsApiJson generalElection = null;
    private newsApiJson joeBiden = null;
    private newsApiJson donaldTrump = null;

    private newsApiJson currentJSON = null;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void homeClick(ActionEvent actionEvent) throws IOException {


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void pollClick(ActionEvent actionEvent) throws IOException {


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("pollPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }


    public void newsClick(ActionEvent actionEvent) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("newsPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

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
            else
            {
                newsLabels[i].setVisible(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newsWebView.setVisible(false);
        //ToDo: sorting by bias
        try {
            generalElection = new newsApiJson("USA+Presidential+Primary+2020");
            joeBiden = new newsApiJson("Joe+Biden+2020");
            donaldTrump = new newsApiJson("Donald+Trump+2020");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initializeNewsButtonsArray();

        currentJSON = generalElection;
        updateNews();
    }


    public void toggleWebview(MouseEvent mouseEvent) {

        if (newsWebView.isVisible()) {
            newsWebView.setVisible(false);
        }
        else{
            newsWebView.setVisible(true);
        }

    }

    public void loadGeneralNews(MouseEvent mouseEvent) {

        if (currentJSON != generalElection)
        {
            newsTitle.setText("General Presidential Election News 2020");
            currentJSON = generalElection;
            updateNews();
        }
    }


    public void loadBidenNews(MouseEvent mouseEvent)
    {
        if (currentJSON != joeBiden)
        {
            newsTitle.setText("Joe Biden Election News 2020");
            currentJSON = joeBiden;
            updateNews();
        }
    }

    public void loadTrumpNews(MouseEvent mouseEvent)
    {
        if (currentJSON != donaldTrump)
        {
            newsTitle.setText("Donald Trump Election News 2020");
            currentJSON = donaldTrump;
            updateNews();
        }

    }

    public void openLabel00(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(0) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(0));
        }
    }

    public void openLabel01(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(1) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(1));
        }
    }

    public void openLabel02(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(2) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(2));
        }
    }

    public void openLabel03(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(3) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(3));
        }
    }

    public void openLabel04(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(4) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(4));
        }
    }

    public void openLabel05(MouseEvent mouseEvent) {

        if (currentJSON.getImgURL(5) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(5));
        }
    }

    public void openLabel06(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(6) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(6));
        }
    }

    public void openLabel07(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(7) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(7));
        }
    }

    public void openLabel08(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(8) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(8));
        }
    }

    public void openLabel09(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(9) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(9));
        }
    }

    public void openLabel10(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(10) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(10));
        }
    }

    public void openLabel11(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(11) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(11));
        }
    }

    public void openLabel12(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(12) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(12));
        }
    }

    public void openLabel13(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(13) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(13));
        }
    }

    public void openLabel14(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(14) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(14));
        }
    }

    public void openLabel15(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(15) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(15));
        }
    }

    public void openLabel16(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(16) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(16));
        }
    }

    public void openLabel17(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(17) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(17));
        }
    }

    public void openLabel18(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(18) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(18));
        }
    }

    public void openLabel19(MouseEvent mouseEvent) {
        if (currentJSON.getImgURL(19) != null)
        {
            newsWebView.setVisible(true);
            WebEngine engine = newsWebView.getEngine();
            engine.load(currentJSON.getURL(19));
        }
    }
}