package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest
{
    public static final String AGUERO_JSON =
            "{" +
                    "\"id\":222," +
                    "\"photo\":\"37572.jpg\"," +
                    "\"web_name\":\"AgÃ¼ero\"," +
                    "\"event_explain\":[[\"Bonus\",3,3],[\"Penalties missed\",1,-2],[\"Minutes played\",90,2],[\"Goals scored\",2,8]]," +
                    "\"fixture_history\":{\"all\":[" +
                    "[\"10 Aug 20:00\",1,\"WBA(A) 3-0\",28,0,0,0,0,0,0,0,0,0,0,0,9,-2,0,130,1]," +
                    "[\"16 Aug 16:00\",2,\"CHE(H) 3-0\",82,1,0,1,0,0,0,0,0,0,0,0,46,26,24104,130,6]," +
                    "[\"23 Aug 16:00\",3,\"EVE(A) 2-0\",80,0,0,1,0,0,0,0,0,0,0,0,25,2,345046,131,2]," +
                    "[\"29 Aug 15:00\",4,\"WAT(H) 2-0\",90,0,0,1,0,0,0,0,0,0,0,0,8,-2,185300,132,2]," +
                    "[\"12 Sep 15:00\",5,\"CRY(A) 1-0\",24,0,0,0,0,0,0,0,0,0,0,0,5,-2,48499,132,1]," +
                    "[\"19 Sep 17:30\",6,\"WHU(H) 1-2\",90,0,1,0,2,0,0,0,0,0,0,0,8,2,-62365,132,5]," +
                    "[\"26 Sep 12:45\",7,\"TOT(A) 1-4\",85,0,0,0,4,0,0,0,0,0,0,0,10,1,3468,132,2]," +
                    "[\"03 Oct 15:00\",8,\"NEW(H) 6-1\",65,5,0,0,1,0,0,0,0,0,0,3,91,121,-11551,132,25]," +
                    "[\"17 Oct 15:00\",9,\"BOU(H) 5-1\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,-463069,132,0]," +
                    "[\"25 Oct 14:05\",10,\"MUN(A) 0-0\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,-178130,131,0]," +
                    "[\"31 Oct 15:00\",11,\"NOR(H) 2-1\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,-58163,131,0]," +
                    "[\"08 Nov 13:30\",12,\"AVL(A) 0-0\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,-28747,130,0]," +
                    "[\"21 Nov 17:30\",13,\"LIV(H) 1-4\",65,1,0,0,3,0,0,0,0,0,0,0,29,26,57479,130,6]," +
                    "[\"28 Nov 15:00\",14,\"SOU(H) 3-1\",63,0,0,0,1,0,0,0,0,0,0,0,16,0,148338,131,2]," +
                    "[\"05 Dec 12:45\",15,\"STK(A) 0-2\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,-116163,131,0]," +
                    "[\"12 Dec 15:00\",16,\"SWA(H) 2-1\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,-64234,130,0]," +
                    "[\"21 Dec 20:00\",17,\"ARS(A) 1-2\",62,0,0,0,2,0,0,0,0,0,0,0,14,3,3409,130,2]," +
                    "[\"26 Dec 15:00\",18,\"SUN(H) 4-1\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,77448,131,0]," +
                    "[\"29 Dec 19:45\",19,\"LEI(A) 0-0\",63,0,0,1,0,0,0,0,0,0,0,0,-6,0,-8392,131,2]," +
                    "[\"02 Jan 17:30\",20,\"WAT(A) 2-1\",85,1,0,0,1,0,0,0,0,0,0,3,29,33,-10056,131,9]," +
                    "[\"13 Jan 19:45\",21,\"EVE(H) 0-0\",90,0,0,1,0,0,0,0,0,0,0,0,18,-4,120127,132,2]," +
                    "[\"16 Jan 15:00\",22,\"CRY(H) 4-0\",84,2,1,1,0,0,0,0,0,0,0,3,51,61,34176,132,16]," +
                    "[\"23 Jan 17:30\",23,\"WHU(A) 2-2\",90,2,0,0,2,0,0,0,0,0,0,2,46,50,173308,133,12]," +
                    "[\"02 Feb 19:45\",24,\"SUN(A) 1-0\",90,1,0,1,0,0,0,0,1,0,0,0,39,21,264697,135,5]," +
                    "[\"06 Feb 12:45\",25,\"LEI(H) 1-3\",90,1,0,0,3,0,0,0,0,0,0,0,32,17,78680,136,6]," +
                    "[\"14 Feb 16:15\",26,\"TOT(H) 1-2\",90,0,0,0,2,0,0,0,0,0,0,0,-4,-10,1719,136,2]," +
                    "[\"02 Mar 20:00\",28,\"LIV(A) 0-3\",90,0,0,0,3,0,0,0,0,0,0,0,13,1,28597,134,2]," +
                    "[\"05 Mar 15:00\",29,\"AVL(H) 4-0\",90,2,0,1,0,0,0,1,0,0,0,3,50,44,138603,135,11]]," +
                    "\"summary\":[[26,\"TOT (H)\",2],[28,\"LIV (A)\",2],[29,\"AVL (H)\",11]]}," +
                    "\"season_history\":[" +
                    "[\"2011/12\",2576,23,9,18,18,0,0,0,2,0,0,30,647,0,114,211]," +
                    "[\"2012/13\",1944,12,3,10,20,0,0,0,2,0,0,16,391,0,111,121]," +
                    "[\"2013/14\",1528,17,11,9,13,0,0,1,4,0,0,22,667,176,126,156]," +
                    "[\"2014/15\",2532,26,10,9,31,0,0,1,4,0,0,27,915,831,129,216]]," +
                    "\"fixtures\":{\"all\":[" +
                    "[\"12 Mar 12:45\",\"Gameweek 30\",\"Norwich (A)\"]," +
                    "[\"20 Mar 16:00\",\"Gameweek 31\",\"Man Utd (H)\"]," +
                    "[\"02 Apr 15:00\",\"Gameweek 32\",\"Bournemouth (A)\"]," +
                    "[\"09 Apr 17:30\",\"Gameweek 33\",\"West Brom (H)\"]," +
                    "[\"16 Apr 17:30\",\"Gameweek 34\",\"Chelsea (A)\"]," +
                    "[\"24 Apr 12:00\",\"Gameweek 35\",\"Stoke (H)\"]," +
                    "[\"01 May 16:00\",\"Gameweek 36\",\"Southampton (A)\"]," +
                    "[\"07 May 15:00\",\"Gameweek 37\",\"Arsenal (H)\"]," +
                    "[\"15 May 15:00\",\"Gameweek 38\",\"Swansea (A)\"]]," +
                    "\"summary\":[[30,\"NOR (A)\",\"12 Mar 12:45\"],[31,\"MUN (H)\",\"20 Mar 16:00\"],[32,\"BOU (A)\",\"02 Apr 15:00\"]]}," +
                    "\"event_total\":11," +
                    "\"type_name\":\"Forward\"," +
                    "\"team_name\":\"Man City\"," +
                    "\"selected_by\":\"32.5\"," +
                    "\"total_points\":121," +
                    "\"current_fixture\":\"Aston Villa (H)\"," +
                    "\"next_fixture\":\"Norwich (A)\"," +
                    "\"team_code\":43," +
                    "\"news\":\"\"," +
                    "\"team_id\":9," +
                    "\"status\":\"a\"," +
                    "\"code\":37572," +
                    "\"first_name\":\"Sergio\"," +
                    "\"second_name\":\"AgÃ¼ero\"," +
                    "\"now_cost\":136," +
                    "\"chance_of_playing_this_round\":100," +
                    "\"chance_of_playing_next_round\":100," +
                    "\"value_form\":\"0.4\"," +
                    "\"value_season\":\"9.0\"," +
                    "\"cost_change_start\":6," +
                    "\"cost_change_event\":1," +
                    "\"cost_change_start_fall\":-6," +
                    "\"cost_change_event_fall\":-1," +
                    "\"in_dreamteam\":false," +
                    "\"dreamteam_count\":4," +
                    "\"selected_by_percent\":\"32.5\"," +
                    "\"form\":\"5.0\"," +
                    "\"transfers_out\":1631237," +
                    "\"transfers_in\":2224278," +
                    "\"transfers_out_event\":735," +
                    "\"transfers_in_event\":35580," +
                    "\"loans_in\":0," +
                    "\"loans_out\":0," +
                    "\"loaned_in\":0," +
                    "\"loaned_out\":0," +
                    "\"event_points\":11," +
                    "\"points_per_game\":\"5.8\"," +
                    "\"ep_this\":\"5.0\"," +
                    "\"ep_next\":\"5.0\"," +
                    "\"special\":false," +
                    "\"minutes\":1596," +
                    "\"goals_scored\":16," +
                    "\"assists\":2," +
                    "\"clean_sheets\":8," +
                    "\"goals_conceded\":24," +
                    "\"own_goals\":0," +
                    "\"penalties_saved\":0," +
                    "\"penalties_missed\":1," +
                    "\"yellow_cards\":1," +
                    "\"red_cards\":0," +
                    "\"saves\":0," +
                    "\"bonus\":14," +
                    "\"ea_index\":529," +
                    "\"bps\":388," +
                    "\"element_type\":4," +
                    "\"team\":9}";

    Player player;

    @Before
    public void parseJson() throws Exception
    {
        JSONObject playerJson = (JSONObject) new JSONParser().parse(AGUERO_JSON);
        player = new Player(playerJson);
    }

    @Test
    public void givenAgueroJson_whenParsed_thenNameIsAguero() throws Exception
    {
        assertThat(player.getWebName()).isEqualTo("AgÃ¼ero");
    }

    @Test
    public void givenAgueroJson_whenParsed_thenTeamIsManCity() throws Exception
    {
        assertThat(player.getTeam()).isEqualTo(Team.MAN_CITY);
    }

    @Test
    public void givenAgueroJson_whenParsed_thenCostIs136() throws Exception
    {
        assertThat(player.getCost()).isEqualTo(136);
    }

    @Test
    public void givenAgueroJson_whenParsed_thenFixtureListCorrect() throws Exception
    {
//        assertThat(player.getFixtures())
    }
}