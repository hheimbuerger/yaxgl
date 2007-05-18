package lib;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface YaxglEvent {
	EventType eventType();
	String controlID();
}
