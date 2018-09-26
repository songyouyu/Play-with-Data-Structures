/**
 * 第一版并查集 Quick Find
 * 本质就是一个数组
 * @author youyusong
 * @date 2018/9/26
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        // 初始时, 每一个 id[i] 指向自己, 没有合并的元素
        for (int i = 0; i < size; i ++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素 p 所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        return id[p];
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
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        // 合并过程需要遍历一遍所有元素, 将两个元素的所属集合编号合并
        for (int i = 0; i < id.length; i ++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
