//creating Tasks interface that will be implemented in concrete classes CloseApp,Chat,Browse, AccessJDBC and Launch
import java.awt.Desktop;

public interface Tasks{
    void performTask(String what, Desktop desk);
}