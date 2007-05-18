package de.yaxgl.pocs.framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.yaxgl.pocs.eventhandler.EventType;

public class Button implements ActionListener {
	private JButton nativeButton;
	private Window owner;
	private String id;
	
	public Button(Window owner, String id) {
		this.owner = owner;
		this.id = id;
		nativeButton = new JButton(id);
		nativeButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		owner.notifyClickEvent(this, EventType.clickEvent);
	}
	
	public JButton getNativeComponent() {
		return(nativeButton);
	}

	public String getId() {
		return id;
	}
}
