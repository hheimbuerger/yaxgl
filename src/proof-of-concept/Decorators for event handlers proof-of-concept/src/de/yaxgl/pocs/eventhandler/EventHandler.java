package de.yaxgl.pocs.eventhandler;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
	EventType	type();
	String		IDFilterRE();
}
