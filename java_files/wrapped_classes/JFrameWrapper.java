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

public class JFrameWrapper extends BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private final JFrame jFrame;

	public JFrameWrapper() {
		this.jFrame = new JFrame();
    }

    public void setContentPane(JPanelWrapper contentPane) {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

    	this.jFrame.setContentPane(contentPane.accessTheWrapperPanel());
    }

    public void setDefaultCloseOperation() {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});
		
    	this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setSize(int width, int height) {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(width),
			ObjectDescription.descriptionOfInt(height)
		});
		
    	this.jFrame.setSize(width, height);
    }
    
    public void setVisible(boolean visibility) {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfBoolean(visibility)
		});
		
    	this.jFrame.setVisible(visibility);
    }

    public void dispose() {
    	this.jFrame.dispose();
    }
}