package code.search;

import code.entites.Node;

public class DFS extends GeneralSearch {
    @Override
    public int EVAL_Fn(Node node, int version) {
        return -node.getDepth();
    }
}
