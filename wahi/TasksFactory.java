//a Factory to generate object of concrete class based on given information.

public class TasksFactory {
    public Tasks getTask(String tasktype){
        if(tasktype == null){
            return null;
            }
            if(tasktype.equalsIgnoreCase("Close")){
            return new CloseApp();
            } else if(tasktype.equalsIgnoreCase("Launch")){
            return new Launch();
            } else if(tasktype.equalsIgnoreCase("Chat")){
            return new Chat();
            }else if(tasktype.equalsIgnoreCase("Browse")){
                return new Browse();
            }
            return null;
           
    }
}
