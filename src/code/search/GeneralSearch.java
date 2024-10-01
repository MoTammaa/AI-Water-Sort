package code.search;

import code.entites.Action;
import code.entites.EvaluationFn;
import code.entites.Node;
import code.entites.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public abstract class GeneralSearch {

    PriorityQueue<Node> nodes;
    Node solutionNode;
    public State initialState;
    HashSet<State> explored;
    public int expandedNodesCount = 0;

    public GeneralSearch(){
        nodes = new PriorityQueue<Node>();
        explored = new HashSet<>();
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

    public int EVAL_Fn(Node node) { return EVAL_Fn(node, 1); }
    public abstract int EVAL_Fn(Node node, int version);

    public ArrayList<Node> EXPAND(Node node){
        ArrayList<Node> expandedNodes = new ArrayList<>();
        if (explored.contains(node.getState())) return expandedNodes;

        expandedNodesCount++;
        explored.add(node.getState());
        for (int from = 0; from < node.getState().getBottles().length; from++)
            for (int to = 0; to < node.getState().getBottles().length; to++){
                Action pour = new Action(from, to);
                Node child = new Node(node);

                if (child.applyAction(pour) > 0)
                    expandedNodes.add(child);
            }
        return expandedNodes;
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

    public Node getFront(){
        return nodes.peek();
    }

    public void addNode(Node node){
        if(node == null) throw new IllegalArgumentException("Node cannot be null");
        nodes.add(node);
    }

    public void addNodes(ArrayList<Node> nodes){
        for (Node node : nodes) if(node == null) throw new IllegalArgumentException("Node cannot be null");
        this.nodes.addAll(nodes);
    }
    public Node getSolutionNode() {
        return solutionNode;
    }
    public int getExpandedNodesCount() {
        return expandedNodesCount;
    }


}
