package code.entites;

public class Node {
    public Action pour;
    private State state;
    Node parent;
    private int pathCost, depth;

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



    public boolean isGoal(){
        return state.isGoal();
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

    // getters
    public State getState() {
        return state;
    }
    public Node getParent() {
        return parent;
    }
    public int getPathCost() {
        return pathCost;
    }
    public int getDepth() {
        return depth;
    }
}
