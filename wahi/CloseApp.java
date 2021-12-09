import java.io.IOException;
import java.awt.Desktop;
import java.util.*;

///change
/*
CloseApp class closes the local applications that have been open. It contains methods for closing all applications that WAHI cn launch
*/

public class CloseApp implements Tasks {
    String work;
    Process p;

    @Override
    public void performTask(String what,Desktop desk){
        //creating a treemap for each command and it's kkey is the function that is to be executed 
        TreeMap<String, String> tmap= new TreeMap<>();
        tmap=createTMAP();
        Set<Map.Entry<String, String>> entrySet = tmap.entrySet();
        // Convert entrySet to Array using toArray method
        Map.Entry<String, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);
        for (int i=0;i<11;i++){
            if(what.equalsIgnoreCase(entryArray[i].getKey())){
                        work=entryArray[i].getValue();
            } 
        }
        run(work);
    }

   
    public void run(String work){ //method to run the work and hence close the applications
        if(work != null) { //if work is equal to null then hence no application is need to be close
            try {
                p = Runtime.getRuntime().exec(work);
            } catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
    //function to create treemap
    public TreeMap createTMAP(){
        TreeMap<String, String> tmap= new TreeMap<>();
        tmap.put("closeChrome","cmd /c start taskkill /im chrome.exe /f") ;
        tmap.put("closeEdge","cmd /c start taskkill /im MicrosoftEdge.exe /f") ;
        tmap.put("closeWord","cmd /c start taskkill /im winword.exe /f") ;
        tmap.put("closeExcel","cmd /c start taskkill /im excel.exe /f") ;
        tmap.put("closePowerpoint","cmd /c start taskkill /im powerpnt.exe /f") ;
        tmap.put("closePaint","cmd /c start taskkill /im mspaint.exe /f") ;
        tmap.put("closeNotepad","cmd /c start taskkill /im notepad.exe /f") ;
        tmap.put("closeCMD","cmd /c start taskkill /im cmd.exe /f") ;
        tmap.put("closeCP","cmd /c start taskkill /im control.exe /f") ;
        tmap.put("closeCal","cmd /c start taskkill /im calculator.exe /f") ;
        tmap.put("closePlayer","cmd /c start taskkill /im wmplayer.exe /f") ; 
        return tmap;
    }
}
