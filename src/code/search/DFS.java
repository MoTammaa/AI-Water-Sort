package code.search;

import code.entites.Node;

public class DFS extends GeneralSearch {
    @Override
    public int EVAL_Fn(Node node) {
        return EVAL_Fn(node, 1);
    }

    @Override
    public int EVAL_Fn(Node node, int version) {
        return -node.getDepth();
    }
}
