import java.util.*;
import sacco.gui.*;
import sacco.*;
public class TetrisPiece
{
    private Color color;
    private Location loc;
    private ArrayList<PieceBlock> blocks;
    private TetrisGrid grid;
    private int size;
    private boolean locked;

    public TetrisPiece(TetrisGrid grid)
    {
        this.grid=grid;
        color=new Color(139,28,98);
        loc=new Location(3,3);
        size=3;
        blocks=new ArrayList<PieceBlock>();
        locked=false;

        setInitialLocations();
    }
    
    public TetrisPiece(TetrisGrid grid, Color color, Location loc, int size)
    {
        this.grid=grid;
        this.color=color;
        this.loc=loc;
        this.size=size;
        blocks=new ArrayList<PieceBlock>();
        locked=false;
        setInitialLocations();
    }

    public void setInitialLocations()
    {
        Location one=new Location(0,1);
        Location two=new Location(1,0);
        Location three=new Location(1,2);
        Location four=new Location(2,1);

        blocks.add(new PieceBlock(this,one));
        blocks.add(new PieceBlock(this,two));
        blocks.add(new PieceBlock(this,three));
        blocks.add(new PieceBlock(this,four));

    }

    public ArrayList<PieceBlock> getBlocks()
    {
        return blocks;
    }

    public Location getAnchor()
    {
        return loc;
    }

    public int getSize()
    {
        return size;
    }

    public Color getColor()
    {
        return color;
    }

    public void setAnchor(Location l)
    {
        loc=l;
    }

    public void setSize(int size)
    {
        this.size=size;
    }

    public void setColor(Color c)
    {
        color=c;
        for(int i=0;i<4;i++)
        {
            Block b=blocks.get(i);
            b.setColor(c);
        }        
    }

    public String toString()
    {
        String retStr="TetrisPiece: ";
        for(int i=0;i<4;i++)
        {
            retStr+=blocks.get(i);
        }
        return retStr;
    }

    public static void pieceTester()
    {
        TetrisPiece piece = new TetrisPiece(null);
        System.out.println(piece);
    }

    public void moveInDir(int direction)
    {
        loc=loc.getLocInDir(direction);
    }

    public void rotClock()
    {
        int size=getSize();
        for(int i=0;i<4;i++)
        {
            Location loc=blocks.get(i).getRelativeLocation();
            int row=loc.getRow();
            int col=loc.getCol();
            Location loc2=new Location(col,size-1-row);
            blocks.get(i).setLocation(loc2);
        }
    }

    public void rotate()
    {
        this.rotClock();
    }

    public static void rotTester()
    {
        TetrisPiece piece = new TetrisPiece(null);
        System.out.println(piece);
        piece.rotate();
        System.out.println("\n"+piece);
    }

    public boolean fitsInGrid()
    {
        boolean inGrid=true;
        for(int i=0;i<4;i++)
        {
            Location loc=blocks.get(i).getLocation();
            if(!grid.isValid(loc))
                inGrid=false;
            else if(grid.get(loc)!=null)
                inGrid=false;    
        }
        return inGrid;
    }

    public TetrisPiece copy()
    {
        TetrisPiece poser=new TetrisPiece(grid);
        ArrayList<PieceBlock> poserBlocks = poser.getBlocks();
        poser.setSize(size);
        poser.setAnchor(loc);
        for(int i=0;i<4;i++)
        {
            Location l=blocks.get(i).getRelativeLocation();
            poserBlocks.get(i).setLocation(l);
        }
        return poser;
    }

    public boolean canMoveInDir(int dir)
    {
        if( dir<37||dir>40)
            return false;
        boolean boo=true;
        TetrisPiece copy=copy();
        copy.moveInDir(dir);
        return copy.fitsInGrid();
    }

    public boolean canRotate()
    {
        boolean boo=true;
        TetrisPiece copy=copy();
        copy.rotate();
        return copy.fitsInGrid();
    }
    
    public boolean isLocked()
    {
        return locked;
    }
    
    public void lockToGrid()
    {
        for(int i=0;i<4;i++)
        {
            Location loc=blocks.get(i).getLocation();
            Block b=new Block(color);
            b.setLocation(loc);
            grid.addBlock(loc,b);
        }
        locked=true;
    }

}

