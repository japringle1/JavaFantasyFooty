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

    public static Team fromShortName(String shortName)
    {
        if ("ARS".equals(shortName))
        {
            return ARSENAL;
        }
        else if ("AVL".equals(shortName))
        {
            return ASTON_VILLA;
        }
        else if ("BOU".equals(shortName))
        {
            return BOURNEMOUTH;
        }
        else if ("CHE".equals(shortName))
        {
            return CHELSEA;
        }
        else if ("CRY".equals(shortName))
        {
            return CRYSTAL_PALACE;
        }
        else if ("EVE".equals(shortName))
        {
            return EVERTON;
        }
        else if ("LEI".equals(shortName))
        {
            return LEICESTER;
        }
        else if ("LIV".equals(shortName))
        {
            return LIVERPOOL;
        }
        else if ("MCI".equals(shortName))
        {
            return MAN_CITY;
        }
        else if ("MUN".equals(shortName))
        {
            return MAN_UNITED;
        }
        else if ("NEW".equals(shortName))
        {
            return NEWCASTLE;
        }
        else if ("NOR".equals(shortName))
        {
            return NORWICH;
        }
        else if ("SOU".equals(shortName))
        {
            return SOUTHAMPTON;
        }
        else if ("STK".equals(shortName))
        {
            return STOKE;
        }
        else if ("SUN".equals(shortName))
        {
            return SUNDERLAND;
        }
        else if ("SWA".equals(shortName))
        {
            return SWANSEA;
        }
        else if ("TOT".equals(shortName))
        {
            return SPURS;
        }
        else if ("WAT".equals(shortName))
        {
            return WATFORD;
        }
        else if ("WBA".equals(shortName))
        {
            return WEST_BROM;
        }
        else if ("WHU".equals(shortName))
        {
            return WEST_HAM;
        }
        else
        {
            return null;
        }
    }

    public static Team fromLongName(String longName)
    {
        if ("Arsenal".equals(longName))
        {
            return ARSENAL;
        }
        else if ("Aston Villa".equals(longName))
        {
            return ASTON_VILLA;
        }
        else if ("Bournemouth".equals(longName))
        {
            return BOURNEMOUTH;
        }
        else if ("Chelsea".equals(longName))
        {
            return CHELSEA;
        }
        else if ("Crystal Palace".equals(longName))
        {
            return CRYSTAL_PALACE;
        }
        else if ("Everton".equals(longName))
        {
            return EVERTON;
        }
        else if ("Leicester".equals(longName))
        {
            return LEICESTER;
        }
        else if ("Liverpool".equals(longName))
        {
            return LIVERPOOL;
        }
        else if ("Man City".equals(longName))
        {
            return MAN_CITY;
        }
        else if ("Man Utd".equals(longName))
        {
            return MAN_UNITED;
        }
        else if ("Newcastle".equals(longName))
        {
            return NEWCASTLE;
        }
        else if ("Norwich".equals(longName))
        {
            return NORWICH;
        }
        else if ("Southampton".equals(longName))
        {
            return SOUTHAMPTON;
        }
        else if ("Stoke".equals(longName))
        {
            return STOKE;
        }
        else if ("Sunderland".equals(longName))
        {
            return SUNDERLAND;
        }
        else if ("Swansea".equals(longName))
        {
            return SWANSEA;
        }
        else if ("Tottenham".equals(longName))
        {
            return SPURS;
        }
        else if ("Watford".equals(longName))
        {
            return WATFORD;
        }
        else if ("West Brom".equals(longName))
        {
            return WEST_BROM;
        }
        else if ("West Ham".equals(longName))
        {
            return WEST_HAM;
        }
        else
        {
            return null;
        }
    }
}
