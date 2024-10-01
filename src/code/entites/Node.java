package code.entites;

import code.WaterSortSearch;
import code.search.AStar;
import code.search.BFS;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Node implements Comparable<Node> {
    public Action pour;
    private final State state;
    Node parent;
    private final int depth;
    private int pathCost;

    public Node(State state, Node parent, Action pour, int depth, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.pour = pour;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    public Node(Node parent) {
        this((State) parent.state.clone(), parent, null, parent.depth + 1, parent.pathCost);
    }

    public Node(State state){
        this(state, null, null, 0, 0);
    }


    public int applyAction(Action action){
        pour = action;
        int actionCost = state.applyAction(action);
        pathCost += actionCost;
        return actionCost;
    }

    public boolean isGoal(){
        return state.isGoal();
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Node)
            return equals((Node) obj);
        return false;
    }
    public boolean equals(Node node){ return state.equals(node.state) && depth == node.depth && pathCost == node.pathCost; }
    public int hashCode(){ return state.hashCode() + depth + pathCost; }
    public String toString(){ return "d: " + depth + ", Pcost: " + pathCost + "\n" + state.toString(); }

    // getters
    public State getState() { return state; }
    public Node getParent() { return parent; }
    public int getDepth() { return depth; }
    public int getPathCost() { return pathCost; }

    @Override
    public int compareTo(Node o) {
        return WaterSortSearch.currentAgent.EVAL_Fn(this, WaterSortSearch.heuristicVersion) -
                WaterSortSearch.currentAgent.EVAL_Fn(o, WaterSortSearch.heuristicVersion);
    }


    public static void main(String[] args) {
        // testing functionality
        Node node = new Node(new State("2;3;b,b,e;b,e,e;"));
        System.out.println(node);

        Node node2 = new Node(node);
        System.out.println(node.equals(node2));
        node2.applyAction(new Action(0, 1));
        System.out.println(node2);

        Node node3 = new Node(node);
        System.out.println(node.equals(node3));
        node3.applyAction(new Action(1, 0));
        System.out.println(node3);

        HashSet<State> states = new HashSet<>();
        states.add(node.getState());
        states.add(node2.getState());

        // System.out.println(states.size());

        WaterSortSearch.currentAgent = new AStar();
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(node3);
        nodes.add(node2);
        nodes.add(node);

        System.out.println(WaterSortSearch.currentAgent.EVAL_Fn(node2, 1));
        System.out.println(WaterSortSearch.currentAgent.EVAL_Fn(node3, 1));
        System.out.println(WaterSortSearch.currentAgent.EVAL_Fn(node, 1));

        System.out.println(nodes.poll().pathCost);
        System.out.println(nodes.poll().pathCost);
        System.out.println(nodes.poll().pathCost);
    }
}
