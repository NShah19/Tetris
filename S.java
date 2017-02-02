import java.util.*;
import sacco.gui.*;
import sacco.*;

public class S extends TetrisPiece
{
    public S(TetrisGrid grid)
    {
        super(grid,new Color(102,205,0),new Location(2,3),3);
        
    }

    public void setInitialLocations()
    {
        Location one=new Location(1,1);
        Location two=new Location(1,2);
        Location three=new Location(2,0);
        Location four=new Location(2,1);
        
       
        getBlocks().add(new PieceBlock(this,one));
        getBlocks().add(new PieceBlock(this,two));
        getBlocks().add(new PieceBlock(this,three));
        getBlocks().add(new PieceBlock(this,four));

    }

}