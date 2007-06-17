using System;
using System.Collections.Generic;
using System.Text;
using de.yaxgl;

namespace TestApplication
{
    public class DialogEvents
    {
        private WindowManager winManager = null;
        
        public DialogEvents(WindowManager windowManager)
        {
            winManager = windowManager;
        }

        [de.yaxgl.EventHandler(eventID="button1",eventType=EventType.Click)]
        public void clickButton1(Component sender, de.yaxgl.EventArgs eventArgs)
        {
            Window dialog=sender.getParentWindow();
            winManager.close(dialog); 
        }
        
    }
}
