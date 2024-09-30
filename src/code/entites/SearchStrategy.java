package code.entites;

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
}
