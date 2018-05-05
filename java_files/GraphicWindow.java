import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GraphicWindow extends JFrame {

	private final GraphicWindowCanvas canvasPane;

	public GraphicWindow() {
		super("Graphic Window");
		this.canvasPane = new GraphicWindowCanvas();
 		this.setWindowConfigurationWithGraphicWindowCanvas(this.canvasPane); 
    }

    public Canvas getThisWindowsCanvas() {
        return this.canvasPane;
    }

	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 400;
    private void setWindowConfigurationWithGraphicWindowCanvas(GraphicWindowCanvas windowCanvas) {
 		this.setContentPane(windowCanvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    //create a component that you can actually draw on.
    class GraphicWindowCanvas extends JPanel implements Canvas {
     	private ArrayList<BrushStroke> brushStrokes = new ArrayList<BrushStroke>();

     	public GraphicWindowCanvas() {}

     	public void drawBrushStroke(BrushStroke brushStroke) {
     		brushStrokes.add(brushStroke);
     		this.askNicelyForThisJPanelToRepaintPlease();
     	}

 		public void clearCanvasOfAllPaintAndDaves() {
 			brushStrokes = new ArrayList<BrushStroke>();
 			this.askNicelyForThisJPanelToRepaintPlease();
 		}

 		private void askNicelyForThisJPanelToRepaintPlease() {
 			System.out.println("Gods Be Merciful");
 			this.repaint();
 		}

        public void paintComponent(Graphics graphics) {
            System.out.println("paint here loop");
            for (BrushStroke brushStroke : this.brushStrokes) {
            	brushStroke.paintThisStrokeUponMyGraphics(graphics);
            }
        }
    }
}


