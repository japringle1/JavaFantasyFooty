package data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class TeamTest
{
    private final int teamId;
    private final Team team;
    private final String shortName;
    private String longName;

    public TeamTest(Team team, int teamId, String shortName, String longName)
    {
        this.team = team;
        this.teamId = teamId;
        this.shortName = shortName;
        this.longName = longName;
    }

    @Parameterized.Parameters(name = "{1}: {0}")
    public static Collection teams()
    {
        return Arrays.asList(new Object[][]{
                {Team.ARSENAL, 1, "ARS", "Arsenal"},
                {Team.ASTON_VILLA, 2, "AVL", "Aston Villa"},
                {Team.BOURNEMOUTH, 3, "BOU", "Bournemouth"},
                {Team.CHELSEA, 4, "CHE", "Chelsea"},
                {Team.CRYSTAL_PALACE, 5, "CRY", "Crystal Palace"},
                {Team.EVERTON, 6, "EVE", "Everton"},
                {Team.LEICESTER, 7, "LEI", "Leicester"},
                {Team.LIVERPOOL, 8, "LIV", "Liverpool"},
                {Team.MAN_CITY, 9, "MCI", "Man City"},
                {Team.MAN_UNITED, 10, "MUN", "Man Utd"},
                {Team.NEWCASTLE, 11, "NEW", "Newcastle"},
                {Team.NORWICH, 12, "NOR", "Norwich"},
                {Team.SOUTHAMPTON, 13, "SOU", "Southampton"},
                {Team.STOKE, 14, "STK", "Stoke"},
                {Team.SUNDERLAND, 15, "SUN", "Sunderland"},
                {Team.SWANSEA, 16, "SWA", "Swansea"},
                {Team.SPURS, 17, "TOT", "Tottenham"},
                {Team.WATFORD, 18, "WAT", "Watford"},
                {Team.WEST_BROM, 19, "WBA", "West Brom"},
                {Team.WEST_HAM, 20, "WHU", "West Ham"}
        });
    }

    @Test
    public void testFromTeamId() throws Exception
    {
        assertThat(Team.fromTeamId(teamId)).isEqualTo(team);
    }

    @Test
    public void testFromShortName() throws Exception
    {
        assertThat(Team.fromShortName(shortName)).isEqualTo(team);
    }

    @Test
    public void testFromLongName() throws Exception
    {
        assertThat(Team.fromLongName(longName)).isEqualTo(team);
    }
}