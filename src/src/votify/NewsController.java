package votify;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public ImageView trumpImage;
    public ImageView bidenImage;

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

    private ImageView[] newsButtons = new ImageView[20];

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
    }

    private void updateNews()
    {
        for (int i = 0; i < newsButtons.length; i++)
        {
            if (currentJSON.getImgURL(i) != null)
            {
                newsButtons[i].setImage(new Image(currentJSON.getImgURL(i)));
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newsWebView.setVisible(false);

        // ToDo: set 20 images. refresh 20 images. per candidate. sorting by bias

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
        currentJSON = generalElection;
        updateNews();
        updateNews();
    }


    public void loadBidenNews(MouseEvent mouseEvent)
    {
        currentJSON = joeBiden;
        updateNews();
    }

    public void loadTrumpNews(MouseEvent mouseEvent)
    {
        currentJSON = donaldTrump;
        updateNews();
    }


    public void openNews00(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(0) != null)
        {
            engine.load(currentJSON.getURL(0));
        }

    }


    public void openNews01(MouseEvent mouseEvent) {

        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(1) != null)
        {
            engine.load(currentJSON.getURL(1));
        }
    }



    public void openNews02(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(2) != null)
        {
            engine.load(currentJSON.getURL(2));
        }
    }

    public void openNews03(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(3) != null)
        {
            engine.load(currentJSON.getURL(3));
        }
    }

    public void openNews04(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(4) != null)
        {
            engine.load(currentJSON.getURL(4));
        }
    }

    public void openNews05(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(5) != null)
        {
            engine.load(currentJSON.getURL(5));
        }
    }

    public void openNews06(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(6) != null)
        {
            engine.load(currentJSON.getURL(6));
        }
    }

    public void openNews07(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(7) != null)
        {
            engine.load(currentJSON.getURL(7));
        }
    }

    public void openNews08(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(8) != null)
        {
            engine.load(currentJSON.getURL(8));
        }
    }

    public void openNews09(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(9) != null)
        {
            engine.load(currentJSON.getURL(9));
        }
    }

    public void openNews10(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(10) != null)
        {
            engine.load(currentJSON.getURL(10));
        }
    }

    public void openNews11(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(11) != null)
        {
            engine.load(currentJSON.getURL(11));
        }
    }

    public void openNews12(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(12) != null)
        {
            engine.load(currentJSON.getURL(12));
        }
    }

    public void openNews13(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(13) != null)
        {
            engine.load(currentJSON.getURL(13));
        }
    }

    public void openNews14(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(14) != null)
        {
            engine.load(currentJSON.getURL(14));
        }
    }

    public void openNews15(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(15) != null)
        {
            engine.load(currentJSON.getURL(15));
        }
    }

    public void openNews16(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(16) != null)
        {
            engine.load(currentJSON.getURL(16));
        }
    }

    public void openNews17(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(17) != null)
        {
            engine.load(currentJSON.getURL(17));
        }
    }

    public void openNews18(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(18) != null)
        {
            engine.load(currentJSON.getURL(18));
        }
    }

    public void openNews19(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        if (currentJSON.getImgURL(19) != null)
        {
            engine.load(currentJSON.getURL(19));
        }
    }


}