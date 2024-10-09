package code.entites;

import code.WaterSortSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class State implements Cloneable {
    private ArrayList<Color> [] bottles;

    private void init(ArrayList<Color> [] bottles){
        this.bottles = new ArrayList[WaterSortSearch.BOTTLES_COUNT];
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
            this.bottles[i] = bottles == null ? new ArrayList<>() : new ArrayList<>(bottles[i]);
    }

    public State(){
        init(null);
    }

    public State(String input){
        // parse input
        String [] params = input.split(";");

        WaterSortSearch.BOTTLES_COUNT = Integer.parseInt(params[0]);
        WaterSortSearch.MAX_BOTTLE_CAPACITY = Integer.parseInt(params[1]);

        init(null);
        for (int i = 2; i < params.length; i++){
            String [] colors = params[i].split(",");
            for (String color : colors)
                if (!color.equals("e"))
                    bottles[i - 2].addFirst(Color.getColor(color));
        }
    }

    public State(State state){
        init(state.bottles);
    }


    public boolean isGoal() {
        HashSet<Color> goal = new HashSet<>();
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
        {
            if (bottles[i].isEmpty())
                continue;
            Color baseColor = bottles[i].getFirst();

            // for now, we will assume that the goal is to have maximum 1 bottle with a specific color
            // , and that means that the total number of layers of the same color is less than or equal Bottle Capacity
            // TODO: ask TAs
//            if (goal.contains(baseColor))
//                return false;
            goal.add(baseColor);

            for (Color color : bottles[i])
                if (color != baseColor)
                    return false;

        }
        return true;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof State)
            return equals((State) obj);
        return false;
    }
    public boolean equals(State state){
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
            if (!bottles[i].equals(state.bottles[i]))
                return false;
        return true;
    }

    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
            hash += bottles[i].hashCode();
        return hash;
    }

    @Override
    public Object clone(){
        return new State(this);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++){
            str.append("Bottle ").append(i).append(": ").append("top -> ");
//            System.out.println(bottles.length);
            for (int j = bottles[i].size() - 1; j >= 0; j--) {
                str.append(bottles[i].get(j)).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public int applyAction(Action action) {
        if (action.from == action.to)
            return 0;
        if (bottles[action.from].isEmpty())
            return 0;
        if (bottles[action.to].size() == WaterSortSearch.MAX_BOTTLE_CAPACITY)
            return 0;

        Color color = bottles[action.from].getLast();
        if (bottles[action.to].size() == WaterSortSearch.MAX_BOTTLE_CAPACITY || (!bottles[action.to].isEmpty() && bottles[action.to].getLast() != color))
            return 0;

        int count = 0;
        while (!bottles[action.from].isEmpty() &&
                bottles[action.to].size() < WaterSortSearch.MAX_BOTTLE_CAPACITY &&
                bottles[action.from].getLast() == color) {
            bottles[action.to].addLast(bottles[action.from].removeLast());
            count++;
        }

        return count;
    }


    // getters
    public ArrayList<Color>[] getBottles() {
        return bottles;
    }
    public ArrayList<Color> getBottle(int index) {
        return bottles[index];
    }


    public static void main(String[] args) {
        State state = new State("5;4;e,e,e,e,e;e,e,e,e,e;e,e,e,e,e;e,e,e,e,e;e,e,e,e,e");
        State state2 = new State(state);
        System.out.println(state.equals(state2));
    }

}
