package scraper;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Jonny on 07/11/15.
 */
public class Scraper {

    public Scraper(TabPane tabPane) {
        initialiseTab(tabPane);
    }

    private void initialiseTab(TabPane tabPane) {
        Tab tab = new Tab();
        tab.setText("Scraper");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Scraper"));
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
        Thread scraperThread = new Thread(() -> {
            int playerIndex = 1;

            while (true) {
                try {
                    String playerString = readPlayerUrl(playerIndex);
                    JSONObject playerJson = new JSONObject(playerString);
                } catch (Exception e) {
                    break;
                }
                playerIndex++;
            }
        });

        scraperThread.start();
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
