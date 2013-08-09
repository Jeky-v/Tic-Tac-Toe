import java.util.Scanner;

public class Main
{
    private static final String ERROR_MASSAGE = "Incorrect Input !";
    private static Scanner input = new Scanner(System.in);
    public static void main(String args[])
    {
        Game game = null;

        System.out.println("Hello! It's Tic Tac Toe Game!");

        boolean menuRun = true;
        while(menuRun)
        {
            System.out.println("Please, select one of the menu items:");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.println("3. Show game history");
            System.out.println("4. Exit");
            System.out.print("I'm choosing: ");
            if(input.hasNextInt())
            {
                switch(input.nextInt())
                {
                    case 1:
                    {
                        game = new Game(new HumanPlayer("Human1",'X'), new HumanPlayer("Human2", '0'), 3, 3);
                        System.out.println("The Game started !");
                        game.startGame();
                        break;
                    }
                    case 2:
                    {
                        game = new Game(new HumanPlayer("Human1", 'X'), new ComputerPlayer("Computer1", ComplexityLevel.EASY, '0'), 3, 3);
                        System.out.println("The Game started !");
                        game.startGame();
                        break;
                    }
                    case 3:
                    {
                        if(game != null)
                        {
                            game.showHistory();
                        }
                        else
                        {
                            System.out.println("No any history, maybe it's first game.");
                        }
                        break;
                    }
                    case 4:
                    {
                        menuRun = false;
                        break;
                    }
                    default:
                    {
                        System.out.println(ERROR_MASSAGE);
                        break;
                    }
                }
            }
            else
            {
                System.out.println(ERROR_MASSAGE);
            }
        }
    }
}
