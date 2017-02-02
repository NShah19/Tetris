import java.util.*;
import sacco.gui.*;
public class TetrisModel
{
    private TetrisGrid grid;
    private TetrisPiece piece;
    
    public TetrisModel()
    {
        grid=new TetrisGrid(20,10);
        newPiece();
    }
    
    public void newPiece()
    {
        TetrisPiece[] pieces= {new Z(grid), new O(grid), new S(grid), new J(grid), new T(grid), new L(grid), new I(grid)};
        piece=pieces[(int)(Math.random()*7)];
    }
    
    public TetrisGrid getGrid()
    {
        return grid;
    }
    
    public TetrisPiece getPiece()
    {
        return piece;
    }
}