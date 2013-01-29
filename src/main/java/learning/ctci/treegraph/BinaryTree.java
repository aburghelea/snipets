package learning.ctci.treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aburghelea
 * @since 1/29/13 - 6:48 PM
 */
public class BinaryTree {

    BinaryNode root;

    public static BinaryNode buildFromList(List<Integer> list) {
        int size = list.size();
        if (size == 0)
            return null;

        if (size == 1)
            return new BinaryNode(list.get(0));

        int index = size / 2;
        BinaryNode node = new BinaryNode(list.get(index));
        node.left = buildFromList(list.subList(0, index));
        node.right = buildFromList(list.subList(index + 1, size));

        return node;
    }

    public static List<LinkedList<BinaryNode>> findNodesByLevel(BinaryNode root) {
        int level = 0;
        List<LinkedList<BinaryNode>> nodesByLevel = new ArrayList<>();
        LinkedList<BinaryNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        nodesByLevel.add(level, currentLevel);

        while (true) {
            currentLevel = new LinkedList<>();
            for (int i = 0; i < nodesByLevel.get(level).size(); i++) {
                BinaryNode node = nodesByLevel.get(level).get(i);
                if (node.left != null)
                    currentLevel.add(node.left);
                if (node.right != null)
                    currentLevel.add(node.right);
            }

            if (currentLevel.size() == 0)
                break;
            else
                nodesByLevel.add(++level, currentLevel);

        }

        return nodesByLevel;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++)
            list.add(i);
        BinaryNode root = BinaryTree.buildFromList(list);
        List<LinkedList<BinaryNode>> levels = BinaryTree.findNodesByLevel(root);
        printLevels(levels);
    }

    private static void printLevels(List<LinkedList<BinaryNode>> levels) {
        for (LinkedList<BinaryNode> level : levels) {
            for (BinaryNode node : level)
                System.out.print(node.index + " ");
            System.out.println();
        }
    }
}
