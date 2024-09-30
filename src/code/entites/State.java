package code.entites;

import code.WaterSortSearch;

import java.util.ArrayList;
import java.util.LinkedList;

public class State implements Cloneable {
    private ArrayList<Color> [] bottles;

    public State(){
        bottles = new ArrayList[WaterSortSearch.BOTTLES_COUNT];
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
            bottles[i] = new ArrayList<>();
    }

    public State(String input){
        this();
        // parse input
        String [] params = input.split(";");

        WaterSortSearch.BOTTLES_COUNT = Integer.parseInt(params[0]);
        WaterSortSearch.MAX_BOTTLE_CAPACITY = Integer.parseInt(params[1]);

        for (int i = 2; i < params.length; i++){
            String [] colors = params[i].split(",");
            for (String color : colors)
                if (!color.equals("e"))
                    bottles[i - 2].addFirst(Color.getColor(color));
        }
    }

    public State(State state){
        bottles = new ArrayList[WaterSortSearch.BOTTLES_COUNT];
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
            bottles[i] = new ArrayList<>(state.bottles[i]);
    }


    public boolean isGoal() {
        for (int i = 0; i < WaterSortSearch.BOTTLES_COUNT; i++)
        {
            Color baseColor = bottles[i].getFirst();
            for (Color color : bottles[i])
                if (color != baseColor)
                    return false;
        }
        return true;
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
            str.append("Bottle ").append(i).append(": ");
            for (Color color : bottles[i])
                str.append(color).append(" ");
            str.append("\n");
        }
        return str.toString();
    }
}
