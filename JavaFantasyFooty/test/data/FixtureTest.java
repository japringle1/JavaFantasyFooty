package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static data.HomeAway.AWAY;
import static data.Team.NORWICH;
import static org.assertj.core.api.Assertions.assertThat;

public class FixtureTest
{
    private static final String FIXTURE_JSON = "{\"all\":[[\"12 Mar 12:45\",\"Gameweek 30\",\"Norwich (A)\"]]}";

    Map<Integer, Fixture> fixtures;

    @Before
    public void setUp() throws Exception
    {
        JSONObject fixtureObject = (JSONObject) new JSONParser().parse(FIXTURE_JSON);
        fixtures = Fixture.parseFixtures(fixtureObject);
    }

    @Test
    public void givenFixtureJson_whenParsed_thenListCreatedCorrectly() throws Exception
    {
        assertThat(fixtures).hasSize(1);

        assertThat(fixtures.keySet()).containsExactly(30);
    }

    @Test
    public void givenFixtureJson_whenParsed_thenOppositionIsNorwich() throws Exception
    {
        assertThat(fixtures.get(30).getOpposition()).isEqualTo(NORWICH);
    }

    @Test
    public void givenFixtureJson_whenParsed_thenHomeAwayIsAway() throws Exception
    {
        assertThat(fixtures.get(30).getHomeAway()).isEqualTo(AWAY);
    }
}