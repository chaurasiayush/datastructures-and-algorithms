import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Comparators {

   static class Pair {
        int first;
        int second;
    
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    
        public String toString(){
            return "{ first: " + first + ", second: "+ second + "}"; 
        }
    }
    public static void main(String[] args) {
        // since comparator interface is functional interface, lambdas are possible
        Comparator<Pair> comp = (Pair a, Pair b) ->{
                return a.first - b.first;
            };
        
        // comparators interface can be implemented directly
        Comparator<Pair> comp2 = new Comparator<Pair>() {
            
            public int compare(Pair p1, Pair p2) {
                return p1.first - p2.first;
            }
        };
        
        Set<Pair> aset = new TreeSet<Pair>(comp);

        for(int i=0; i<20; i++){
            Pair aPair = new Pair((int)(Math.random()*1000), i);
            aset.add(aPair);
        }

        for(Pair p : aset){
            System.out.println(p);
        }
    }
}
