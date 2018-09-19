/**
 * @author youyusong
 * @date 2018/9/19
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
