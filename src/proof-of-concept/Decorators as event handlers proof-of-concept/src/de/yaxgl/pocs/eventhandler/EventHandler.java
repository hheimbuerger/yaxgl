package de.yaxgl.pocs.eventhandler;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
	EventType	type();
	String		IDFilterRE();
}
