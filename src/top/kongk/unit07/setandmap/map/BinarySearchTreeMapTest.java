package top.kongk.unit07.setandmap.map;

/**
 * 描述：对BinarySearchTreeMap进行测试
 *
 * @author kk
 */
public class BinarySearchTreeMapTest {

    public static void main(String[] args) {

        System.out.println("初始化bstMap<String, Integer>");
        BinarySearchTreeMap<String, Integer> bstMap = new BinarySearchTreeMap();

        System.out.println("移除 qwer ");
        bstMap.remove("qwer");
        System.out.println("size = " + bstMap.getSize());


        System.out.println("put kk-123 ");
        bstMap.put("kk", 123);
        System.out.println("size = " + bstMap.getSize());
        System.out.println("是否包含 kk :" + bstMap.contains("kk"));

        System.out.println("移除 kk");
        bstMap.remove("kk");
        System.out.println("是否包含 kk :" + bstMap.contains("kk"));
        System.out.println("size = " + bstMap.getSize());

    }

}
