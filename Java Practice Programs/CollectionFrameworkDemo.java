
import java.util.*;

public class CollectionFrameworkDemo {

    public static void main(String[] args) {

        // HashMap (unordered_map)
        System.out.println("=== HashMap ===");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Two", 22);
        System.out.println(hashMap);
        System.out.println("Get 'Two': " + hashMap.get("Two"));
        System.out.println("Contains key 'One': " + hashMap.containsKey("One"));
        hashMap.remove("Three");
        System.out.println("After removal: " + hashMap);
        
        // TreeMap (map)
        System.out.println("\n=== TreeMap ===");
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        treeMap.put("Four", 4);
        System.out.println(treeMap);
        
        // LinkedHashMap
        System.out.println("\n=== LinkedHashMap ===");
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);
        System.out.println(linkedHashMap);

        // HashSet (unordered_set)
        System.out.println("\n=== HashSet ===");
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 1));
        System.out.println(hashSet);

        // TreeSet (set)
        System.out.println("\n=== TreeSet ===");
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
        treeSet.add(0);
        System.out.println(treeSet);

        // LinkedHashSet
        System.out.println("\n=== LinkedHashSet ===");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(4, 3, 2, 1, 4));
        System.out.println(linkedHashSet);

        // ArrayList (list)
        System.out.println("\n=== ArrayList ===");
        ArrayList<String> arrayList = new ArrayList<>(List.of("a", "b", "c"));
        arrayList.add("d");
        arrayList.remove("b");
        System.out.println(arrayList);

        // Stack
        System.out.println("\n=== Stack ===");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);

        // Queue (LinkedList)
        System.out.println("\n=== Queue ===");
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue);

        // Deque (ArrayDeque)
        System.out.println("\n=== Deque ===");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.removeFirst();
        System.out.println(deque);

        // Vector
        System.out.println("\n=== Vector ===");
        Vector<String> vector = new Vector<>();
        vector.add("X");
        vector.add("Y");
        vector.add("Z");
        System.out.println(vector);

        // 2D Vector
        System.out.println("\n=== 2D Vector ===");
        Vector<Vector<Integer>> vec2D = new Vector<>();
        for (int i = 0; i < 3; i++) {
            Vector<Integer> row = new Vector<>();
            for (int j = 0; j < 3; j++) row.add(i * j);
            vec2D.add(row);
        }
        System.out.println(vec2D);

        // Custom sort 2D Vector using lambda
        System.out.println("\n=== Custom Sort 2D Vector by Sum of Rows ===");
        vec2D.sort((v1, v2) -> Integer.compare(v1.stream().mapToInt(Integer::intValue).sum(), v2.stream().mapToInt(Integer::intValue).sum()));
        System.out.println(vec2D);

        // PriorityQueue as Min Heap
        System.out.println("\n=== Min Heap ===");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(4);
        minHeap.add(1);
        minHeap.add(7);
        System.out.println(minHeap.peek());

        // PriorityQueue as Max Heap
        System.out.println("\n=== Max Heap ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(7);
        System.out.println(maxHeap.peek());
    }
}
