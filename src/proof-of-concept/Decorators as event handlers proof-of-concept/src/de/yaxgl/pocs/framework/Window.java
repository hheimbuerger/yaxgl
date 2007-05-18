package de.yaxgl.pocs.framework;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import de.yaxgl.pocs.eventhandler.EventHandlerManager;
import de.yaxgl.pocs.eventhandler.EventType;



@SuppressWarnings("serial")
public class Window extends JFrame {
	@SuppressWarnings("unused")
	private Button button1, button2, button3, button4;
	private EventHandlerManager eventHandlerManager; 
	
	public Window() {
		button1 = new Button(this, "Button 1");
		button2 = new Button(this, "Button 2");
		button3 = new Button(this, "Button 3");
		button4 = new Button(this, "Button 4");
		add(button1.getNativeComponent());
		add(button2.getNativeComponent());
		add(button3.getNativeComponent());
		add(button4.getNativeComponent());
		setTitle("Decorators as event handlers proof-of-concept");
		setSize(640, 480);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		eventHandlerManager = new EventHandlerManager();
	}

	public void registerEventHandlers(Object eventReceiver) {
		eventHandlerManager.registerEventHandlers(eventReceiver);
	}

	void notifyClickEvent(Button button, EventType type) {
		eventHandlerManager.invokeHandlers(button, type);
	}
}
