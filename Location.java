public class Location
{
    private int row;
    private int column;
    public static final int UP=38;
    public static final int DOWN=40;
    public static final int LEFT=37;
    public static final int RIGHT=39;

    public Location(int row, int column)
    {
        this.row=row;
        this.column=column;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return column;
    }

    public Location plus(Location newLoc)
    {
        int newRow=row+newLoc.getRow();
        int newColumn=column+newLoc.getCol();
        Location ret=new Location(newRow,newColumn);
        return ret;
    }

    public String toString()
    {
        return "Loc("+row+","+column+")";
    }

    public Location getLocInDir(int direction)
    {
        if(direction==UP)
        {
            Location ret=new Location(row-1,column);
            return ret;
        }
        else if(direction==DOWN)
        {
            Location ret=new Location(row+1,column);
            return ret;
        }
        else if(direction==RIGHT)
        {
            Location ret=new Location(row,column+1);
            return ret;
        }
        else if(direction==LEFT)
        {
            Location ret=new Location(row,column-1);
            return ret;
        }
        else
        {
            return null;
        }
    }

    public static void locationTester()
    {
        Location loc = new Location(3,6);
        System.out.println("Original Location:"+ loc);
        System.out.println("getRow() --> "+loc.getRow());
        System.out.println("getCol() --> "+loc.getCol());
        System.out.println("getLocInDir(Location.UP) --> "+loc.getLocInDir(Location.UP));
        System.out.println("getLocInDir(Location.DOWN) --> "+loc.getLocInDir(Location.DOWN));
        System.out.println("getLocInDir(Location.LEFT) --> "+loc.getLocInDir(Location.LEFT));
        System.out.println("getLocInDir(Location.RIGHT) --> "+loc.getLocInDir(Location.RIGHT));

        Location other = new Location(9,2);
        Location sum = loc.plus(other);
        System.out.println("The sum of "+ loc + " and "+other+" is "+sum);
    }
}