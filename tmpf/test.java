import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.*;;

class A {
    long a;

    public A(long a){
        this.a = a;
    }

    // public int hashCode(){
    //     return 101010101;
    // }

    public boolean equals(Object o){
        return true; //this.hashCode() == o.hashCode();
    }
}

public class test {

    private static void memstats () {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        
        // Get the heap memory usage
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        
        // Get the non-heap memory usage
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        // Convert bytes to megabytes (MB)
        long bytesToMB = 1024 * 1024;
        
        // Print heap memory usage details in MB
        System.out.println("Heap Memory Usage:");
        System.out.println("  Initial: " + heapMemoryUsage.getInit() / bytesToMB + " MB");
        System.out.println("  Used: " + heapMemoryUsage.getUsed() / bytesToMB + " MB");
        System.out.println("  Committed: " + heapMemoryUsage.getCommitted() / bytesToMB + " MB");
        System.out.println("  Max: " + (heapMemoryUsage.getMax() == -1 ? "undefined" : heapMemoryUsage.getMax() / bytesToMB + " MB"));

        // Print non-heap memory usage details in MB
        System.out.println("Non-Heap Memory Usage:");
        System.out.println("  Initial: " + nonHeapMemoryUsage.getInit() / bytesToMB + " MB");
        System.out.println("  Used: " + nonHeapMemoryUsage.getUsed() / bytesToMB + " MB");
        System.out.println("  Committed: " + nonHeapMemoryUsage.getCommitted() / bytesToMB + " MB");
        System.out.println("  Max: " + (nonHeapMemoryUsage.getMax() == -1 ? "undefined" : nonHeapMemoryUsage.getMax() / bytesToMB + " MB"));
    
    }
     
    public static void main(String[] args) {
        String input1 = "Abcde";
        int input2 = 2;
        int input3 = 2;

        // System.out.println(getTurns(input1, input2, input3));

        // int arr[] = new int[2];
        // LinkedList<Integer> a;
        // Collection
        List<Integer> darr = new ArrayList<>();
        TreeSet<Integer> tset = new TreeSet<>();
        HashSet<Integer> hset = new HashSet<>();
        LinkedHashSet<Integer> lhset = new LinkedHashSet<>();

        lhset.add(1);
        lhset.add(5);
        lhset.add(6);
        lhset.add(3);
        lhset.add(2);
        lhset.add(9);

        Iterator lhit = lhset.iterator();
        // while(lhit.hasNext()){
        //     System.out.println(lhit.next());
        // }

        lhset.iterator();
        tset.iterator();
        darr.add(12);
        darr.add(13);
        darr.add(122);
        darr.add(11);
        darr.add(2);
        darr.add(62);
        darr.add(52);
        // Map<Character, Integer> mp = new TreeMap<>();
        // Integer[] nb = mp.values().toArray(new Integer[0]);
        // mp.keySet();
        // PriorityQueue<Integer> pq;
        // a.removeFirstOccurrence(1);
        // String mst = 1 + " " + 2;
        // a.addFirst(null);
        // Arrays.sort(nb, (aaa, b) -> b-aaa);
        // Comparator.comparingInt ;4
        Iterator<Integer> d = darr.iterator();
        ListIterator<Integer> dl = darr.listIterator();
        // d.next();
        // System.out.println(d.next());
        // System.out.println(dl.next());
        // System.out.println(darr);
        // dl.set(99);
        // System.out.println(darr);
        // // dl.
        // System.out.println(dl.previous());
        // System.out.println(dl.next());
        // System.out.println(dl.next());
        // System.out.println(dl.previousIndex());


        Map<Integer,Integer> map = new HashMap<>();
        ConcurrentSkipListMap<Integer,Integer> cslmap = new ConcurrentSkipListMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);


        Set s = new HashSet();

        for(int i=0; i<99999; i++){
            String s1 = new String("ABC");
            s.add(s1);
        }


        Integer

        System.out.println(s.size());
    }
    
}
