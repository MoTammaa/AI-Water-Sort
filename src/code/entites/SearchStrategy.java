package code.entites;

import code.search.*;

public enum SearchStrategy {
    DFS, BFS, UCS, IDS, AStar, Greedy;

    // string representation of the enum
    public String toString() {
        return switch (this) {
            case DFS -> "DFS";
            case BFS -> "BFS";
            case UCS -> "UCS";
            case IDS -> "IDS";
            case AStar -> "AStar";
            case Greedy -> "Greedy";
            default -> "Unknown";
        };
    }

    // get the enum instance from the string representation
    public static SearchStrategy getSearchStrategy(String strategy) {
        return switch (strategy) {
            case "DFS","DF" -> DFS;
            case "BFS","BF" -> BFS;
            case "UCS","UC" -> UCS;
            case "IDS","ID" -> IDS;
            case "AStar","AS" -> AStar;
            case "Greedy","GR" -> Greedy;
            default -> throw new IllegalArgumentException("Unknown search strategy: " + strategy);
        };
    }

    // get the General Search class instance of the search strategy
    public GeneralSearch getSearchInstance() {
        return switch (this) {
            case DFS -> new DFS();
            case BFS -> new BFS();
            case UCS -> new UCS();
            case IDS -> new IDS();
            case AStar -> new AStar();
            case Greedy -> new GreedyS();
            default -> null;
        };
    }

    public static GeneralSearch getSearchInstance(String strategy) { return getSearchStrategy(strategy).getSearchInstance(); }

}
