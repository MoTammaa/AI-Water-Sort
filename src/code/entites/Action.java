package code.entites;

public class Action {
    public int from, to;

    public Action(int from, int to){
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Action)
            return equals((Action) obj);
        return false;
    }

    public boolean equals(Action action){
        return from == action.from && to == action.to;
    }

    public boolean isReverse(Action action){
        return action == null ? false : from == action.to && to == action.from;
    }

    public String toString(){
        return "pour_" + from + "_" + to;
    }
}
