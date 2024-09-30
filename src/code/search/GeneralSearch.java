package code.search;

import code.entites.Node;
import code.entites.State;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class GeneralSearch {

    PriorityQueue<Node> nodes;
    Node solutionNode;
    State initialState;

    public GeneralSearch(){
        nodes = new PriorityQueue<Node>();
    }
//    public GeneralSearch(State initialState){
//        nodes = new PriorityQueue<Node>();
//        this.initialState = initialState;
//    }

    public boolean SEARCH_NextStep(){
        if (nodes.isEmpty()) return false; // failure

        Node node = removeFront();
        if (GoalTest(node))
            return true;

        addNodes(EXPAND(node));
        return true;
    }

    public abstract int EVAL_Fn(Node node);
    public abstract int EVAL_Fn(Node node, int version);

    public ArrayList<Node> EXPAND(Node node){
        return null;
    }

    public boolean isSolutionFound() { return solutionNode != null; }
    public boolean GoalTest(Node node){
        if (node.isGoal()){
            solutionNode = node;
            return true;
        }
        return false;
    }

    public Node removeFront(){
        return nodes.poll();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addNodes(ArrayList<Node> nodes){
        this.nodes.addAll(nodes);
    }

}
