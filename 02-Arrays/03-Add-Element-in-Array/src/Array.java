/**
 * 向数组中添加元素
 * @author youyusong
 * @date 2018/9/12
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = new int[capacity];
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
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Require index >= 0 and index <= size");
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
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在数组尾部添加一个新元素
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }
}
