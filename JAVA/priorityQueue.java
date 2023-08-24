import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueue {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Student>pq=new PriorityQueue<>();
        pq.add(new Student("Anay",459));
        pq.add(new Student("Shrija",1));
        System.out.println( pq.peek().name+"->"+pq.remove().rank);
        System.out.println( pq.peek().name+"->"+pq.remove().rank);
    }
}
