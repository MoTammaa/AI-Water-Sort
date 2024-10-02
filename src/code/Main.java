package code;

import code.entites.Node;
import code.entites.State;
import code.search.AStar;
import code.search.BFS;
import code.search.DFS;
import code.search.GeneralSearch;

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



        WaterSortSearch waterSortSearch = new WaterSortSearch();
        String p1 = "5;4;" + "b,y,r,b;" + "b,y,r,r;" + "y,r,b,y;" + "e,e,e,e;" + "e,e,e,e;";
        String p2 = "3;4;" + "b,b,r,r;" + "r,r,b,b;" + "e,e,e,e;";


        System.out.println(waterSortSearch.solve(p1, "ID", true));
//        System.out.println(waterSortSearch.solve(p2, "DF", false));
    }
}
