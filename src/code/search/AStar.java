package code.search;

import code.entites.Node;

public class AStar extends GreedyS {

    @Override
    public int EVAL_Fn(Node node, int version) {
        int g_n = node.getPathCost();
        return g_n + (version == 1 ? H_n1(node) : H_n2(node));
    }

}
