package data;

import org.json.simple.JSONObject;

import java.util.Map;

public class Player
{
    private final String webName;
    private final Team team;
    private final int cost;
    private final Map<Integer, Fixture> fixtures;

    public Player(JSONObject playerJson)
    {
        webName = (String) playerJson.get("web_name");
        team = Team.fromTeamId(((Long) playerJson.get("team_id")).intValue());
        cost = ((Long) playerJson.get("now_cost")).intValue();
        fixtures = Fixture.parseFixtures((JSONObject) playerJson.get("fixtures"));
    }

    public String getWebName()
    {
        return webName;
    }

    public Team getTeam()
    {
        return team;
    }

    public int getCost()
    {
        return cost;
    }

    public Map<Integer, Fixture> getFixtures()
    {
        return fixtures;
    }
}
