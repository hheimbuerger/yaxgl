

import java.lang.annotation.*;

import lib.EventType;
import lib.MyAnnotationProcessor;
import lib.YaxglEvent;
import lib.YaxglLibMock;

public class Start {

	public static void main(String[] args)
	{
		YaxglLibMock mock=new YaxglLibMock("ich bedeute nix",new Start());
		mock.show();
		
		
		
		
	}
	
	
	
	
	@YaxglEvent(controlID = "button1", eventType = EventType.CLICK)
	public void buttenPush()
	{
		System.out.println("Button gedrückt! ICH bin eine Laufzeit Annotation in Java!");	
	}

	
	
	
}
