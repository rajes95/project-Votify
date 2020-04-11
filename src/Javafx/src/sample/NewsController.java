package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    public ScrollPane scrollNews;
    public ImageView news1;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newsWebView.setVisible(false);

//        Image img = new Image("--insert link here--");
//        news1.setImage(img);

    }


    public void toggleWebview(MouseEvent mouseEvent) {

        if (newsWebView.isVisible()) {
            newsWebView.setVisible(false);
        }
        else{
            newsWebView.setVisible(true);
        }

    }

    public void loadBidenNews(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        engine.load("https://www.google.com/search?q=joe+biden+news&sxsrf=ALeKk03fmUCZt2k0O_T-HI21TIXkTJVjkA:15866340" +
                "57848&source=lnms&tbm=nws&sa=X&ved=2ahUKEwjc7J-7kOHoAhUyoFsKHcKVCe0Q_AUoAXoECBMQAw&biw=1920&bih=976");
    }

    public void loadTrumpNews(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        engine.load("https://www.google.com/search?biw=1920&bih=976&tbm=nws&sxsrf=ALeKk03FvyoMdiX9SnU7DYPiTjQQt8bKfA%" +
                "3A1586634059105&ei=Sx2SXub9BZOU0PEPpOCV4AI&q=donald+trump+news&oq=donald+trump+news&gs_l=psy-ab.3..0l10." +
                "28339.31384.0.31607.18.15.3.0.0.0.147.1296.11j4.15.0....0...1c.1.64.psy-ab..3.11.760...0i13k1.0.m9ato79RTHY");
    }

    public void openNews1(MouseEvent mouseEvent) {
        newsWebView.setVisible(true);
        WebEngine engine = newsWebView.getEngine();
        engine.load("https://news.google.com/topstories?");
    }
}