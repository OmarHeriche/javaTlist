import java.util.ArrayList;
import java.util.Scanner;

public class taskManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String action;
        Container pilila = new Container("test", false);
        int num,st;
        boolean new_status;
        while (true) {
            System.out.println("enter what do u want:");
            action = scan.nextLine();
            // action="remove";
            if (action.equals("add")) {
                Container.addTask();
            }
            if (action.equals("remove")) {
                System.out.println("enter id:");
                num = scan.nextInt();
                Container.removeTask(num);
            }
            if (action.equals("display")) {
                Container.showTasks();
            }
            if(action.equals("status")){
                System.out.println("enter id:");
                st = scan.nextInt();
                System.out.println("enter new status:");
                new_status = scan.nextBoolean();
                Container.newStatus(st, new_status);
            }
            if(action.equals("rename")){
                System.out.println("enter id:");
                st = scan.nextInt();    
                scan.nextLine();
                System.out.println("enter new name:");
                String newName=scan.nextLine();  
                Container.newName(st, newName);          
            }
        }
    }
}

class Task {
    static int id = 0;
    private String input;
    private boolean completed;
    private int objId;

    public Task(String input, boolean completed) {
        this.input = input;
        this.completed = completed;
        Task.id++;
        this.objId = Task.id;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String new_input) {
        this.input = new_input;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean new_completed) {
        this.completed = new_completed;
    }

    public int getId() {
        return this.objId;
    }
}

class Container extends Task {
    static ArrayList<Task> tasksList = new ArrayList<Task>();

    public Container(String input, boolean completed) {
        super(input, completed);
    }

    public static void addTask() {
        Scanner scan = new Scanner(System.in);
        String input;
        boolean completed;
        System.out.println("enter the task");
        input = scan.nextLine();
        // scan.nextLine();
        System.out.println("enter the status");
        completed = scan.nextBoolean();
        Task newOne = new Task(input, completed);
        Container.tasksList.add(newOne);
    }

    public static void removeTask(int id) {
        for (Task task : Container.tasksList) {
            if (task.getId() == id) {
                Container.tasksList.remove(task);
                System.out.println("removed succefully");
                return;
            }
        }
        System.out.println("task not found!"); 
    }
    public static void newStatus(int id,boolean new_completed){
        for (Task task : Container.tasksList) {
            if (task.getId() == id) {
                task.setCompleted(new_completed);
                System.out.println("changed succefully");
                return;
            }
        }      
        System.out.println("task not found!"); 
    }
    public static void newName(int id,String newName){
        for (Task task : Container.tasksList) {
            if (task.getId() == id) {
                task.setInput(newName);
                System.out.println("changed succefully");
                return;
            }
        }   
        System.err.println("task not found!");   
    }

    public static void showTasks() {
        // for(int i=0;i<)
        System.out.println("____________________________________");
        for (Task eleTask : Container.tasksList) {
            System.out.println("id:" + eleTask.getId() + "\ntask: " + eleTask.getInput() + "\ncompleted: "
                    + eleTask.getCompleted());
        }
        System.out.println("____________________________________");
    }

}