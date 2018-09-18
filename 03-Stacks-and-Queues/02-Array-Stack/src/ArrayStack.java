/**
 * @author youyusong
 * @date 2018/9/18
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    private ArrayStack() {
        array = new Array<E>();
    }

    private ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
}
