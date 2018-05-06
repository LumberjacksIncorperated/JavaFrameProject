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

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
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

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        runGraphicWindowTest();
    }

    private static void runGraphicWindowTest() {
        GraphicWindow testGraphicWindow = new GraphicWindow();
        String parameterString = testGraphicWindow.paramString();
        String expectedParameterString = "frame0,0,23,400x400,layout=java.awt.BorderLayout,title=Graphic Window,resizable,normal,defaultCloseOperation=EXIT_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true";

        assert(testGraphicWindow.isShowing());
        assert(parameterString.equals(expectedParameterString));
        
        testGraphicWindow.setVisible(false);
        testGraphicWindow.dispose();
    }
}
