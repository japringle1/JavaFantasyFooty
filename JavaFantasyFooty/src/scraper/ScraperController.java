package scraper;

import data.Player;
import data.PlayerRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ScraperController
{
    private Task scraperWorker;

    private final PlayerRepository playerRepository;
    private ProgressIndicator progressBar;
    private Button scrapeButton;
    private Button cancelButton;
    private final ObservableList<Player> players;

    public ScraperController(TabPane tabPane, PlayerRepository playerRepository)
    {
        this.playerRepository = playerRepository;
        players = FXCollections.observableArrayList();
        initialiseTab(tabPane);
    }

    private void initialiseTab(TabPane tabPane)
    {
        Tab tab = new Tab();
        tab.setText("Scraper");
        tabPane.getTabs().add(tab);

        GridPane scraperPane = new GridPane();
        scraperPane.setHgap(5);
        scraperPane.setVgap(20);
        scraperPane.setAlignment(Pos.CENTER);
        tab.setContent(scraperPane);

        TableView<Player> playersTable = new TableView<>(players);
        playersTable.setPrefWidth(500);
        TableColumn playerNameCol = new TableColumn("Name");
        TableColumn teamCol = new TableColumn("Team");
        playersTable.getColumns().addAll(playerNameCol, teamCol);

        scraperPane.add(playersTable, 0, 0);
        createScraperButton();
        createCancelButton();
        HBox buttonsBox = new HBox(scrapeButton, cancelButton);
        buttonsBox.setSpacing(5);
        buttonsBox.setAlignment(Pos.CENTER);
        scraperPane.add(buttonsBox, 0, 1);

        progressBar = new ProgressIndicator();
        progressBar.setVisible(false);

        GridPane.setHalignment(progressBar, HPos.CENTER);
        scraperPane.add(progressBar, 0, 2);
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
        cancelButton.setDisable(true);

        cancelButton.setOnAction(event -> {
            scrapeButton.setDisable(false);
            cancelButton.setDisable(true);

            scraperWorker.cancel(true);
        });
    }

    private Task createWorker()
    {
        return new Task<Void>()
        {
            @Override
            protected Void call() throws Exception
            {
                progressBar.setVisible(true);
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
                        players.add(new Player(playerJson));
                        System.out.println(playerJson);
                    } catch (Exception e)
                    {
                        break;
                    }
                    playerIndex++;
                }
                progressBar.setVisible(false);
                return null;
            }
        };
    }

    private String readPlayerUrl(int playerIndex) throws IOException
    {
        URL url = new URL("http://fantasy.premierleague.com/web/api/elements/" + playerIndex + "/");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
        {
            buffer.append(chars, 0, read);
        }

        return buffer.toString();
    }
}
