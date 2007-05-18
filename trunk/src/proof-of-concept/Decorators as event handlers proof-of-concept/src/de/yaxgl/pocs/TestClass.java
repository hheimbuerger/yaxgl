package de.yaxgl.pocs;

import javax.swing.JOptionPane;

import de.yaxgl.pocs.eventhandler.EventHandler;
import de.yaxgl.pocs.eventhandler.EventType;
import de.yaxgl.pocs.framework.Window;

public class TestClass {
	private Window myWindow;

	public TestClass() {
		myWindow = new Window();
		myWindow.registerEventHandlers(this);
		myWindow.setVisible(true);
	}
	
	@EventHandler(type = EventType.clickEvent, IDFilterRE = "Button [1-2]")
	public void handleSpecialEventsForButtonsOneAndTwo(EventType type, String ID) {
		JOptionPane.showMessageDialog(myWindow, "Button 1 or 2 has been clicked!");
	}

	@EventHandler(type = EventType.clickEvent, IDFilterRE = "(Button 3)|(Button 4)")
	public void handleSpecialEventsForButtonsThreeAndFour(EventType type, String ID) {
		JOptionPane.showMessageDialog(myWindow, "Button 3 or 4 has been clicked!");
	}

	@EventHandler(type = EventType.clickEvent, IDFilterRE = "Button \\d")
	public void handleEventForAllButtons(EventType type, String ID) {
		JOptionPane.showMessageDialog(myWindow, "A button has been clicked!");
	}

	@EventHandler(type = EventType.anyEvent, IDFilterRE = ".*")
	public void handleAllEvents(EventType type, String ID) {
		JOptionPane.showMessageDialog(myWindow, "The event '" + type.toString() + "' has occured for the ID '" + ID + "'!");
	}

/*
	@EventHandler(type = EventType.anyEvent, IDFilterRE = ".*")
	public void incorrectEventHandler1(EventType type) {
		JOptionPane.showMessageDialog(myWindow, "This event handler shouldn't be invokable!");
	}

	@EventHandler(type = EventType.anyEvent, IDFilterRE = ".*")
	public void incorrectEventHandler2(EventType type, String ID, String ID2) {
		JOptionPane.showMessageDialog(myWindow, "This event handler shouldn't be invokable!");
	}

	@EventHandler(type = EventType.anyEvent, IDFilterRE = ".*")
	public void incorrectEventHandler3(EventType type, int ID) {
		JOptionPane.showMessageDialog(myWindow, "This event handler shouldn't be invokable!");
	}

	@EventHandler(type = EventType.anyEvent, IDFilterRE = ".*")
	public void incorrectEventHandler4(int type, String ID) {
		JOptionPane.showMessageDialog(myWindow, "This event handler shouldn't be invokable!");
	}
*/

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestClass myTestClass = new TestClass();
	}
}
