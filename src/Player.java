public class Player
{
    private static final String DEFAULT_NAME = "Player";
    String name;
    public Player()
    {
        this(DEFAULT_NAME);
    }
    public Player(String newName)
    {
        name = newName;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return  name;
    }
}
