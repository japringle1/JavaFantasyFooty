package main;

import data.PlayerRepository;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scraper.ScraperController;

public class Main extends Application {

    private ScraperController scraperController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Fantasy Premier League Assistant");
        Group root = new Group();
        Scene scene = new Scene(root, 750, 750, Color.ALICEBLUE);
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();

        addMainTab(tabPane);
        PlayerRepository playerRepository = new PlayerRepository();
        addScraperTab(tabPane, playerRepository);

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addMainTab(TabPane tabPane) {
        Tab tab = new Tab();
        tab.setText("Main");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Fantasy Football Assistant"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);
        tabPane.getTabs().add(tab);
    }

    private void addScraperTab(TabPane tabPane, PlayerRepository playerRepository) {
        scraperController = new ScraperController(tabPane, playerRepository);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
