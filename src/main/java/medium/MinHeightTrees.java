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
public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] arr : edges){
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> min_map = new HashMap<>();
       
        for(int i = 0; i < n; i++){
            min_map.put(i, new ArrayList<>());
        }
        
        int min_count = 0;
        for(int i = 0; i < n; i++){
            queue.add(i);
            visited[i] = true;
            
            int count = 0;
            while(!queue.isEmpty()){
                int current = queue.poll();
                List<Integer> children = map.get(current);
                for(int x : children){
                    if(!visited[x])
                        queue.add(x);
                }
                count += 1;
            }
            
            min_count = Math.min(count, min_count);
            min_map.get(count).add(i);
        }
        return min_map.get(min_count);
    }
    
    public static void main(String[] args) {
        MinHeightTrees minTrees = new MinHeightTrees();
        int[][] input = {{1,0},{1,2},{1,3}};
        System.out.println(minTrees.findMinHeightTrees(4, input));
    }
}
