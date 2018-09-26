/**
 * 第三版并查集 基于 size 的优化
 * @author youyusong
 * @date 2018/9/26
 */
public class UnionFind3 implements UF {

    /**
     * 使用一个数组构建一棵指向父节点的树, parent[i]表示第一个元素所指向的父节点
     */
    private int[] parent;

    /**
     * sz[i]表示以i为根的集合中元素个数
     */
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        // 初始时, 每一个 id[i] 指向自己, 没有合并的元素
        for (int i = 0; i < size; i ++) {
            parent[i] = i;
            sz[i] = 1;
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

        // 不断查询父亲节点, 知道到达根节点, 根节点: p = parent[p]
        while (p != parent[p]) {
            p = parent[p];
        }

        return p;
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

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
