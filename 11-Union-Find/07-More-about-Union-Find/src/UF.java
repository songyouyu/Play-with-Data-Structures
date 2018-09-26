/**
 * @author youyusong
 * @date 2018/9/25
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
