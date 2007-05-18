package lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

public class MyAnnotationProcessor {

	Button button;
	
	MyAnnotationProcessor(Button b)
	{
		this.button=b;
	}
	
	
	public void processMethods(final Object x)
	{
		Method[] methods=x.getClass().getMethods();
		for( final Method m : methods)
		{
			if(m.isAnnotationPresent(YaxglEvent.class))
			{
				
				//Hier holt er sich die spezielle annotation
				YaxglEvent yEvent=m.getAnnotation(YaxglEvent.class);
				System.out.println(yEvent.eventType()+ ":" + yEvent.controlID());
				
				//Mit annotation spezifizeiert methode dem control hier button zuweisen 
					button.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent e)
						{
							//die Methode mit der Annotation aufrufen
							try {
								m.invoke(x);
							} catch (IllegalArgumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IllegalAccessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (InvocationTargetException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}			
						}
					});
				
			
			}
		}		
	}
	
	
	
}
