enum ComplexityLevel
{
    EASY,
    MEDIUM,
    HARD
}

public class ComputerPlayer extends Player
{
    private static final String DEFAULT_COMPUTER_NAME = "Computer";
    private static final char DEFAULT_COMPUTER_CHAR = '0';
    private static final ComplexityLevel DEFAULT_COMPLEXITY_LEVEL = ComplexityLevel.EASY;
    private ComplexityLevel complexityLevel;

    public ComputerPlayer()
    {
        super(DEFAULT_COMPUTER_NAME,DEFAULT_COMPUTER_CHAR);
        complexityLevel = DEFAULT_COMPLEXITY_LEVEL;
    }
    public ComputerPlayer(String newName, ComplexityLevel newComplexityLevel, char newGameChar)
    {
        super(newName, newGameChar);
        complexityLevel = newComplexityLevel;
    }
    public void setComplexityLevel(ComplexityLevel newComplexityLevel)
    {
        complexityLevel = newComplexityLevel;
    }
    public ComplexityLevel getComplexityLevel()
    {
        return complexityLevel;
    }
    public boolean makeStroke(Field field)
    {
        System.out.println("Computer made turn");
        return true;
    }
}
