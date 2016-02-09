package scraper;

import data.PlayerRepository;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ScraperController
{
    static Task scraperWorker;

    private final PlayerRepository playerRepository;
    private final ProgressBar progressBar;
    private Button scrapeButton;
    private Button cancelButton;

    public ScraperController(TabPane tabPane, PlayerRepository playerRepository)
    {
        this.playerRepository = playerRepository;
        this.progressBar = new ProgressBar();
        initialiseTab(tabPane);
    }

    private void initialiseTab(TabPane tabPane)
    {
        Tab tab = new Tab();
        tab.setText("Scraper");
        tabPane.getTabs().add(tab);

        BorderPane mainPane = new BorderPane();
        tab.setContent(mainPane);

        HBox buttonsHBox = new HBox();
        buttonsHBox.setSpacing(5);
        buttonsHBox.setAlignment(Pos.CENTER);
        mainPane.setCenter(buttonsHBox);

        createScraperButton();
        createCancelButton();

        buttonsHBox.getChildren().addAll(scrapeButton, cancelButton, progressBar);

        HBox progressHBox = new HBox();
        progressHBox.setAlignment(Pos.CENTER);
        mainPane.setBottom(progressHBox);
        progressHBox.getChildren().add(progressBar);
    }

    private void createScraperButton()
    {
        scrapeButton = new Button("Scrape!");

        scrapeButton.setOnAction(event -> {
            scrapeButton.setDisable(true);
            cancelButton.setDisable(false);

            scraperWorker = createWorker();

            new Thread(scraperWorker).start();
        });
    }

    private void createCancelButton()
    {
        cancelButton = new Button("Cancel");

        cancelButton.setOnAction(event -> {
            scrapeButton.setDisable(false);
            cancelButton.setDisable(true);

            scraperWorker.cancel(true);
        });
    }

    private String readPlayerUrl(int playerIndex) throws IOException
    {
        URL url = new URL("http://fantasy.premierleague.com/web/api/elements/" + playerIndex + "/");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read);

        return buffer.toString();
    }

    private Task createWorker()
    {
        return new Task<Void>()
        {
            @Override
            protected Void call() throws Exception
            {
                playerRepository.clearPlayers();
                int playerIndex = 1;

                while (true)
                {
                    if (isCancelled())
                    {
                        break;
                    }
                    try
                    {
                        String playerString = readPlayerUrl(playerIndex);
                        JSONObject playerJson = (JSONObject) new JSONParser().parse(playerString);
                        playerRepository.addPlayerFromJsonObject(playerJson);
                        System.out.println(playerJson);
                    } catch (Exception e)
                    {
                        break;
                    }
                    playerIndex++;
                }
                return null;
            }
        };
    }
}
