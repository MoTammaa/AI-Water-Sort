package code;

import code.entites.Node;
import code.entites.State;
import code.search.GeneralSearch;

import java.util.ArrayList;

public class WaterSortSearch extends GeneralSearch {
    public static int MAX_BOTTLE_CAPACITY = 4,
            BOTTLES_COUNT = 5;

    public static GeneralSearch currentAgent;
    public static int heuristicVersion = 1;

    public static boolean SHOW_DEBUG = false;


    public static String solve(String initialState, String strategy, boolean visualize) {
        init(initialState, strategy, visualize);

        /* ****************************************** */
        currentAgent.GENERAL_SEARCH();
        /* ****************************************** */

        Node current = currentAgent.getSolutionNode();
        if (SHOW_DEBUG && current != null){
            StringBuilder sb = new StringBuilder();
            while (current != null){
                sb.insert(0, current + "\n\n");
                current = current.getParent();
            }
            System.out.println("\n\nDepth: " + currentAgent.getSolutionNode().getDepth() + "\nSolution Cost: " + currentAgent.getSolutionNode().getPathCost() +"\nExpanded Nodes: " +currentAgent.expandedNodesCount + "\n\n" + sb.toString());
            Node cur = currentAgent.getSolutionNode();
            ArrayList<State> steps = new ArrayList<>();
            while (cur != null) { steps.addFirst(cur.getState()); cur = cur.getParent(); }
            WaterSortVisualizer visualizer = new WaterSortVisualizer(steps);
        }
        return Node.getSolutionString(currentAgent.getSolutionNode());
    }

    private static void init(String initialState, String strategy, boolean visualize) {
        SHOW_DEBUG = visualize;
        int strategyVersion = 1;
        if (strategy.length() > 2) strategyVersion = strategy.charAt(2) - '0';
        strategy = strategy.substring(0, 2);

        currentAgent = GeneralSearch.getAgent(strategy);
        currentAgent.setInitialState(new State(initialState));
        heuristicVersion = strategyVersion;
    }



    @Override
    public int EVAL_Fn(Node node, int version) {
        return 0;
    }
}
