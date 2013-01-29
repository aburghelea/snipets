package learning.ctci.treegraph;

import java.util.*;

/**
 * @author aburghelea
 * @since 1/29/13 - 5:05 PM
 */
public class Graph {

    List<Node> nodes;

    public Graph(int nodes) {
        this.nodes = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++)
            this.nodes.add(new Node(i));
    }

    public void defaultPopulate() {
        nodes.get(0).addNeighbour(nodes.get(2));
        nodes.get(0).addNeighbour(nodes.get(5));

        nodes.get(1).addNeighbour(nodes.get(5));

        nodes.get(2).addNeighbour(nodes.get(1));
        nodes.get(2).addNeighbour(nodes.get(3));
        nodes.get(2).addNeighbour(nodes.get(4));

        nodes.get(3).addNeighbour(nodes.get(0));
        nodes.get(3).addNeighbour(nodes.get(6));

        nodes.get(4).addNeighbour(nodes.get(6));

        nodes.get(6).addNeighbour(nodes.get(5));

    }

    public List<Node> BFS(int node) {
        reset();
        Queue<Node> queue = new LinkedList<>();
        List<Node> visitOrder = new LinkedList<>();
        queue.add(nodes.get(node));
        nodes.get(node).state = Node.State.VISITING;
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            for (Node neighbour : currentNode.getNeighbours()) {
                if (neighbour.state == Node.State.UNVISITED) {
                    neighbour.state = Node.State.VISITING;
                    queue.add(neighbour);
                }
            }
            currentNode.state = Node.State.VISITED;
            visitOrder.add(currentNode);
        }

        return visitOrder;
    }

    public List<Node> DFS(int node) {
        reset();
        Stack<Node> stack = new Stack<>();
        List<Node> visitOrder = new LinkedList<>();

        stack.push(nodes.get(node));
        nodes.get(node).state = Node.State.VISITING;
        visitOrder.add(nodes.get(node));
        while (!stack.empty()) {
            Node unvisitedNeighbor;
            Node currentNode = stack.peek();

            if ((unvisitedNeighbor = currentNode.getUnvisitedNeighbor()) != null) {
                unvisitedNeighbor.state = Node.State.VISITING;
                stack.push(unvisitedNeighbor);
                visitOrder.add(unvisitedNeighbor);
            } else {
                stack.pop();
                currentNode.state = Node.State.VISITED;
            }
        }

        return visitOrder;
    }

    public boolean existsRouteBetween(Integer start, Integer end) {
        List<Node> visitedOrder = BFS(start);
        return visitedOrder.contains(nodes.get(end));
    }

    private void reset()
    {
        for (Node node : nodes){
            node.state = Node.State.UNVISITED;
        }
    }
    private void printNodesAndRest(List<Node> visitOrder) {
        reset();
        for (Node node : visitOrder) {
            System.out.print(node.id + " - ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.defaultPopulate();
        List<Node> visitOrder = g.BFS(0);
        g.printNodesAndRest(visitOrder);
        visitOrder = g.DFS(0);
        g.printNodesAndRest(visitOrder);

        if (g.existsRouteBetween(1, 3))
            System.out.println("Exista cale intre 1 si 3");

        if (g.existsRouteBetween(3, 1))
            System.out.println("Exista cale intre 3 si 1");

        if (g.existsRouteBetween(5, 3))
            System.out.println("Exista cale intre 5 si 3");

    }
}
