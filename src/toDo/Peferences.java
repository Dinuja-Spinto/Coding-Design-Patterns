package toDo;

public class Peferences {
    private static final Peferences settings = new Peferences();

    private Peferences(){}

    public static Peferences getSettings(){
        return settings;
    }

    public void setBackgrondColor(String color){
        System.out.println(color);
    }

}
