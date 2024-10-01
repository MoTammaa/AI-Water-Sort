package code.search;

import code.entites.Color;
import code.entites.Node;
import code.entites.State;

import java.util.ArrayList;

public class GreedyS extends GeneralSearch {

    @Override
    public int EVAL_Fn(Node node, int version) {
        return version == 1 ? H_n1(node) : H_n2(node);
    }
    @Override // not valid. must give version
    public int EVAL_Fn(Node node) { throw new UnsupportedOperationException("Unsupported call for AStar. Must provide version"); }


    // Heuristic 1: Number of layers left after the base layer color longest sequence
    // Example: bottle : H( top->[b, b, r, r, g, b*, b*, b*]<-bottom ) = 8 - 3 = 5
    // This relaxed the problem to account for minimum number of layers (cost) to be moved to solve the problem
    // This heuristic is ADMISSIBLE because it never overestimates the cost to reach the goal. We will at least move the top layers.
    // This heuristic is more informed than the second heuristic because it considers the number of layers to be moved.
    // (according to the optimality criteria of the problem)
    public int H_n1(Node node) {
        ArrayList<Color> [] bottles = node.getState().getBottles();
        int total = 0;
        for (ArrayList<Color> bottle : bottles) {
            int count = 0;
            if(bottle.isEmpty()) continue;
            Color base = bottle.getFirst();
            for (int i = 0; i < bottle.size(); i++) {
                if (bottle.get(i) == base)
                    count++;
                else
                    break;
            }
            total += bottle.size() - count;
        }
        return total;
    }

    // == Heuristic 2: Number of transitions to different colors in bottle.
    // == Example: bottle : H( top->[b, b, r, r, g, b*, b*, b*]<-bottom ) = 3,  because: (b->r, r->g, g->b)
    // == This relaxed the problem to account for minimum number of moves (actions) to be taken to solve the problem
    //      And the difference between the two heuristics is that here we consider that the action will
    //      move multiple layers at once.
    // == This heuristic is ADMISSIBLE because it never overestimates the cost to reach the goal. We will at least move the top colors.
    public int H_n2(Node node) {
        ArrayList<Color> [] bottles = node.getState().getBottles();
        int total = 0;
        for (ArrayList<Color> bottle : bottles) {
            if(bottle.isEmpty()) continue;
            Color last = bottle.getFirst();
            for (Color color : bottle) {
                if (last != color)
                    total++;
                last = color;
            }
        }
        return total;
    }
}
