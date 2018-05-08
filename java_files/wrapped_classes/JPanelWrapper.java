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
// PACKAGE
//-----------------------------------------------------------------------------------------------------------------------
package wrapped_classes;

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
import java.awt.*;
import javax.swing.*;
import java.util.*;

// Chain Testing Framework
import chain_testing.*;

public class JPanelWrapper extends BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private JPanel jPanel;

    public JPanelWrapper() {
    	this.monitorMethodCallWithNameAndObjects("GraphicWindowCanvas()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

        this.jPanel = new JPanel();
    }

    public void repaint() {
    	this.monitorMethodCallWithNameAndObjects("repaint()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

    	this.jPanel.repaint();
    }

    public JPanel accessTheWrapperPanel() {
    	return this.jPanel;
    }
}