/**
 * 第六版并查集 路径压缩(递归算法)
 * @author youyusong
 * @date 2018/9/26
 */
public class UnionFind6 implements UF {

    /**
     * 使用一个数组构建一棵指向父节点的树, parent[i]表示第一个元素所指向的父节点
     */
    private int[] parent;

    /**
     * rank[i]表示以i为根的集合所表示的树的层数
     */
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        // 初始时, 每一个 id[i] 指向自己, 没有合并的元素
        for (int i = 0; i < size; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素 p 所对应的根节点
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        // 不断查询父亲节点, 直到到达根节点, 根节点: p = parent[p]
        while (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    /**
     * 查看元素 p 和元素 q 是否属于同一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素 p 和元素 q 所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            // 此时需要维护 rank 的值
            rank[qRoot] += 1;
        }
    }
}
