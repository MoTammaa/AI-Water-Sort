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
        System.out.println(pq.poll());

//        GeneralSearch aStar = new AStar();
//        // use the evalFn to print the result of EVAL_Fn
//        System.out.println(aStar.evalFn.EVAL_Fn(null,1));


        GeneralSearch search = new BFS();

//        String init = "5;4;" + "b,y,r,b;" + "b,y,r,r;" + "y,r,b,y;" + "e,e,e,e;" + "e,e,e,e;";
//        search.initialState = new State(init);
        String p1 = "3;4;" + "b,b,r,r;" + "r,r,b,b;" + "e,e,e,e;";
        search.initialState = new State(p1);

        search.addNode(new code.entites.Node(search.initialState));
        WaterSortSearch.currentAgent = search;

        while (!search.isSolutionFound()){
//            System.out.println(search.getFront());
            search.SEARCH_NextStep();
            if(search.expandedNodesCount % 1000 == 0)
                System.out.println(search.expandedNodesCount);
        }
        Node current = search.getSolutionNode();
        StringBuilder sb = new StringBuilder();
        while (current != null){
            sb.insert(0, current + "\n\n");
            current = current.getParent();
        }
        System.out.println(sb.toString());
    }
}
