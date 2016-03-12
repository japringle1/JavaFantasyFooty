package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fixture
{
    private static final Pattern FIXTURE_DETAIL_PATTERN = Pattern.compile("([A-Za-z]+) \\((H|A)\\)");
    private static final Pattern GAMEWEEK_PATTERN = Pattern.compile("Gameweek ([0-9]+)");

    private Team opposition;
    private final HomeAway homeAway;

    public Fixture(Team opposition, HomeAway homeAway)
    {
        this.opposition = opposition;
        this.homeAway = homeAway;
    }

    public static Map<Integer, Fixture> parseFixtures(JSONObject fixturesObject)
    {
        JSONArray jsonFixtures = (JSONArray) fixturesObject.get("all");

        Map<Integer, Fixture> fixtureMap = new HashMap<>();
        for (Object jsonFixture : jsonFixtures)
        {
            fixtureMap.put(getGameweek((JSONArray) jsonFixture), parseFixture((JSONArray) jsonFixture));
        }

        return fixtureMap;
    }

    private static Integer getGameweek(JSONArray fixture)
    {
        String gameweekString = (String) fixture.get(1);
        Matcher gameweekMatcher = GAMEWEEK_PATTERN.matcher(gameweekString);

        if (gameweekMatcher.matches())
        {
            return Integer.parseInt(gameweekMatcher.group(1));
        }

        return null;
    }

    private static Fixture parseFixture(JSONArray fixture)
    {
        FixtureDetails fixtureDetails = FixtureDetails.parseFixtureDetails((String) fixture.get(2));
        return new Fixture(
                fixtureDetails.opposition,
                fixtureDetails.homeAway
        );
    }

    public Team getOpposition()
    {
        return opposition;
    }

    public HomeAway getHomeAway()
    {
        return homeAway;
    }

    private static class FixtureDetails
    {
        private Team opposition;
        private HomeAway homeAway;

        public FixtureDetails(Team opposition, HomeAway homeAway)
        {
            this.opposition = opposition;
            this.homeAway = homeAway;
        }

        public static FixtureDetails parseFixtureDetails(String fixtureDetailsString)
        {
            Matcher fixtureMatcher = FIXTURE_DETAIL_PATTERN.matcher(fixtureDetailsString);
            String teamName = null;
            String homeAwayString = null;

            if (fixtureMatcher.matches())
            {
                teamName = fixtureMatcher.group(1);
                homeAwayString = fixtureMatcher.group(2);
            }

            return new FixtureDetails(Team.fromLongName(teamName), HomeAway.homeOrAway(homeAwayString));
        }
    }
}
