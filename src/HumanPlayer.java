import java.util.Scanner;

public class HumanPlayer extends Player
{
    private static final String DEFAULT_HUMAN_NAME = "Human";
    private static final char DEFAULT_HUMAN_CHAR = 'X';
    private static Scanner input = new Scanner(System.in);

    public HumanPlayer()
    {
        super(DEFAULT_HUMAN_NAME, DEFAULT_HUMAN_CHAR);
    }
    public HumanPlayer(String newName, char newGameChar)
    {
        super(newName, newGameChar);
    }
    public boolean makeStroke(Field field)
    {
        int x,y;
        System.out.print(name + " turn: ");
        String inputLine = input.nextLine();
        String [] words = inputLine.split(" ");
        if(words.length == 2)
        {
            try
            {
                x = Integer.parseInt(words[0]);
                y = Integer.parseInt(words[1]);
            }
            catch(NumberFormatException e)
            {
                return false;
            }
            if(field.setTurn(x, y, gameChar))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
