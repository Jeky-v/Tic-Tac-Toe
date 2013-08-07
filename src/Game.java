import java.util.ArrayList;
import java.util.Scanner;


public class Game
{
    private static final String ERROR_MASSAGE = "Incorrect Input !";
    private static final int DEFAULT_NCELLS_TO_WIN = 3;
    private static Scanner input = new Scanner(System.in);
    private static int numberCellToWin;
    private Field field;
    private Player player1;
    private Player player2;
    private ArrayList<Stroke> history;

    private void gameLoop()
    {
        boolean firstPlayer = true;
        Player currentPlayer;
        while(field.isAnyEmptyCells())
        {
            if(firstPlayer)
            {
                currentPlayer = player1;
            }
            else
            {
                currentPlayer = player2;
            }
            while(!currentPlayer.makeStroke(field))
            {
                System.out.println(ERROR_MASSAGE);
            }
            field.showField();
            history.add(field.getLastStroke());
            if(checkWin())
            {
                System.out.println("Player " + currentPlayer.getName() + " WIN !!!");
                return;
            }
            firstPlayer = !firstPlayer;
        }
        field.showField();
        System.out.println("DRAW !");
    }
    public Game()
    {
        numberCellToWin = DEFAULT_NCELLS_TO_WIN;
    }
    private boolean checkWin()
    {
        Stroke stroke = field.getLastStroke();
        int x = stroke.x;
        int y = stroke.y;
        int size = field.getFieldSize();
        int i,j;
        //checking of lines
        for(i = y; i >= 0 && field.getField()[x][i] == stroke.gameChar; i--);
        for(j = y; j < size && field.getField()[x][j] == stroke.gameChar; j++);
        if(j - i - 1 >= numberCellToWin)
        {
            return true;
        }
        //checking of columns
        for(i = x; i >= 0 && field.getField()[i][y] == stroke.gameChar; i--);
        for(j = x; j < size && field.getField()[j][y] == stroke.gameChar; j++);
        if(j - i - 1 >= numberCellToWin)
        {
            return true;
        }
        //checking of primary diagonals
        for(i = 1; x - i >= 0 && y - i >= 0 && field.getField()[x - i][y - i] == stroke.gameChar; i++);
        for(j = 1; x + j < size && y + j < size && field.getField()[x + j][y + j] == stroke.gameChar; j++);
        if(j + i - 1 >= numberCellToWin)
        {
            return true;
        }
        //checking of secondary diagonal
        for(i = 1; x + i < size && y - i >= 0 && field.getField()[x + i][y - i] == stroke.gameChar; i++);
        for(j = 1; x - j >=0 && y + j < size && field.getField()[x - j][y + j] == stroke.gameChar; j++);
        if(j + i - 1 >= numberCellToWin)
        {
            return true;
        }
        return false;
    }
    public void startGame()
    {
        boolean run = true;

        System.out.println("Hello! It's Tic Tac Toe Game!");
        System.out.println("Please, choose one of the next game modes:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Exit");
        System.out.print("I'm choosing: ");

        while(run)
        {
            if(input.hasNextInt())
            {
                switch(input.nextInt())
                {
                    case 1:
                    {
                        player1 = new HumanPlayer();
                        player2 = new HumanPlayer();
                        run = false;
                        break;
                    }
                    case 2:
                    {
                        player1 = new HumanPlayer();
                        player2 = new ComputerPlayer();
                        run = false;
                        break;
                    }
                    case 3:
                    {
                        run = false;
                        return;
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
        field = new Field();
        field.eraseField();
        System.out.println("The Game started !");
        field.showField();
        history = new ArrayList<Stroke>();
        gameLoop();
    }
    public void showHistory()
    {
        System.out.println("Game History:");
        for(int i = 0; i < history.size(); i++)
        {
            System.out.print(history.get(i).x);
            System.out.print(" " + history.get(i).y + " ");
            System.out.println(history.get(i).gameChar + ";");
        }
    }
}
