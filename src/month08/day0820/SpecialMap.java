package month08.day0820;

/**
 * @hurusea
 * @create2020-08-20 15:04
 */
public class SpecialMap<K,V> implements BXCMap<K,V> {
    //链表的数组
    Node2<K, V>[] table = null;
    //存储数据个数
    int size;
    //负载因子
    float DEFAULT_LOAD_FACTOR = 0.5f;
    //初始大小
    static int DEFAULT_INITIAL_CAPACITY = 10;

    @Override
    public V put(K key, V value) {
        if (table == null) {
            table = new Node2[DEFAULT_INITIAL_CAPACITY];
        }
        //判断是否需要扩容
        if (size > (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)) {
            resize();
        }
        //拿到下标的位置
        int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
        Node2<K, V> node = table[index];
        //如果该位置没有，就新建对象存入
        if (node == null) {
            node = new Node2<K, V>(key, value, null);
            size++;
        } else {
            //如果已经存在，则拿到链表中的每一个数据判断key是否相同
            Node2<K, V> newNode = node;
            while (newNode != null) {
                if (newNode.getKey().equals(key) || newNode.getKey() == key) {
                    //key相同则覆盖
                    return newNode.setValue(value);
                } else {
                    if (newNode.next == null) {
                        //链表中没有当前key则加入
                        node = new Node2<K, V>(key, value, node);
                        //计数加一
                        size++;
                    }
                }
                newNode = newNode.next;
            }

        }
        table[index] = node;
        return null;
    }


    @Override
    public V get(K k) {
        Node2<K, V> node = getNode(table[getIndex(k, DEFAULT_INITIAL_CAPACITY)], k);
        return node == null ? null : node.value;
    }

    public Node2<K, V> getNode(Node2<K, V> node, K k) {
        while (node != null) {
            if (node.getKey().equals(k)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    public int getIndex(K k, int length) {
        //拿到key的hashCode
        int hashCode = k.hashCode();
        //计算下标位置
        int index = hashCode % length;
        return index;
    }

    private void resize() {
        //新建链式数组，大小为原来的两倍
        Node2<K, V>[] newTable = new Node2[DEFAULT_INITIAL_CAPACITY << 1];
        //遍历原来数值的每一个链表
        for (int i = 0; i < table.length; i++) {
            Node2<K, V> oldNode = table[i];
            //那个链表中的每个Node
            while (oldNode != null) {
                table[i] = null;
                //拿到key
                K oldK = oldNode.key;
                //重新计算下标
                int index = getIndex(oldK, newTable.length);
                //因为需要遍历，要到oldNode的下一个Node
                Node2<K, V> oldNext = oldNode.next;
                //如果newTable的index位置已有有链表了，就放在oldNode的下一个
                oldNode.next = newTable[index];
                //将数据再存到newTable的index位置
                newTable[index] = oldNode;
                //再指向下一个Node，一直循环，知道没有下一个节点为null时停止
                oldNode = oldNext;
            }
        }
        table = newTable;
        DEFAULT_INITIAL_CAPACITY = newTable.length;
    }

    public static void main(String[] args) {
        SpecialMap<String, String> map = new SpecialMap<>();
        map.put("name", "hurusea");
        map.put("age", "24");
        map.put("sex", "male");
        System.out.println(map.get("age"));
        System.out.println(map.get("sex"));
        System.out.println(map.get("name"));

    }


}
