package data;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private final List<Player> players = new ArrayList<>();

    public void addPlayerFromJsonObject(JSONObject playerJson) {
        players.add(new Player(playerJson));
    }

    public void clearPlayers()
    {
        players.clear();
    }
}
