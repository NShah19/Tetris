import java.util.*;
import sacco.gui.*;
import sacco.*;

public class T extends TetrisPiece
{
    public T (TetrisGrid grid)
    {
        super(grid,new Color(199,21,133),new Location(2,3),3);
        
    }

    public void setInitialLocations()
    {
        Location one=new Location(1,0);
        Location two=new Location(1,1);
        Location three=new Location(1,2);
        Location four=new Location(2,1);
        
       
        getBlocks().add(new PieceBlock(this,one));
        getBlocks().add(new PieceBlock(this,two));
        getBlocks().add(new PieceBlock(this,three));
        getBlocks().add(new PieceBlock(this,four));

    }

}