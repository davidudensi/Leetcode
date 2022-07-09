/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author hp
 */
public class MinHeightTrees2 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new LinkedList<>();
        if (n < 1) {
            return result;
        }
        if (n == 1) {
            result.add(0);
            return result;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        List<List<Integer>> map = new ArrayList<>();
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] arr : edges) {
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
            degrees[arr[0]]++;
            degrees[arr[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            while (size-- > 0) {
                int current = queue.poll();
//                List<Integer> adj = map.get(current);
                for (int a : map.get(current)) {
                    degrees[a]--;
                    if (degrees[a] == 1) {
                        queue.add(a);
                    }
                }
            }
        }

        result.addAll(queue);
        return result;
    }

    public static void main(String[] args) {
        MinHeightTrees2 minTrees = new MinHeightTrees2();
        int[][] input = {{1, 0}, {1, 2}, {1, 3}};
        int[][] input2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(minTrees.findMinHeightTrees(6, input2));
    }
}
