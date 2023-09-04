import java.util.*;
public class Graph {
    static int size;
static class Edge{
    int src;
    int dest;
    int wt;
    Edge(int src,int dest,int wt){
        this.dest=dest;
        this.src=src;
        this.wt=wt;
        if(dest>src)
            size++;
    }
}
public static void BFSTraversal(ArrayList<Edge>[] graph){
    Queue <Integer>s=new LinkedList<>();
    boolean visited[]=new boolean[graph.length];
    int i=0;s.add(0);

      while(i<graph.length) {
          if(s.peek()!=null&&!visited[s.peek()]){
          for (int j = 0; j < graph[i].size(); j++)
              s.add(graph[i].get(j).dest);
          visited[i] = true;
          System.out.println(i);
          }
          s.remove();
          if(s.peek()==null)
              break;
          i=s.peek();
      }

}

  public static void DFSTraversel(ArrayList<Edge>[]graph, int idx,boolean vis[]){
      System.out.print(idx+"  ");
      vis[idx] = true;
      for(int i=0;i<graph[idx].size();i++) {

          if (!vis[graph[idx].get(i).dest]) {
              DFSTraversel(graph, graph[idx].get(i).dest, vis);
          }
      }
}
 public static boolean hasPath(int key, ArrayList<Edge>[]graph, int startidx, boolean vis[]){
    boolean b=false;
    if(key== startidx)
        return true;
    vis[startidx]=true;
    for(int i = 0; i<graph[startidx].size(); i++){
        if(!vis[graph[startidx].get(i).dest])
            b=hasPath(key,graph,graph[startidx].get(i).dest,vis);
        if(b)
            break;
    }
    return b;
 }


    public static void main(String[] args) {
    int v=7;
        ArrayList<Edge>[] graph =new ArrayList[v];
        for(int i=0;i<v;i++)
            graph[i]=new ArrayList<>();
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
   boolean vis[]=new boolean[v];

        System.out.println(hasPath(9,graph,4,vis));
    }
}
