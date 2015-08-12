/*************************************************
Készítette: Mester Gábor
http://avvoltoio.extra.hu/
*************************************************/
import java.io.IOException;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class amoba
    extends MIDlet
    {
  private amobacanvas acanvas;
  private Display myDisplay;
  private boolean paused;
  public void startApp() {
	  System.out.println("STARTAPP");
	acanvas= new amobacanvas();
	myDisplay=Display.getDisplay(this);
    myDisplay.setCurrent(acanvas);
  }

  public void pauseApp() {
	   paused = true;

    notifyPaused();
    }

  public void destroyApp(boolean unconditional) {
   notifyDestroyed();
  }

  /*public void commandAction(Command c, Displayable s) {
    if (c.getCommandType() == Command.EXIT) {
      destroyApp(true);
      notifyDestroyed();
    }
  }*/
}
