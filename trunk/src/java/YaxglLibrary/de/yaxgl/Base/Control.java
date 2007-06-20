package de.yaxgl.Base;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.yaxgl.EventDispatcher.EventArgs;
import de.yaxgl.EventDispatcher.Attribute.EventType;



public abstract class Control extends Component implements Containable {

	// TODO: think about this
	/*
	 * eventuell Listener zurück geben in jedem und das über Handel event machen
	 * ist allgemeiner
	 */
	public SelectionAdapter clickEvent(final Control sender) {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				owner.notifyEvent(sender, new EventArgs(EventType.Click, sender
						.getID()));
			}
		};
	}

	public SelectionAdapter selectionChangedEvent(final Control sender) {
		return new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				owner.notifyEvent(sender, new EventArgs(
						EventType.SelectionChanged, sender.ID));
			}

		};

	}

	public FocusListener focusEvent(final Control sender) {
		return new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				owner.notifyEvent(sender, new EventArgs(EventType.GotFocus,
						sender.getID()));
			}

			@Override
			public void focusLost(FocusEvent e) {

				owner.notifyEvent(sender, new EventArgs(EventType.LostFocus,
						sender.getID()));
			}
		};
	}

	/*
	 * this is how it was in .Net no we need several classes like for button
	 * example:
	 * 
	 * public class ButtonClickHandler implements SelectionAdapter{ public void
	 * widgetSelected(SelectionEvent e) { } } or we do it like this
	 * 
	 * 
	 * public void clickEvent(Object sender, System.EventArgs e) {
	 * owner.notifyEvent(this, new EventArgs(EventType.Click, this.ID)); }
	 * 
	 * public void gotFocusEvent(Object sender, System.EventArgs e) {
	 * owner.notifyEvent(this,new EventArgs(EventType.GotFocus, this.ID)); }
	 * 
	 * public void lostFocusEvent(Object sender, System.EventArgs e) {
	 * owner.notifyEvent(this, new EventArgs(EventType.LostFocus, this.ID)); }
	 * 
	 * public void selectionChangedEvent(Object sender, System.EventArgs e) {
	 * owner.notifyEvent(this, new EventArgs(EventType.SelectionChanged,
	 * this.ID)); }
	 */
	public void setEnabled(boolean enabled) {
		this.control.setEnabled(enabled);
	}

	public boolean isEnabled() {
		return this.control.isEnabled();
	}
}
