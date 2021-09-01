import java.util.HashMap;

/**
 * @author sunmengyuan
 * @date 2021-08-31
 * LRU 缓存机制 设计和实现一个 LRU（最近最少使用）缓存数据结构，使它应该支持以下操作：get 和 put。
 * get(key) - 如果 key 存在于缓存中，则获取 key 的 value（总是正数），否则返回 -1。
 * put(key,value) - 如果 key 不存在，请设置或插入 value。
 * 当缓存达到其容量时，它应该在插入新项目之前使最近最少使用的项目作废
 */
public class LatestRecentlyUsedCache<K, V> {
    int cap;
    HashMap<K, V> map;

    public LatestRecentlyUsedCache(int cap) {
        this.cap = cap;
        this.map = new HashMap<>();
    }


    public int get(V val) {

        return -1;
    }

    public void put(K k, V val) {

    }
}
