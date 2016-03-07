package data;

import org.json.simple.JSONObject;

public class Player
{
    private String webName;
    private Team team;

    public Player(JSONObject playerJson)
    {
        webName = (String) playerJson.get("web_name");
        team = Team.fromTeamId(((Long) playerJson.get("team_id")).intValue());
    }

    public String getWebName()
    {
        return webName;
    }

    public Team getTeam()
    {
        return team;
    }
}
