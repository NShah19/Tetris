import java.util.*;
import sacco.gui.*;
import sacco.*;

public class I extends TetrisPiece
{
    public I(TetrisGrid grid)
    {
        super(grid,new Color(0,255,255),new Location(1,3),4);
        
    }

    public void setInitialLocations()
    {
        Location one=new Location(2,0);
        Location two=new Location(2,1);
        Location three=new Location(2,2);
        Location four=new Location(2,3);
        
       
        getBlocks().add(new PieceBlock(this,one));
        getBlocks().add(new PieceBlock(this,two));
        getBlocks().add(new PieceBlock(this,three));
        getBlocks().add(new PieceBlock(this,four));

    }

}