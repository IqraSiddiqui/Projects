import java.awt.Desktop;

public class BotCheck {
    public void checkbot(String command, Tasks bot, Desktop desk,wahispeak speaking){
        if(command.equalsIgnoreCase("start chatting")){
            speaking.speak("Preparing your chatbot");
            bot.performTask("Chat", desk);
    }
    
}
}
