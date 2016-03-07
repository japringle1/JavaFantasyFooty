package data;

public enum Team
{
    ARSENAL,
    ASTON_VILLA,
    BOURNEMOUTH,
    CHELSEA,
    CRYSTAL_PALACE,
    EVERTON,
    LEICESTER,
    LIVERPOOL,
    MAN_CITY,
    MAN_UNITED,
    NEWCASTLE,
    NORWICH,
    SOUTHAMPTON,
    STOKE,
    SUNDERLAND,
    SWANSEA,
    SPURS,
    WATFORD,
    WEST_BROM,
    WEST_HAM;

    public static Team fromTeamId(int id)
    {
        switch (id)
        {
            case 1:
                return ARSENAL;
            case 2:
                return ASTON_VILLA;
            case 3:
                return BOURNEMOUTH;
            case 4:
                return CHELSEA;
            case 5:
                return CRYSTAL_PALACE;
            case 6:
                return EVERTON;
            case 7:
                return LEICESTER;
            case 8:
                return LIVERPOOL;
            case 9:
                return MAN_CITY;
            case 10:
                return MAN_UNITED;
            case 11:
                return NEWCASTLE;
            case 12:
                return NORWICH;
            case 13:
                return SOUTHAMPTON;
            case 14:
                return STOKE;
            case 15:
                return SUNDERLAND;
            case 16:
                return SWANSEA;
            case 17:
                return SPURS;
            case 18:
                return WATFORD;
            case 19:
                return WEST_BROM;
            case 20:
                return WEST_HAM;
            default:
                return null;
        }
    }
}
