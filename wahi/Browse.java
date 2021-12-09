import java.awt.Desktop;
import java.net.URI;

/*
Browse class contains functions to browse different internet websites that WAHI can access and respond with to the user. 
*/
public class Browse implements Tasks {
    @Override
    public void performTask(String what, Desktop desk){
        if(what.equalsIgnoreCase("openpscs"))
            openpscs(desk);
        else if(what.equalsIgnoreCase("openlms"))
            openLMS(desk);
        else if(what.equalsIgnoreCase("openyoutube"))
            openyoutube(desk);
        else if(what.equalsIgnoreCase("openoutlook"))
            openoutlook(desk);
        else if(what.equalsIgnoreCase("opengoogle"))
            opengoogle(desk);
        
    }
    
    public void openpscs(Desktop desk){ //open habib's pscs
        try {
            URI uri = new URI("https://pscs.habib.edu.pk/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void openLMS(Desktop desk){ //open habib LMS
        try {
            URI uri = new URI("https://habib.edu.pk/hulms/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }

    public void openyoutube(Desktop desk){ //open youtube
        try {
            URI uri = new URI("http://youtube.com/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void openoutlook(Desktop desk){ //open outlook.com
        try {
            URI uri = new URI("www.outlook.com");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void opengoogle(Desktop desk){ //open google.com
        try {
            URI uri = new URI("www.google.com");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    
}
