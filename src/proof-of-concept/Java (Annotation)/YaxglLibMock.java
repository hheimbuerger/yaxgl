package lib;


import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

public class YaxglLibMock {
	Display display=null;
	Shell shell=null;
	
	public YaxglLibMock(String s,Object x)
	{
		//hier würde dann ein Container mit Components zurück gegeben werden
		Button b=parseXML(s);
		
		//hier kommt dann der Container rein
		MyAnnotationProcessor p=new MyAnnotationProcessor(b);
		p.processMethods(x);
	}

	private Button parseXML(String s)
	{
		//Das alles steht dann normal im xml file
		display = new Display();
		shell = new Shell(display);
		shell.pack();
		Button button = new Button(shell,SWT.PUSH);
		button.pack();
		shell.setText("Ich bin ein Fenster");
		shell.setBounds(100,100,300,200);
		button.setText("Push Me");
		button.setBounds(115, 60, 70, 25);		
		return button;
	}
	
	
	
	
	public void show()
	{
		shell.open();
		
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
			display.sleep();
			display.dispose();
			}
	

}
