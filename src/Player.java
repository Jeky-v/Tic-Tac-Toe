public abstract class Player
{
    private static final String DEFAULT_NAME = "Player";
    private static final char DEFAULT_GAME_CHAR = 'X';
    protected char gameChar;
    String name;

    public Player()
    {
        this(DEFAULT_NAME, DEFAULT_GAME_CHAR);
    }
    public Player(String newName, char newGameChar)
    {
        name = newName;
        gameChar = newGameChar;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return  name;
    }
    public void setGameChar(char newGameChar)
    {
        if(newGameChar == 'X' || newGameChar == '0')
        {
            gameChar = newGameChar;
        }
    }
    public char getGameChar()
    {
        return gameChar;
    }
    public abstract boolean makeStroke(Field field);
}
