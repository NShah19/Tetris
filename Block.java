import sacco.gui.*;
public class Block
{
    private Color rainbow;
    private Location loc;

    public Block()
    {
        int r=(int)(Math.random()*256);
        int g=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        rainbow=new Color(r,g,b);
    }

    public Block(Color c)
    {
        rainbow=c;

    }

    public Color getColor()
    {
        return rainbow;
    }

    public Location getLocation()
    {
        return loc;
    }    

    public void setLocation(Location loc)
    {
        this.loc=loc;
    }

    public void setColor(Color col)
    {
        rainbow=col;

    }
    
    public String toString()
    {
        return "Block at "+loc+" with "+rainbow;
    }

    public static void blockTester()
    {
        Block b1 = new Block();
        b1.setLocation(new Location(2,5));

        Block b2 = new Block(Color.RED);
        b2.setLocation(new Location(-3,8));

        System.out.println(b1);
        System.out.println(b2);
    }
}