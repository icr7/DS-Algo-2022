import java.util.ArrayList;
import java.util.List;

public class AdjacencyList
{
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("hello world!!");

        for(int i=0;i<=5;i++){
           graph.add(new ArrayList<>()) ;
        }
        addEdge(1,2);
        addEdge(1,4);
        addEdge(1,5);
        addEdge(2,4);
        addEdge(2,1);
        addEdge(3,5);
        addEdge(4,1);
        addEdge(4,2);
        addEdge(4,5);
        addEdge(5,1);
        addEdge(5,3);
        addEdge(5,4);

        for(int i=1;i<=5;i++){
            System.out.println(i+" ---> "+graph.get(i).toString());
        }

    }
    public static void addEdge(int source, int destination){
        if(!graph.get(source).contains(destination)) {
            graph.get(source).add(destination);
        }
        if(!graph.get(destination).contains(source)){
            graph.get(destination).add(source);
        }

    }
}
