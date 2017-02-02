import sacco.gui.*;

public class PieceBlock extends Block
{
    private TetrisPiece piece;
    
    public PieceBlock(TetrisPiece piece, Location loc)
    {
        super(piece.getColor());
        this.piece=piece;       
        super.setLocation(loc);
    }
    
    public Location getRelativeLocation()
    {
        return super.getLocation();
    }
    
    public Location getLocation()
    {
        Location relative=super.getLocation();
        Location anchor=piece.getAnchor();
        return relative.plus(anchor);
    }
    
    public String toString()
    {
        return ""+super.getColor()+getRelativeLocation()+" - Global "+getLocation();
    }
}
