import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsGraph {
    static List<ArrayList<Integer>> graph= new ArrayList();

    public static void main(String[] args) {

        for(int i=0;i<=5;i++){
            graph.add(new ArrayList<Integer>());
        }
            addEdge(1, 2);
            addEdge(1, 4);
            addEdge(1, 5);
            addEdge(2, 4);
            addEdge(2, 1);
            addEdge(3, 5);
            addEdge(4, 1);
            addEdge(4, 2);
            addEdge(4, 5);
            addEdge(5, 1);
            addEdge(5, 3);
            addEdge(5, 4);

       bfs(4);
    }
    public static void addEdge(int source, int destination){
        if(!graph.get(source).contains(destination))
        graph.get(source).add(destination);

        if(!graph.get(destination).contains(source))
        graph.get(destination).add(source);
    }

    public static void bfs(int x){
         boolean[] visited= new boolean[6];
         visited[x]=true;
         Queue<Integer> queue = new LinkedList<>();
         queue.add(x);

         do{
             for(int i=0;i<graph.get(queue.peek()).size();i++){
                 if(!visited[graph.get(queue.peek()).get(i)]){
                     queue.add(graph.get(queue.peek()).get(i));
                     visited[graph.get(queue.peek()).get(i)]=true;
                 }
             }
             System.out.print(queue.poll()+", ");
         }
         while(queue.size()!=0);
    }
}