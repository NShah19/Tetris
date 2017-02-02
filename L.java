import java.util.*;
import sacco.gui.*;
import sacco.*;

public class L extends TetrisPiece
{
    public L(TetrisGrid grid)
    {
        super(grid,new Color(0,104,139),new Location(2,3),3);
        
    }

    public void setInitialLocations()
    {
        Location one=new Location(1,0);
        Location two=new Location(1,1);
        Location three=new Location(1,2);
        Location four=new Location(2,0);
        
       
        getBlocks().add(new PieceBlock(this,one));
        getBlocks().add(new PieceBlock(this,two));
        getBlocks().add(new PieceBlock(this,three));
        getBlocks().add(new PieceBlock(this,four));

    }

}