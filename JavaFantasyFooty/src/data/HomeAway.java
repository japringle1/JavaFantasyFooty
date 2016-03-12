package data;

public enum HomeAway
{
    HOME,
    AWAY;

    public static HomeAway homeOrAway(String s)
    {
        if ("H".equals(s))
        {
            return HOME;
        }
        else if ("A".equals(s))
        {
            return AWAY;
        }
        else
        {
            return null;
        }
    }
}
