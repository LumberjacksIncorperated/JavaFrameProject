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
import wrapped_classes.*;

// Chain Testing Framework
import chain_testing.*;

public class GraphicWindow extends BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private final GraphicWindowCanvas canvasPane;
    private final JFrameWrapper JFrameWrapper;

	public GraphicWindow() {
        this.JFrameWrapper = new JFrameWrapper();
		this.canvasPane = new GraphicWindowCanvas();
 		setWindowConfigurationWithGraphicWindowCanvas(this.canvasPane); 
    }

	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 400;
    private void setWindowConfigurationWithGraphicWindowCanvas(GraphicWindowCanvas windowCanvas) {
 		this.JFrameWrapper.setContentPane(windowCanvas.getWindowCanvasPanel());
        this.JFrameWrapper.setDefaultCloseOperation();
        this.JFrameWrapper.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.JFrameWrapper.setVisible(true);
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
        constructionTest();
    }

    private static void constructionTest() {

        MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
            
            public void executeTestCalls() {
                GraphicWindow graphicsWindow = new GraphicWindow();
            }

            public void executeExpectedCalls() {
                GraphicWindowCanvas windowCanvas = new GraphicWindowCanvas();
                JFrameWrapper jFrameWrapper = new JFrameWrapper();
                jFrameWrapper.setContentPane(windowCanvas.getWindowCanvasPanel());
                jFrameWrapper.setDefaultCloseOperation();
                jFrameWrapper.setSize(400, 400);
                jFrameWrapper.setVisible(true);
            }

        }, "Graphic Window Construction");
    }
}
