/**
 * 使用虚拟头节点
 * @author youyusong
 * @date 2018/9/19
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    /**
     * 获取链表中元素的个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的 index 位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index> size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node node = new Node( e);
        node.next = prev.next;
        prev.next = node;

        size ++;
    }

    /**
     * 在链表头部添加新元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾部添加元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
