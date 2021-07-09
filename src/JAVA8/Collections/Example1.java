package JAVA8.Collections;

import java.util.*;

public class Example1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("Add");
        list.add("Sub");
        list.add("SSS");
        //Iterator(list);
        //forEach(list);
        System.out.println("Tree Map Example!\n");
        TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
        tMap.put(1, "Sunday");
        tMap.put(2, "Monday");
        tMap.put(3, "Tuesday");
        tMap.put(4, "Wednesday");
        tMap.put(5, "Thursday");
        tMap.put(6, "Friday");
        tMap.put(7, "Saturday");
        treeMap(tMap);

    }

    //iterator
    private static void Iterator(ArrayList list){
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(" Value : "+ it.next());
        }
    }

    //entry set
    private static void forEach(ArrayList list){
        for (Object str: list) {
            System.out.println(str);
        }
    }

    //entryset
    private static void treeMap(TreeMap tree){
        /*for (Map.Entry<Integer, String> set : tree.entrySet()) {
            Integer key= set.getKey();
        }*/
        /*tree.entrySet().iterator().forEachRemaining(
                System.out::println
        );*/

        Set<Map.Entry<Integer, String>> entries = tree.entrySet();
        for (Map.Entry<Integer, String> entry: entries)
        {
            Integer key = (Integer)entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "=" + value);
        }
    }
}
