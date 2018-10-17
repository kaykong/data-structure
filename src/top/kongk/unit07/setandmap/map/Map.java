package top.kongk.unit07.setandmap.map;

/**
 * 描述：map接口
 *
 * @author kk
 */
public interface Map<K, V> {

    /**
     * 获取map中key-value的数量
     *
     * @param
     * @return int
     */
    int getSize();

    /**
     * map是否是空的
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 把 key-value 放入map中, 如果key已经存在了, 就把旧的value更新为新的value
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * 移除 key 及其对应的 value
     *
     * @param key
     * @return V
     */
    V remove(K key);

    /**
     * map中是否包含key
     *
     * @param key
     * @return boolean
     */
    boolean contains(K key);

    /**
     * 根据key获取value, 如果key不存在返回null
     *
     * @param key
     * @return V value或者null
     */
    V get(K key);

}
