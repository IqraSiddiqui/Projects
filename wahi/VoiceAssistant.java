import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;


/* This is the mai class of our voice recognition that contains launguage and recognition configurations and start speech recognition and call the command inventory object to check commands and take corresponding action */
public class VoiceAssistant implements Runnable {
    //create an object of Singleton
    private static VoiceAssistant instance=new VoiceAssistant();

    //make the construtor private so that this class 
    //cannot be instantiated
    private VoiceAssistant(){};

    //Get the only object available
    public static VoiceAssistant getInstance(){
        return instance;
    }
    
    private LiveSpeechRecognizer recognizer;
    
    boolean active=false;
    CommandInventory cmdinvent=new CommandInventory();
    wahispeak speaking=new wahispeak(); 

    public void InitAssistant() {
        
        //Configuration Object
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the language model (vocabulary model).
        configuration.setDictionaryPath("src\\dic.dic");
        configuration.setLanguageModelPath("src\\lm.lm");
        
        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            System.out.println(e);
        }
         
        //Start speech recognition 
        startSpeechRecognition();
    }
    
    public void startSpeechRecognition() {
        
        //Start Recognition Process (The boolean parameter clears the previous cache if true)
        recognizer.startRecognition(true);
        
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognizer.getResult()) != null) {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            
            System.out.println(result.getHypothesis());
            if (command.equalsIgnoreCase("Wake Up")) {
                active=true;
                System.out.println("I am ready to help");
                speaking.speak("I am ready to help");
            } else if(command.equalsIgnoreCase("Sleep")) {
                active=false;
                System.out.println("I am sleepy! Bye");
                speaking.speak("I am sleepy! Bye");
                break;
            }
            if(active==true)
                cmdinvent.checkCommands(command);
            }  
        }
    
    public void run(){
        VoiceAssistant va = new VoiceAssistant();
        va.InitAssistant();
    }
}