import sacco.*;
import sacco.gui.*;

public class Tetris extends SaccoWindow
{
    private TetrisModel model;
    private TetrisView  view;
    private TetrisController controller;

    public Tetris()
    {
        model = new TetrisModel();
        view = new TetrisView (model);
        controller = new TetrisController (model);
    }

    public void paintWindow(Canvas c)
    {
        view.paintTetris(c);
    }

    public void launch()
    {
        this.setSize(view.getWidth(),view.getHeight());
        this.setVisible(true);
        this.setDelay(600);
        this.start();
    } 

    public static void main()
    {
        Tetris t = new Tetris();
        t.launch();
    }
    
    public void onTimerTick()
    {
        controller.onTimerTick();
    }

    public void onKeyPress(int keyCode)
    {
        controller.onKeyPress(keyCode);
        
    }
}