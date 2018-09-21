/**
 * 基于二分搜索树的集合
 * @author youyusong
 * @date 2018/9/20
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    public BST<E> bst;

    public BSTSet(){
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
