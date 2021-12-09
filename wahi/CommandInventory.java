import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.AWTException;
import java.io.*;
import java.awt.Desktop;
import java.util.*;

/*
This class contains all commands that WAHI can understand and takes the respective actions for every command. It creates corresponing class object and call respective functions for its execution
*/
public class CommandInventory {
    private static final String voiceNAME = "kevin16"; //the speaker voice
    String work = null;
    Desktop desk = Desktop.getDesktop(); //desktop object
    wahispeak speaking=new wahispeak(); //speaker object
    TasksFactory tasksFactory=new TasksFactory(); //generatin task factory
    ArrayList<Tasks> arrayy= new ArrayList<Tasks>();
           



    public void checkCommands(String command){ //method to check commands and call respective functions
            
            //Use the task Factory to get object of concrete class by passing a tasktype.
            List<Tasks> namesList = Arrays.asList( tasksFactory.getTask("Launch"), tasksFactory.getTask("Chat") ,tasksFactory.getTask("Browse"), tasksFactory.getTask("Close"));
            arrayy.addAll(namesList);
            Tasks localapp=arrayy.get(0);
            Tasks bot=arrayy.get(1);
            Tasks app=arrayy.get(2);
            Tasks closelocalapp=arrayy.get(3);
             work = null;

            if(command.equalsIgnoreCase("who are you")) { 
                speaking.speak("I am WAHI, your assistant, i am here to help you");
            } else if(command.equalsIgnoreCase("good morning")) {
                speaking.speak("Good Morning. How can i help?");
            } 

            //local apps hence execute local app function to open corresponding applications
            //else{

            OpenCheck op=new OpenCheck();
            op.checklaunch(command, localapp, desk,speaking);

            //local apps hence execute local app function to close corresponding applications

            CloseCheck cp=new CloseCheck();
            cp.checkclose(command, closelocalapp, desk,speaking);
            
            //Executing sql query hence generate accessjdbc object and call access on the user provided sql command id to execute it

            QueryCheck qp=new QueryCheck();
            qp.checkquery(command,desk,speaking);

            //online apps hence execute online app function to open corresponding applications

            BrowseCheck bp=new BrowseCheck();
            bp.checkbrowse(command, app, desk,speaking);

            BotCheck chatp=new BotCheck();
            chatp.checkbot(command, bot, desk,speaking);
            
}
}
