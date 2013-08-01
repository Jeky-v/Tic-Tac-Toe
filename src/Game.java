public class Game
{
    private Field field;
    private Player player1;
    private Player player2;

    public Game()
    {
        field = new Field();
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
    }
    private boolean checkWin()
    {
        return false;
    }
    public void startGame()
    {
        field.showField();
    }
    public void showHistory()
    {

    }
}
