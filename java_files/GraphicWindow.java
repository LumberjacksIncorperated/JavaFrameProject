//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Java Frame Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GraphicWindow extends JFrame {

	private final GraphicWindowCanvas canvasPane;

	public GraphicWindow() {
		super("Graphic Window");
		this.canvasPane = new GraphicWindowCanvas();
 		setWindowConfigurationWithGraphicWindowCanvas(this.canvasPane); 
    }

	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 400;
    private void setWindowConfigurationWithGraphicWindowCanvas(GraphicWindowCanvas windowCanvas) {
 		this.setContentPane(windowCanvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Canvas getThisWindowsCanvas() {
        return this.canvasPane;
    }
}
