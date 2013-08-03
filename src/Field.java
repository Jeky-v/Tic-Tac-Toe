public class Field
{
    private static final char DEFAULT_CELL_VALUE = ' ';
    private static final int DEFAULT_FIELD_SIZE = 3;
    private final char[][] field;
    private final int fieldSize;

    public Field()
    {
        this(DEFAULT_FIELD_SIZE);
    }
    public Field(int newFieldSize)
    {
        fieldSize = newFieldSize;
        field = new char[fieldSize][fieldSize];
    }
    public int getFieldSize()
    {
        return fieldSize;
    }
    public char[][] getField()
    {
        return field;
    }
    public void showField()
    {
        System.out.print("  ");
        for(int i = 0; i < fieldSize; i++)
        {
            System.out.print(" " + i);
        }
        System.out.println("");
        for(int i = 0; i < fieldSize; i++)
        {
            System.out.print(i + " |");
            for(int j = 0; j < fieldSize; j++)
            {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }
    public void eraseField()
    {
        for(int i = 0; i < fieldSize; i++)
        {
            for(int j = 0; j < fieldSize; j++)
            {
                field[i][j] = DEFAULT_CELL_VALUE;
            }
        }
    }
    public boolean setTurn(int x, int y, char newCellValue)
    {
        if(x >= 0 && x <= fieldSize - 1 && y >= 0 && y <= fieldSize - 1)
        {
            if(field[x][y] == DEFAULT_CELL_VALUE)
            {
                field[x][y] = newCellValue;
                return true;
            }
            else
            {
                return  false;
            }
        }
        else
        {
            return  false;
        }
    }
}
