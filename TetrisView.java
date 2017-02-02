import java.util.*;
import sacco.gui.*;
import sacco.*;

public class TetrisView
{
    private TetrisModel model;
    private int size;

    public TetrisView(TetrisModel t)
    {
        model=t;
        size=30;
    }

    public int getWidth()
    {
        return (model.getGrid().numCols())*size+1;
    }

    public int getHeight()
    {
        return ((model.getGrid().numRows())-3)*size+1;
    }

    public int getBlockSize()
    {
        return size;
    }

    public void paintTetris(Canvas c)
    {
        //this.paintGridLines(c);
        this.paintGridBlocks(c);
        this.paintPiece(c);
    }

    private void paintGridLines(Canvas c)
    {
        c.setColor("BLACK");
        int width=getWidth();
        int height=getHeight();
        for(int row=size;row<height;row++)
        {
            c.drawLine(0,row,width,row);
            row+=(size-1);
        }

        for(int col=size;col<width;col++)
        {
            c.drawLine(col,0,col,height);
            col+=(size-1);
        }

    }

    private void paintBlock(Block b,Canvas c)
    {
        c.setColor(b.getColor());
        int x=b.getLocation().getCol()*size;
        int y=(b.getLocation().getRow()-3)*size;
        c.fillRectangle(x,y,size,size);
        c.setColor("BLACK");
        c.setThickness(4);
        c.drawRectangle(x,y,size,size);        
    }

    private void paintGridBlocks(Canvas c)
    {
        ArrayList<Block> arr=model.getGrid().getBlocks();
        for(Block b:arr)
            paintBlock(b,c);
    }

    private void paintPiece(Canvas c)
    {
        TetrisPiece piece=model.getPiece();
        if(piece==null)
            return;
        else
        {
            ArrayList<PieceBlock> blocky=piece.getBlocks();
            for(int i=0;i<blocky.size();i++)
                paintBlock(blocky.get(i),c);

        }
    }
    
    private void endGame(Canvas c)
    {
        c.drawString("GAME OVER",275,120); 
    }
}