package code;

import code.entites.Node;
import code.entites.State;
import code.search.AStar;
import code.search.BFS;
import code.search.DFS;
import code.search.GeneralSearch;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(4);
        pq.add(3);
//        System.out.println(pq.poll());

//        GeneralSearch aStar = new AStar();
//        // use the evalFn to print the result of EVAL_Fn
//        System.out.println(aStar.evalFn.EVAL_Fn(null,1));



        String p1 = "5;4;" + "b,y,r,b;" + "b,y,r,r;" + "y,r,b,y;" + "e,e,e,e;" + "e,e,e,e;";
        String p2 = "3;4;" + "b,b,b,r;" + "r,r,r,b;" + "e,e,e,e;";
        String p3nosolution = "3;3;" + "b,r,r;" + "b,b,r;" + "y,e,e;";
        String p4 = "3;3;" + "b,b,b;" + "r,r,r;" + "y,y,y;";
        String grid0 = "3;" +
                "4;" +
                "r,y,r,y;" +
                "y,r,y,r;" +
                "e,e,e,e;";


        System.out.println(WaterSortSearch.solve(grid0, "UC", true));
        Node cur = WaterSortSearch.currentAgent.getSolutionNode();
        ArrayList<State> steps = new ArrayList<>();
        while (cur != null) {
            steps.addFirst(cur.getState());
            cur = cur.getParent();
        }
        WaterSortVisualizer visualizer = new WaterSortVisualizer(steps);
//        System.out.println(waterSortSearch.solve(p2, "DF", false));
    }
}
