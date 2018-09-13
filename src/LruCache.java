import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache extends LinkedHashMap<Integer,Integer>{
    private int mCapacity;
    public LruCache(int capacity) {

        super(capacity,1,true);        mCapacity = capacity;
    }

    public int get(int key) {
        Integer a = super.get(key);
        return a==null?-1:a;
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    /**
     * 返回值为true,删除map尾部元素,在新元素插入时触发
     * @param eldest 即将被删除的元素
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        System.out.println("删除"+eldest.getKey()+"---"+eldest.getValue());
        return this.size()>mCapacity;
    }

    public static void main(String[] args){
        System.out.println("null");
        LruCache cache = new LruCache(2);

        System.out.println(cache.get(2));
        System.out.println("null");cache.put(2,6);
        System.out.println(cache.get(1));
        System.out.println("null");cache.put(1,5);
        System.out.println("null");cache.put(1,2);
        System.out.println("null");cache.put(3,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
