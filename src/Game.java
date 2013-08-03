import java.util.Scanner;

public class Game
{
    private static final String ERROR_MASSAGE = "Incorrect Input !";
    private static Scanner input = new Scanner(System.in);
    private Field field;
    private Player player1;
    private Player player2;

    private boolean checkWin()
    {
        return false;
    }
    public Game()
    {
    }
    public void startGame()
    {
        boolean run = true;

        System.out.println("Hello! It's Tic Tac Toe Game!");
        System.out.println("Please, choose one of the next game modes:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.print("I'm choosing: ");
        if(input.hasNextInt())
        {
            switch(input.nextInt())
            {
                case 1:
                {
                    player1 = new HumanPlayer();
                    player2 = new HumanPlayer();
                    break;
                }
                case 2:
                {
                    player1 = new HumanPlayer();
                    player2 = new ComputerPlayer();
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

        field = new Field();
        field.eraseField();
        System.out.println("The Game started !");
        field.showField();
        while(run)
        {
            while(!player1.makeStroke(field))
            {
                System.out.println(ERROR_MASSAGE);
            }
            field.showField();

            while(!player2.makeStroke(field))
            {
                System.out.println(ERROR_MASSAGE);
            }
            field.showField();

            if(checkWin())
            {
                run = false;
            }
        }
    }
    public void showHistory()
    {

    }
}
