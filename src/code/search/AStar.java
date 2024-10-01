package code.search;

import code.entites.Node;

public class AStar extends GreedyS {

    @Override
    public int EVAL_Fn(Node node, int version) {
        int g_n = node.getPathCost();
        return g_n + super.EVAL_Fn(node, version);
    }

}
