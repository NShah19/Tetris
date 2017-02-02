import java.util.*;
import sacco.gui.*;
import sacco.*;

public class TetrisController
{
    private TetrisModel model;

    public TetrisController(TetrisModel m)
    {
        model=m;
    }

    public void onKeyPress(int keyCode)
    {

        if(keyCode >=37 && keyCode<=40)
        {
            if(model.getPiece().canMoveInDir(keyCode)&& keyCode!=38)
            {
                model.getPiece().moveInDir(keyCode);

            }
        }

        if( keyCode == 32)
        {
            if(model.getPiece().canRotate())
                model.getPiece().rotate();
        }

    }
    public void dropIntoFullRows()
    {
        for(int i=0;i<model.getGrid().numRows();i++)
        {
            if(model.getGrid().isRowFull(i))
            {
                for(int d=i-1;d>0;d--)
                    model.getGrid().dropRow(d);
            }
        }
    }

    public void onTimerTick()
    {
        TetrisPiece p=model.getPiece();

        if(p.canMoveInDir(40))
            p.moveInDir(40);
        else
        {
            p.lockToGrid();
            dropIntoFullRows();
            model.newPiece();
            
        }

    }
}