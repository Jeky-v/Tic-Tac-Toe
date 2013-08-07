import java.util.Random;

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
    public boolean makeStroke(Field field)
    {
        System.out.print("Computer made turn: ");
        switch(complexityLevel)
        {
            case EASY:
            {
                Random rand = new Random();
                int x = 0,y = 0;
                boolean run = true;
                while(run)
                {
                    x = rand.nextInt(field.getFieldSize());
                    y = rand.nextInt(field.getFieldSize());
                    run = !field.setTurn(x, y, gameChar);
                }
                System.out.println(x + " " + y);
                break;
            }
            case MEDIUM:
            {

                break;
            }
            case HARD:
            {

                break;
            }
        }
        return true;
    }
}
