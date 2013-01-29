package learning.ctci.treegraph;

import java.util.TreeSet;

/**
 * @author aburghelea
 * @since 1/29/13 - 4:59 PM
 */
public class Node implements Comparable<Node>{
    @Override
    public int compareTo(Node o) {
        return id.compareTo(o.id);
    }

    public Node getUnvisitedNeighbor() {
        for (Node neighbour : neighbours) {
            if (neighbour.state == State.UNVISITED)
                return neighbour;
        }

        return  null;
    }

    enum State {
        VISITED,
        UNVISITED,
        VISITING
    }

    Integer id;
    State state = State.UNVISITED;
    TreeSet<Node> neighbours;

    public Node(Integer id, TreeSet<Node> neighbours) {
        this.id = id;
        this.neighbours = neighbours;
    }

    public Node(Integer id) {
        this(id, new TreeSet<Node>());
    }

    public void addNeighbour(Node neighbour){
        neighbours.add(neighbour);
    }

    public TreeSet<Node> getNeighbours() {
        return neighbours;
    }
}
