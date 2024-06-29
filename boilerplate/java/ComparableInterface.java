import java.util.Set;
import java.util.TreeSet;


public class ComparableInterface {
    
    static class Pair implements Comparable<Pair> {
        int first;
        int second;
    
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    
        public int compareTo(Pair a) {
            return this.first - a.first;
        }
    
        public String toString(){
            return "{ first: " + first + ", second: "+ second + "}"; 
        }
    }
    public static void main(String[] args) {
        
        Set<Pair> aset = new TreeSet<>();

        for(int i=0; i<20; i++){
            Pair aPair = new Pair((int)(Math.random()*1000), i);
            aset.add(aPair);
        }

        for(Pair p : aset){
            System.out.println(p);
        }
    }
   
}


