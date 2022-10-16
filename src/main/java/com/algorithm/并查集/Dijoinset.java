package com.algorithm.并查集;

/**
 * @description:TODO
 * @author:Rock
 * @date:2022/8/12
 */
public class Dijoinset {

    public static void main(String[] args) {

    }

}

//1、路径压缩版本
class Dijoinset1 {

    int[] parent;

    //初始化
    void init(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    //查询 x 的 根节点
    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    //合并,把 j 合并到 i 中去，就是把 j 的根结点设为 i 的根节点
    void union(int i, int j) {
        parent[find(j)] = find(i);
    }
}


//2、按秩合并的并查集  秩:树的高度
//应该把简单的树往复杂的树上合并，即把树的深度小的树合并到树的深度大的树中，这样合并之后，每个元素到根结点的距离变成的元素个数最少。
class Dijoinset2 {

    int[] parent, rank;

    //初始化
    void init(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //查询 x 的 根节点
    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    //合并,把 j 合并到 i 中去，就是把j的双亲结点设为i
    void union(int i, int j) {
        //Parent[find(j)] = find(i);
        int x = find(i), y = find(j);
        //y 树 比 x 树高，  x 合并到 y
        if (rank[x] <= rank[y]) {
            parent[x] = y;
        } else {   //x 树 比 y 树高，  y 合并到 x
            parent[y] = x;
        }
        //如果深度相同且根结点不同，以 y 为根结点的子树深度 + 1
        if (rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
    }
}