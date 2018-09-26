/**
 * 第二版并查集 Quick Union
 * @author youyusong
 * @date 2018/9/26
 */
public class UnionFind2 implements UF {

    /**
     * 使用一个数组构建一棵指向父节点的树, parent[i]表示第一个元素所指向的父节点
     */
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        // 初始时, 每一个 id[i] 指向自己, 没有合并的元素
        for (int i = 0; i < size; i ++) {
            parent[i] = i;
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

        parent[pRoot] = qRoot;
    }
}
