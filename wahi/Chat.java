import java.awt.Desktop;
import java.net.URI;

/*Chat class contains a method to open a online chatbot whenever user ask for chatting*/

public class Chat implements Tasks{

    Chat c;

    @Override
    public void performTask(String what, Desktop desk){
        startChat(desk);
    }

    public void startChat(Desktop desk){
        try {
            System.out.println("Preparing your chatbot");
            URI uri = new URI("https://alejandro.app.fi/ai-chat");
            desk.browse(uri);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
    
}
}