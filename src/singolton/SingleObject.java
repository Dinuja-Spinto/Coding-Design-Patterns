package singolton;

public class SingleObject {
    //create an object of SingleObject
    private static final SingleObject instance = new SingleObject();
    //make the constructor private
    private SingleObject(){}
    //Get the only object available
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
