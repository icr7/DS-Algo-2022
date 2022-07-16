import java.util.ArrayList;
import java.util.List;

public class DfsGraph {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static List<Integer> dfsElement = new ArrayList<>();
    static boolean visited[] = new boolean[7];

    public static void main(String[] args) {
        for (int i = 0; i <= 6; i++) {
            graph.add(new ArrayList<>());
        }
        {
            addEdge(1, 2);
            addEdge(1, 4);
            addEdge(2, 1);
            addEdge(2, 3);
            addEdge(2, 4);
            addEdge(2, 5);
            addEdge(3, 2);
            addEdge(3, 4);
            addEdge(3, 5);
            addEdge(4, 1);
            addEdge(4, 2);
            addEdge(4, 3);
            addEdge(5, 2);
            addEdge(5, 3);
            addEdge(6, 4);
        }
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + "---> " + graph.get(i));
        }
        dfs(1);
        System.out.println("--dfs transvesal from source 1 : " + dfsElement);

    }

    public static void addEdge(int source, int destination) {
        if (!graph.get(source).contains(destination)) {
            graph.get(source).add(destination);
        }
        if (!graph.get(destination).contains(source)) {
            graph.get(destination).add(source);
        }
    }

    public static void dfs(int source) {
        if (dfsElement.size() == 0) {
            dfsElement.add(source);
            visited[source] = true;
        }
        for (int i = 0; i < graph.get(source).size(); i++) {
            if (!visited[graph.get(source).get(i)]) {
                dfsElement.add(graph.get(source).get(i));
                visited[graph.get(source).get(i)] = true;
                dfs(graph.get(source).get(i));
            }
        }
    }
}
