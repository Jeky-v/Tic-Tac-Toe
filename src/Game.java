import java.util.ArrayList;


public class Game
{
    private static final String ERROR_MASSAGE = "Incorrect Input !";
    private static final int DEFAULT_NCELLS_TO_WIN = 3;
    private static final int DEFAULT_FIELD_SIZE = 3;
    private static int numberCellsToWin;
    private Field field;
    private Player player1;
    private Player player2;
    private ArrayList<Stroke> history;

    public Game()
    {
        this(new HumanPlayer(), new HumanPlayer(), DEFAULT_FIELD_SIZE , DEFAULT_NCELLS_TO_WIN);
    }
    public Game(Player newPlayer1, Player newPlayer2,int newFieldSize, int newNumberCellsToWin)
    {
        if(newPlayer1 != null && newPlayer2 != null)
        {
            player1 = newPlayer1;
            player2 = newPlayer2;
        }
        else
        {
            System.out.print("Game constructor error");
        }
        field = new Field(newFieldSize);
        field.eraseField();
        history = new ArrayList<Stroke>();
        numberCellsToWin = newNumberCellsToWin;
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
        if(j - i - 1 >= numberCellsToWin)
        {
            return true;
        }
        //checking of columns
        for(i = x; i >= 0 && field.getField()[i][y] == stroke.gameChar; i--);
        for(j = x; j < size && field.getField()[j][y] == stroke.gameChar; j++);
        if(j - i - 1 >= numberCellsToWin)
        {
            return true;
        }
        //checking of primary diagonals
        for(i = 1; x - i >= 0 && y - i >= 0 && field.getField()[x - i][y - i] == stroke.gameChar; i++);
        for(j = 1; x + j < size && y + j < size && field.getField()[x + j][y + j] == stroke.gameChar; j++);
        if(j + i - 1 >= numberCellsToWin)
        {
            return true;
        }
        //checking of secondary diagonal
        for(i = 1; x + i < size && y - i >= 0 && field.getField()[x + i][y - i] == stroke.gameChar; i++);
        for(j = 1; x - j >=0 && y + j < size && field.getField()[x - j][y + j] == stroke.gameChar; j++);
        if(j + i - 1 >= numberCellsToWin)
        {
            return true;
        }
        return false;
    }
    public void startGame()
    {
        field.showField();
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
