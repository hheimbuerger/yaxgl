package de.yaxgl.EventDispatcher.Attribute;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.*;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
	
	public EventType eventType();
	public String eventID();
	public boolean regexOn();
	
	//todo: wie ehier schon regexOn=false setzten standart
	//und gehen auch so konstruktoren wi in c#
}
