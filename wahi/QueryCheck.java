import java.awt.Desktop;
import java.io.*;

public class QueryCheck {
    public void checkquery(String command,Desktop desk,wahispeak speaking){
        if(command.equalsIgnoreCase("0")){ 
            try {
                AccessJDBC aj=new AccessJDBC();
                aj.access("0");
                File file=new File("grocessory_lst.txt");
                speaking.speak("select all from from grocessory list");
                desk.open(file);
                System.out.println("Grocery List");
            } catch (Exception e) {
                System.err.println(e);
            }
        }else if(command.equalsIgnoreCase("1")){ 
            try {
                AccessJDBC aj=new AccessJDBC();
                aj.access("1");
                File file=new File("filteredgrocessory_lst.txt");
                speaking.speak("select all from from grocessory list where price is greator than 10");
                desk.open(file);
                System.out.println("Filetered Grocery");
            } catch (Exception e) {
                System.err.println(e);
            }
        } else if(command.equalsIgnoreCase("2")){ 
            try {
                AccessJDBC aj=new AccessJDBC();
                aj.access("2");
                File file=new File("WAHICommands.txt");
                speaking.speak("select all from wahi commands");
                desk.open(file);
                System.out.println("Commands retrieved");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    
}
