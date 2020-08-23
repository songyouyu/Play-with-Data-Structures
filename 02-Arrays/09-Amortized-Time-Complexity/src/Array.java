
/**
 * 均摊复杂度  防止复杂度的震荡
 * @author youyusong
 * @date 2018/9/12
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在index索引的位置添加一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index >= 0 and index <= size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        // 把 index 位置后的元素都往后移一位
        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 在数组头部添加一个新元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在数组尾部添加一个新元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取 index 索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 修改 index 索引位置的元素
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否含有元素 e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < data.length;i ++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素 e 所在的索引位置, 如何不存在, 则返回 -1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < data.length; i ++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组中删除 index 位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E removeElement = data[index];
        for (int i = index + 1; i < size; i ++) {
            data[i - 1] = data[i];
        }
        size --;

        data[size] = null;
        // 防止增加和删除元素时, 导致数组频繁的 resize 操作
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return removeElement;
    }

    /**
     * 将数组空间的容量变成 newCapacity 大小
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
