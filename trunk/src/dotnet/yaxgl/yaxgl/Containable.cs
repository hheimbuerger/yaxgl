using System;
using System.Collections.Generic;
using System.Text;

namespace de.yaxgl
{
    public interface Containable
    {
        /*returns the Specific Base Control of an de.yaxgl.Containable (Control and Group)
         * */
        System.Windows.Forms.Control getBaseControl();
    }
}
