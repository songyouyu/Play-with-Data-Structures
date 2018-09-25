import java.util.TreeMap;

/**
 * Trie字典树基础
 * @author youyusong
 * @date 2018/9/25
 */
public class Trie {

    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得 Trie 中存储的单词数量
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向 Trie 中添加一个新的单词
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (! cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }
}
