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

    public TeamTest(Team team, int teamId)
    {
        this.team = team;
        this.teamId = teamId;
    }

    @Parameterized.Parameters(name = "{1}: {0}")
    public static Collection teams()
    {
        return Arrays.asList(new Object[][]{
                {Team.ARSENAL, 1},
                {Team.ASTON_VILLA, 2},
                {Team.BOURNEMOUTH, 3},
                {Team.CHELSEA, 4},
                {Team.CRYSTAL_PALACE, 5},
                {Team.EVERTON, 6},
                {Team.LEICESTER, 7},
                {Team.LIVERPOOL, 8},
                {Team.MAN_CITY, 9},
                {Team.MAN_UNITED, 10},
                {Team.NEWCASTLE, 11},
                {Team.NORWICH, 12},
                {Team.SOUTHAMPTON, 13},
                {Team.STOKE, 14},
                {Team.SUNDERLAND, 15},
                {Team.SWANSEA, 16},
                {Team.SPURS, 17},
                {Team.WATFORD, 18},
                {Team.WEST_BROM, 19},
                {Team.WEST_HAM, 20}
        });
    }

    @Test
    public void testFromTeamId() throws Exception
    {
        assertThat(Team.fromTeamId(teamId)).isEqualTo(team);
    }
}