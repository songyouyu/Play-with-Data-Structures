/**
 * 在链表中添加元素
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

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
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
     * 在链表头添加新的元素
     * @param e
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;

        size ++;
    }

    /**
     * 在链表的 index 位置添加新的元素(不常用的操作)
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        if (index == 0) {
            addFirst(e);
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i ++) {
            prev = prev.next;
        }
        Node node = new Node( e);
        node.next = prev.next;
        prev.next = node;

        size ++;
    }

    /**
     * 在链表尾部添加新的元素
     */
    public void addLast(E e) {
        add(size, e);
    }
}
