import java.awt.Desktop;
public class OpenCheck {

    public void checklaunch(String command, Tasks localapp, Desktop desk,wahispeak speaking){
        if (command.equalsIgnoreCase("open chrome")) {
            speaking.speak("Opening Google Chrome");
                localapp.performTask("openChrome", desk);
            } else if (command.equalsIgnoreCase("open microsoft edge")) {
                speaking.speak("Opening Microsoft Edge");
                localapp.performTask("openEdge", desk);
            }  else if (command.equalsIgnoreCase("open word")) {
                speaking.speak("Opening Microsoft Word");
                localapp.performTask("openWord", desk);
            }else if (command.equalsIgnoreCase("open excel")) {
                speaking.speak("Opening Microsoft Excel");
                localapp.performTask("openExcel", desk);
            }else if (command.equalsIgnoreCase("open power point")) {
                speaking.speak("Opening Microsoft Powerpoint");
                localapp.performTask("openPowerPoint", desk);
            }else if (command.equalsIgnoreCase("open notepad")) {
                speaking.speak("Opening Notepad");
                localapp.performTask("openNotepad", desk);
            } else if (command.equalsIgnoreCase("open command prompt")) {
                speaking.speak("Opening Command Prompt");
                localapp.performTask("openCMD", desk);
            } else if (command.equalsIgnoreCase("open control panel")) {
                speaking.speak("Opening control Panel");
                localapp.performTask("openCP", desk);
            }else if (command.equalsIgnoreCase("open calculator")) {
                speaking.speak("Opening Calculator");
                localapp.performTask("openCal", desk);
            }else if(command.equalsIgnoreCase("Open file manager")){
                speaking.speak("Opening explorer");
                localapp.performTask("openExplorer", desk);
            }else if (command.equalsIgnoreCase("open player")) {
                speaking.speak("Opening Media Player");
                localapp.performTask("openPlayer", desk);
            }else if (command.equalsIgnoreCase("open paint")) {
                speaking.speak("Opening Paint");
                localapp.performTask("openPaint", desk);
            }
    }
    
}
