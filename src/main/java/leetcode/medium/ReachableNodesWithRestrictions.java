package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ReachableNodesWithRestrictions {

    public static void main(String... args) {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 0, 5 }, { 5, 6 } };
        int[] restricted = { 4, 5 };

        System.out.println("Output : " + reachableNodes(n, edges, restricted));
    }

    private static int reachableNodes(int n, int[][] edges, int[] restricted) {

        int visited[] = new int[n];
        for (int visit : restricted)
            visited[visit] = 1;

        Map<Integer, Set<Integer>> tree = new HashMap<>();

        // **prepare tree from 2-d array */
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], s -> new HashSet<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], s -> new HashSet<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // ** adding first node of tree
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = 1;
            for (int child : tree.get(node)) {
                if (visited[child] != 1) {
                    queue.offer(child);
                }
            }
        }

        int count = 0;
        for (int i : visited)
            if (i == 1)
                count++;

        return count - restricted.length;
    }
}
