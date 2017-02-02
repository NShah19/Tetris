import java.util.*;
import sacco.gui.*;
import sacco.*;

public class O extends TetrisPiece
{
    public O(TetrisGrid grid)
    {
        super(grid,new Color(238,180,34),new Location(3,4),2);
        
    }

    public void setInitialLocations()
    {
        Location one=new Location(0,0);
        Location two=new Location(0,1);
        Location three=new Location(1,0);
        Location four=new Location(1,1);
        
       
        getBlocks().add(new PieceBlock(this,one));
        getBlocks().add(new PieceBlock(this,two));
        getBlocks().add(new PieceBlock(this,three));
        getBlocks().add(new PieceBlock(this,four));

    }

}