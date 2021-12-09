import java.awt.Desktop;
public class CloseCheck {

    public void checkclose(String command, Tasks closelocalapp, Desktop desk,wahispeak speaking){
        if (command.equalsIgnoreCase("close chrome")) {
            speaking.speak("Closing google Chrome");
            closelocalapp.performTask("closeChrome", desk);
        } else if (command.equalsIgnoreCase("close microsoft edge")) {
            speaking.speak("Closing Microsoft Edge");
            closelocalapp.performTask("closeEdge", desk);
        } else if (command.equalsIgnoreCase("close word")) {
            speaking.speak("Closing Microsft Word");
            closelocalapp.performTask("closeWord", desk);
        }  else if (command.equalsIgnoreCase("close excel")) {
            speaking.speak("Closing microsoft excel");
            closelocalapp.performTask("closeExcel", desk);
        }  else if (command.equalsIgnoreCase("close power point")) {
            speaking.speak("Closing Powerpoint");
            closelocalapp.performTask("closePowerPoint", desk);
        }  else if (command.equalsIgnoreCase("close paint")) {
            speaking.speak("Closing Paint");
            closelocalapp.performTask("closePaint", desk);
        } else if (command.equalsIgnoreCase("close notepad")) {
            speaking.speak("Closing Notepad");
            closelocalapp.performTask("closeNotepad", desk);
        }else if (command.equalsIgnoreCase("close command prompt")) {
            speaking.speak("Closing command prompt");
            closelocalapp.performTask("closeCMD", desk);
        }  else if (command.equalsIgnoreCase("close control panel")) {
            speaking.speak("Closing control Panel");
            closelocalapp.performTask("closeCP", desk);
        } else if (command.equalsIgnoreCase("close calculator")) {
            speaking.speak("Closing Calculator");
            closelocalapp.performTask("closeCal", desk);
        }  else if (command.equalsIgnoreCase("close player")) {
            speaking.speak("Closing Media Player");
            closelocalapp.performTask("closePlayer", desk);
        }   
    }
    
}
