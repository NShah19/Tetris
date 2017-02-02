import java.util.*;
import sacco.gui.*;
public class TetrisGrid
{
    private Block[][] blocky;

    public TetrisGrid(int rows, int cols)
    {
        blocky=new Block[rows][cols];        
    }    

    public int numRows()
    {
        return blocky.length;
    }

    public int numCols()
    {
        return blocky[0].length;
    }

    public String toString()
    {
        String retStr="TetrisGrid: \n";
        for(int row=0;row<blocky.length;row++)
        {
            for(int col=0;col<blocky[0].length;col++)
            {
                if(blocky[row][col]!=null)
                {
                    retStr+=blocky[row][col];
                    retStr+="\n";
                }
            }
        }
        return retStr;
    }

    public Block get(Location loc)
    {
        return blocky[loc.getRow()][loc.getCol()];
    }

    public void addBlock(Location loc, Block b)
    {
        if(b!=null)
            b.setLocation(loc);
        blocky[loc.getRow()][loc.getCol()]=b;
    }

    public void addRandomBlock(Location loc)
    {
        Block b = new Block();
        b.setLocation(loc);
        blocky[loc.getRow()][loc.getCol()]=b;
    }

    public boolean isValid(Location loc)
    {
        int r=loc.getRow();
        int c=loc.getCol();
        if(r<0 || c<0 || r>numRows()-1 || c>numCols()-1)
            return false;
        return true;
    }

    public void clearLoc(Location loc)
    {
        blocky[loc.getRow()][loc.getCol()]=null;
    }

    public ArrayList<Block> getBlocks()
    {
        ArrayList<Block> ret=new ArrayList<Block>();
        for(int row=0;row<blocky.length;row++)
        {
            for(int col=0;col<blocky[0].length;col++)
            {
                if(blocky[row][col]!=null)
                    ret.add(blocky[row][col]);
            }
        }
        return ret;
    }

    public void quickLoadBlocks(int[][] locs)
    {
        for(int row=0;row<locs.length;row++)
        {
            Location loc=new Location(locs[row][0],locs[row][1]);
            addRandomBlock(loc);
        }
    }

    public static void tetrisGridTester()
    {
        System.out.println("Testing Constructor and adding methods:");
        //Testing Constructor, addBlock, addRandomBlock,and toString
        TetrisGrid tet = new TetrisGrid(9,13);

        tet.addBlock(new Location(7,3),new Block(Color.RED));
        tet.addBlock(new Location(2,1),new Block(Color.GREEN));
        tet.addBlock(new Location(4,2),new Block(Color.BLUE));
        tet.addRandomBlock(new Location(8,9));

        System.out.println(tet);

        //Testing clearLoc        
        System.out.println("\nclearLoc Test:");
        Location loc = new Location(2,1);
        System.out.println("Before clearLoc:");
        System.out.println(tet.get(loc));

        tet.clearLoc(loc);
        System.out.println("After clearLoc:");
        System.out.println(tet.get(loc));

        //Testing numRows/numCols
        System.out.println("\nnumRows(): "+tet.numRows());
        System.out.println("numCols(): "+tet.numCols());

        //Testing isValid
        System.out.println("\nValid Location Test:");
        Location[] goodLocs = new Location[]{new Location(5,7),new Location(0,3), new Location(7,0),new Location(8,4),new Location(2,12)};
        for(Location tmpLoc : goodLocs)
        {
            System.out.println(tmpLoc+" isValid:"+tet.isValid(tmpLoc));
        }

        System.out.println("\ninValid Location Test:");
        Location[] badLocs = new Location[]{new Location(-1,5),new Location(2,-1), new Location(9,2),new Location(4,13),new Location(2,113)};
        for(Location tmpLoc : badLocs)
        {
            System.out.println(tmpLoc+" isValid:"+tet.isValid(tmpLoc));
        }

        System.out.println("Testing getBlocks()");
        System.out.println(tet.getBlocks());
    }

    public static void quickLoadBlocksTester()
    {
        TetrisGrid tet = new TetrisGrid(19,13);
        tet.quickLoadBlocks(new int[][]{{6,2},{6,6},{8,4},{9,1},{9,7},{10,2},{10,6},{11,3},{11,4},{11,5}});
        System.out.println(tet);
    }

    public void moveBlock(Location start, Location end)
    {
        int row=start.getRow();
        int col=start.getCol();
        addBlock(end,blocky[row][col]);
        blocky[row][col] = null;
    }

    public void dropRow(int num)
    {
        for(int col=0;col<blocky[0].length;col++)
        {

            Location start = new Location(num,col);
            Location end=start.getLocInDir(40);
            //             blocky[num][col].setLocation(end);           
            moveBlock(start,end);            
        }
    }

    public boolean isRowFull(int row)
    {
        for(int col=0;col<blocky[0].length;col++)
        {
            if(blocky[row][col]==null)
                return false;
        }
        return true;
    }

    public boolean hasAFullRow()
    {
        for(int i=0;i<blocky.length;i++)
        {
            if(isRowFull(i)==true)
                return true;
        }
        return false;
    }

}