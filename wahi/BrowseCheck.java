import java.awt.Desktop;

public class BrowseCheck {
    public void checkbrowse(String command, Tasks app, Desktop desk,wahispeak speaking){
        if(command.equalsIgnoreCase("Open lms")){
            speaking.speak("Opening Habib LMS");
            app.performTask("openLMS", desk);
        }
        else if(command.equalsIgnoreCase("Open pscs")){
            speaking.speak("Opening PSCS");
            app.performTask("openPscs", desk);
        }
        else if(command.equalsIgnoreCase("Open youtube")){
            speaking.speak("Opening Youtube");
            app.performTask("openYoutube", desk);
        }
        else if(command.equalsIgnoreCase("Open outlook")){
            speaking.speak("Opening Outlook");
            app.performTask("openOutlook", desk);
        }
        else if(command.equalsIgnoreCase("open google")){
            speaking.speak("Opening Google");
            app.performTask("openGoogle", desk);
        }
    }
}
