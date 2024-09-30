package code.search;

import code.entites.Node;
import code.entites.State;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class GeneralSearch {

    PriorityQueue<Node> nodes;
    Node goalNode;
    State initialState,
            goalState;

    public GeneralSearch(){
        nodes = new PriorityQueue<Node>();
    }

    public abstract int EVAL_Fn(Node node);
    public abstract int EVAL_Fn(Node node, int version);

    public ArrayList<Node> EXPAND(Node node){
        return null;
    }

    public boolean GoalTest(Node node){
        if (node.isGoal(goalState)){
            goalNode = node;
            return true;
        }
        return false;
    }

    public Node getTopNode(){
        return nodes.poll();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addNodes(ArrayList<Node> nodes){
        this.nodes.addAll(nodes);
    }

}
