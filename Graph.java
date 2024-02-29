package org.dp;

import java.util.*;
import java.util.stream.Collectors;

class Graph {
    private int n;
    private Map<Integer, List<Integer>> g;
    private Map<Integer, String> v;

    public Graph(int n, Map<Integer, String> v) {
        this.n = n;
        this.g = new HashMap<>();
        this.v = v;

        for (int i : v.keySet()) {
            addVertex(i);
        }
    }

    public void addVertex(int i) {
        g.put(i, new ArrayList<>());
    }

    public void removeVertex(int i) {
        g.remove(i);
        for (Map.Entry<Integer, List<Integer>> entry : g.entrySet()) {
            entry.setValue(entry.getValue().stream().filter(x -> x != i).collect(Collectors.toList()));
        }
    }

    public void addEdge(int u, int v) {
        g.get(u).add(v);
        g.get(v).add(u);
    }

    public void print() {
        Map<String, List<String>> res = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : g.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            res.put(v.get(key), value.stream().map(x -> v.get(x)).collect(Collectors.toList()));
        }
        System.out.println(res);
    }

    public void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        q.add(v);
        visited.put(v, true);

        while (!q.isEmpty()) {
            int ele = q.poll();
            System.out.println(this.v.get(ele));
            List<Integer> list = g.get(ele);

            for (int i : list) {
                if (!visited.containsKey(i)) {
                    visited.put(i, true);
                    q.add(i);
                }
            }
        }
    }

    public void dfs(int v) {
        Map<Integer, Boolean> visited = new HashMap<>();
        dfsHelper(v, visited);
    }

    private void dfsHelper(int v, Map<Integer, Boolean> visited) {
        visited.put(v, true);
        System.out.println(this.v.get(v));
        List<Integer> list = g.get(v);

        for (int i : list) {
            if (!visited.containsKey(i)) {
                dfsHelper(i, visited);
            }
        }
    }
}