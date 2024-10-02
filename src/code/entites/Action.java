package code.entites;

public class Action {
    public int from, to;

    public Action(int from, int to){
        this.from = from;
        this.to = to;
    }

    public String toString(){
        return "pour_" + from + "_" + to;
    }
}
