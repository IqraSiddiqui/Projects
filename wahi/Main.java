/*
Main class contains main function that runs wahi and its gui on different threads to avoid microsphone/speaker blockage
*/

public class Main
{ 
       public static void main(String[] args) {

        VoiceAssistant wahi=VoiceAssistant.getInstance();
        GUI gui=new GUI();
        
        Thread wahithread = new Thread(wahi);
        Thread guithread=new Thread(gui);
        wahithread.start();
        guithread.start();
        
    }
}