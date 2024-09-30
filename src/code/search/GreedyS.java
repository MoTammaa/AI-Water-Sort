package code.search;

import code.entites.Node;

public class GreedyS extends GeneralSearch {

    @Override
    public int EVAL_Fn(Node node, int version) {
        return version == 1 ? H_n1(node) : H_n2(node);
    }
    @Override // not valid. must give version
    public int EVAL_Fn(Node node) { throw new UnsupportedOperationException("Unsupported call for AStar. Must provide version"); }


    public int H_n1(Node node) {
        return 0;
    }

    public int H_n2(Node node) {
        return 0;
    }
}
