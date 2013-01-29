package learning.ctci.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author aburghelea
 * @since 1/28/13 - 11:10 PM
 */

class Tower {
    private Stack<Integer> disks;
    private Integer index;

    Tower(Integer index, Integer disks) {
        this.index = index;
        this.disks = new Stack<>();
        initDisks(disks);
    }

    Tower(Integer index) {
        this(index, 0);
    }

    private void initDisks(Integer disks) {
        while (disks > 0) {
            this.disks.push(disks--);
        }
    }

    public void addDisk(Integer number) {
        disks.push(number);
    }

    public Integer topDisk() {
        if (disks.empty())
            return 0;
        return disks.peek();
    }

    public Integer removeTop() {
        if (disks.empty())
            return 0;
        return disks.pop();
    }

    public void moveTopTo(Tower next) {
        Integer top = topDisk();
        Integer base = next.topDisk();

        if (disks.isEmpty() && top > base)
            System.err.println("Can't add " + top + " on top of " + base);
        else {
            System.out.println("Moving " + top + " from " + index + " to " + next.index);
            next.addDisk(removeTop());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> tmp = new Stack<>();
        while (!disks.empty()) {
            Integer disk = disks.pop();
            sb.append(disk).append(" <- ");
            tmp.push(disk);
        }

        while (!tmp.empty()){
            disks.add(tmp.pop());
        }

        sb.append(" -|");

        return sb.toString();
    }
}

public class Hanoi {

    private static final int DISKS = 5;
    List<Tower> towers;
    Integer disks;

    public Hanoi(int disks) {
        towers = new ArrayList<>(3);
        this.disks = disks;
        towers.add(new Tower(1, disks));
        towers.add(new Tower(2));
        towers.add(new Tower(3));
        System.out.println(towers.get(0));

    }

    private void solve(int disks, Tower start, Tower destination, Tower buffer) {
        if (disks > 0) {
            solve(disks - 1, start, buffer, destination);
            start.moveTopTo(destination);
            solve(disks - 1, buffer, destination, start);
        }
    }

    public void solve() {
        solve(disks, towers.get(0), towers.get(1), towers.get(2));
        System.out.println("1) " + towers.get(0));
        System.out.println("2) " + towers.get(1));
        System.out.println("3) " + towers.get(2));
    }

    public Hanoi() {
        this(Hanoi.DISKS);
    }

    public static void main(String[] args) {
        new Hanoi().solve();
    }
}
