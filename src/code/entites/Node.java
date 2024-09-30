package code.entites;

public class Node {
    Action pour;
    State state;
    Node parent;
    int pathCost, depth;

    public Node(State state, Node parent, Action pour, int pathCost, int depth){
        this.state = state;
        this.parent = parent;
        this.pour = pour;
        this.pathCost = pathCost;
        this.depth = depth;
    }

    public Node(State state){
        this(state, null, null, 0, 0);
    }



    public boolean isGoal(State goal){
        return state.equals(goal);
    }

    public boolean equals(Node node){
        return state.equals(node.state) && pathCost == node.pathCost && depth == node.depth;
    }

    public int hashCode(){
        return state.hashCode() + pathCost + depth;
    }

    public String toString(){
        return state.toString();
    }
}
