/**
 * 撤销操作和系统栈
 * @author youyusong
 * @date 2018/9/18
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 把对象压入堆栈顶部
     * @param e
     */
    void push(E e);

    /**
     * 移除堆栈顶部的对象，并作为此函数的值返回该对象
     * @return
     */
    E pop();

    /**
     * 查看堆栈顶部的对象，但不从堆栈中移除它
     * @return
     */
    E peek();

}
