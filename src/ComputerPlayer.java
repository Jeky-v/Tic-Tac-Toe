enum ComplexityLevel
{
    EASY,
    MEDIUM,
    HARD
}

public class ComputerPlayer extends Player
{
    private static final ComplexityLevel DEFAULT_COMPLEXITY_LEVEL = ComplexityLevel.EASY;
    private ComplexityLevel complexityLevel;

    public ComputerPlayer()
    {
        super();
        complexityLevel = DEFAULT_COMPLEXITY_LEVEL;
    }
    public ComputerPlayer(String newName, ComplexityLevel newComplexityLevel)
    {
        super(newName);
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
    public void makeTurn(Field field)
    {

    }
}
