package com.solution;

public class UnionFindSet {
    //集合个数
    private int count;
    private int parent[];

    public UnionFindSet(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
        }
        return x;
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        parent[xRoot] = yRoot;
        count--;
    }
}
