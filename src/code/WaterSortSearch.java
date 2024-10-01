package code;

import code.entites.Node;
import code.search.GeneralSearch;

public class WaterSortSearch extends GeneralSearch {
    public static int MAX_BOTTLE_CAPACITY = 4,
            BOTTLES_COUNT = 5;

    public static GeneralSearch currentAgent;
    public static int heuristicVersion = 1;
    @Override
    public int EVAL_Fn(Node node) {
        return 0;
    }

    @Override
    public int EVAL_Fn(Node node, int version) {
        return 0;
    }
}
