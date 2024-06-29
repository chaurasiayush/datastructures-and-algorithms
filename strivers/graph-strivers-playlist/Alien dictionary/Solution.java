// Link: https://www.naukri.com/code360/problems/alien-dictionary_630423

import java.util.*;
public class Solution {
    public static int [] topo(ArrayList<HashSet<Integer>> adj, int k) {
        int topoOrder[] = new int[k];
        int index = 0;
        int indegree[] = new int[k];

        for(int i=0; i<k; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }

        // find which has indegree as 0, add it to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<k; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topoOrder[index++] = node;

            for(int ad : adj.get(node)) {
                indegree[ad] --;
                if(indegree[ad] == 0) {
                    q.add(ad);
                }
            }
        }

        return topoOrder;
    }

    public static int[] getOrder(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n = Math.min(n1, n2);

        for(int i=0; i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return new int[]{s1.charAt(i) - 'a', s2.charAt(i)-'a'};
            }
        }
        return new int[0];
    }

    public static String getAlienLanguage(String []dictionary, int k) {
        int n = dictionary.length;
        // graph
        ArrayList<HashSet<Integer>> adj = new ArrayList<>(k);
        for(int i=0; i<k; i++) {
            adj.add(new HashSet<Integer>());
        }

        for(int i=0; i<n-1; i++) {
            // we will compare every two strings to find out relative order of first different char in those
            int order[] = getOrder(dictionary[i], dictionary[i+1]);
            if(order.length > 0) {
                //build a directed graph according to the order (converted char to int )
                adj.get(order[0]).add(order[1]);
            } 
        }

        // apply topo sort
        int ans[] = topo(adj, k);
        String to = "";
        for(int a : ans){
            to += (char) ('a' + a);
        }

        return to;
    }
}