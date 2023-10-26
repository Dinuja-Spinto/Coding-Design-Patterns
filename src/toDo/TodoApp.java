package toDo;

public class TodoApp {
    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        MainWindow window = app.new MainWindow("blue");
        TodoItem item = app.new TodoItem("custom-checkbox", "custom-boxstyle");
        item.setCheckBox("");
        item.setTaskBox("");
        window.setBackgroundColor("black");
    }
    interface Component{
        void render();
    }
    class MainWindow implements Component{
        public String getBackgroundColor()
        { return backgroundColor;
        }
        public void setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
        String backgroundColor;
        public MainWindow(){
            this.backgroundColor = "white";
        }

        public MainWindow(String backgroundColor){ this.backgroundColor = backgroundColor; }

        @Override
        public void render() {
            //logic to render main-window to display
            System.out.println("main-window-background: " + this.backgroundColor);
        }
    }
         class TodoItem implements Component {
             String checkBox;
             String taskBox;

             public String getCheckBox() {
                 return checkBox;
             }

             public void setCheckBox(String checkBox) {
                 this.checkBox = checkBox;
             }

             public String getTaskBox() {
                 return taskBox;
             }

             public void setTaskBox(String taskBox) {
                 this.taskBox = taskBox;
             }

             public TodoItem() {
                 this.checkBox = "default-checkbox";
                 this.taskBox = "default-taskbox";
             }

             public TodoItem(String checkBoxStyle, String taskBoxStyle) {
                 this.checkBox = checkBoxStyle;
                 this.taskBox = taskBoxStyle;
             }

             @Override
             public void render() {
                 System.out.println("check: " + checkBox + " taskBox: " + taskBox);
             }
         }

}
