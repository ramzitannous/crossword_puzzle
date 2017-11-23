package ui;

import crossword.Const;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
        private static Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;
        try {
            AnchorPane root= FXMLLoader.load(getClass().getResource(Const.menu));
            Scene scene=new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setTitle(Const.stageTitle);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getIcons().add(new Image("ui/icon.ico"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(String fx){
        AnchorPane root= null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fx));
            Scene scene=new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
