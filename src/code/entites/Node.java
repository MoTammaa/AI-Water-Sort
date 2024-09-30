package code.entites;

import code.WaterSortSearch;

public class Node implements Comparable<Node> {
    public Action pour;
    private final State state;
    Node parent;
    private final int depth;

    public Node(State state, Node parent, Action pour, int depth){
        this.state = state;
        this.parent = parent;
        this.pour = pour;
        this.depth = depth;
    }

    public Node(Node parent) {
        this((State) parent.state.clone(), parent, null, parent.depth + 1);
    }

    public Node(State state){
        this(state, null, null, 0);
    }


    public boolean applyAction(Action action){
        pour = action;
        return state.applyAction(action);
    }

    public boolean isGoal(){
        return state.isGoal();
    }

    public boolean equals(Node node){
        return state.equals(node.state) && depth == node.depth;
    }

    public int hashCode(){
        return state.hashCode() + depth;
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
    public int getDepth() {
        return depth;
    }

    @Override
    public int compareTo(Node o) {
        return WaterSortSearch.currentAgent.evalFn.EVAL_Fn(this, WaterSortSearch.heuristicVersion) -
                WaterSortSearch.currentAgent.evalFn.EVAL_Fn(o, WaterSortSearch.heuristicVersion);
    }
}
