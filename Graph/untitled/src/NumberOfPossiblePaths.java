import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfPossiblePaths {
    static List<ArrayList<Integer>> graph= new ArrayList();
    static int count;
    static ArrayList<ArrayList<Integer>>listOfPaths=new ArrayList<>();
    public static void main(String[] args) {

        for(int i=0;i<=6;i++){
            graph.add(new ArrayList<Integer>());
        }
        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(1, 5);
        addEdge(2, 3);
        addEdge(2, 5);
        addEdge(3, 4);
        addEdge(3, 6);
        addEdge(3, 5);
        addEdge(4, 5);
        addEdge(4, 6);

        bfs(6);
        System.out.println();
        for(int i=0;i<=6;i++)
            System.out.println(i+"---> "+graph.get(i));

        System.out.println("-----------------paths----------------------");
        findPath(1,4, new ArrayList<>());
        for( ArrayList<Integer> path: listOfPaths){
            System.out.println(path);
        }
    }
    public static void addEdge(int source, int destination){
        if(!graph.get(source).contains(destination))
            graph.get(source).add(destination);

        if(!graph.get(destination).contains(source))
            graph.get(destination).add(source);
    }

    public static void bfs(int x){
        boolean[] visited= new boolean[8];
        Queue<Integer> queue = new LinkedList<>();
        visited[x]=true;
        queue.add(x);

        while(queue.size()!=0){
            x=queue.poll();
            System.out.print(x+", ");
            for(int i=0;i<graph.get(x).size();i++){
                if(!visited[graph.get(x).get(i)]){
                    queue.add(graph.get(x).get(i));
                    visited[graph.get(x).get(i)]=true;
                }
            }
        }

    }

    public static void findPath(int source, int destination, ArrayList<Integer> path){
        if(source == destination){
            path.add(destination);
            listOfPaths.add((ArrayList<Integer>) path.clone());
            path.remove(path.size()-1);
        }
        else if(path.contains(source)){
            return;
        }
        else{
            path.add(source);
            for(int i=0;i<graph.get(source).size();i++){
                findPath(graph.get(source).get(i), destination, path);
            }
            path.remove(path.size()-1);
        }

    }
}