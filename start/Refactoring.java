package tourism.start;

import java.util.LinkedList;
import java.util.List;

public class Refactoring {

    public static void main(String args[]) {

        List<Integer> list = getList();

        printList(list);
    }

    private static List<Integer> getList() {
        List<Integer> list = new LinkedList<>();

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        return list;
    }

    private static void printList(List<Integer> list) {
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }
}

