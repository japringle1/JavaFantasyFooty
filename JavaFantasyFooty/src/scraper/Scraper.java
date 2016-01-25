package scraper;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Scraper {

    public Scraper(TabPane tabPane) {
        initialiseTab(tabPane);
    }

    private void initialiseTab(TabPane tabPane) {
        Tab tab = new Tab();
        tab.setText("Scraper");
        HBox hbox = new HBox();
        addScraperButton(hbox);
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);
        tabPane.getTabs().add(tab);
    }

    private void addScraperButton(HBox hbox) {
        Button scrapeButton = new Button("Scrape!");
        hbox.getChildren().add(scrapeButton);

        scrapeButton.setOnAction(event -> startScraping());
    }

    private void startScraping() {
        Task<Void> scraperTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int playerIndex = 1;

                while (true) {
                    try {
                        String playerString = readPlayerUrl(playerIndex);
                        JSONObject playerJson = (JSONObject) new JSONParser().parse(playerString);
                        System.out.println(playerJson);
                    } catch (Exception e) {
                        break;
                    }
                    playerIndex++;
                }
                return null;
            }
        };

        new Thread(scraperTask).start();
    }

    private String readPlayerUrl(int playerIndex) throws IOException {
        URL url = new URL("http://fantasy.premierleague.com/web/api/elements/" + playerIndex + "/");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read);

        return buffer.toString();
    }
}
