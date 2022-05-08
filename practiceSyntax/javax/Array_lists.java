package javax;

import java.util.*;

public class Array_lists {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1000);
        queue.add(2000);
        queue.add(3000);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>(10);
        ArrayList<Integer> arr2 = new ArrayList<>(stack);
        System.out.println("Size is : " + arr1.size());
        System.out.println(arr1);
        System.out.println(arr2);

        arr2.add(100);
        arr2.add(1, 200);
        arr2.addAll(queue);
        System.out.println(arr2);

        System.out.println(arr2.contains(100));
        System.out.println(arr2.indexOf(100));
        System.out.println(arr2.indexOf(-100));

        System.out.println("get 100 and get -100");
        System.out.println(arr2.get(1));

        arr2.add(100);
        System.out.println("Remove seq");
        System.out.println("arr2 = " + arr2);
        arr2.remove(0);
        System.out.println("arr2 = " + arr2);
        arr2.remove(new Integer(100));
        System.out.println("arr2 = " + arr2);

        System.out.println("Remove if ");
        arr2.removeIf(a -> a > 100);
        System.out.println("arr2 = " + arr2);

        System.out.println("Replace All");
        arr2.replaceAll(a -> a * 10);
        System.out.println("arr2 = " + arr2);

        arr2.set(3, 1);
        System.out.println("sorting the array");
        System.out.println("arr2 = " + arr2);
        arr2.sort(Integer::compare);
        System.out.println("arr2 = " + arr2);

        System.out.println("get the sublist");
        System.out.println(arr2.subList(1, 2));
        System.out.println("arr2.lastIndexOf(100) " + arr2.lastIndexOf(100));
        System.out.println("Size is : " + arr2.size());
        arr2.clear();
        System.out.println(arr2);
        System.out.println(arr2.isEmpty());
        System.out.println("Size is : " + arr2.size());
    }
}
