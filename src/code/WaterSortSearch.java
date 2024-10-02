package code;

import code.entites.Node;
import code.entites.State;
import code.search.GeneralSearch;

public class WaterSortSearch extends GeneralSearch {
    public static int MAX_BOTTLE_CAPACITY = 4,
            BOTTLES_COUNT = 5;

    public static GeneralSearch currentAgent;
    public static int heuristicVersion = 1;


    public String solve(String initialState, String strategy, boolean visualize) {
        init(initialState, strategy);

        while (!currentAgent.isSolutionFound()){
            currentAgent.SEARCH_NextStep();
            if(currentAgent.expandedNodesCount % 1000 == 0) System.out.println(currentAgent.expandedNodesCount + "     " + currentAgent.getFront().getDepth());
        }

        Node current = currentAgent.getSolutionNode();
//        System.out.println(Node.getSolutionString(current));

        if (visualize) {
            StringBuilder sb = new StringBuilder();
            while (current != null){
                sb.insert(0, current + "\n\n");
                current = current.getParent();
            }
            System.out.println("\n\nDepth: " + currentAgent.getSolutionNode().getDepth() + "\n\nExpanded Nodes: " +currentAgent.expandedNodesCount + "\n\n" + sb.toString());
        }
        return Node.getSolutionString(currentAgent.getSolutionNode());
    }

    private void init(String initialState, String strategy) {
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
