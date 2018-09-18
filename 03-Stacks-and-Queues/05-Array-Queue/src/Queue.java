/**
 * 先进先出
 * @author youyusong
 * @date 2018/9/18
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    E getFront();

}
