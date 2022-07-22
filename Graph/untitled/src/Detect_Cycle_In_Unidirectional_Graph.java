import java.util.ArrayList;

public class Detect_Cycle_In_Unidirectional_Graph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static boolean cyclic;
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(1,2);
        addEdge(2,3);
        addEdge(3,4);
        addEdge(4,1);


        for(int i=0;i<5;i++)
        System.out.println(i+" ------> "+graph.get(i));

        isCyclic();
        System.out.println("Is cyclic : "+cyclic);

    }

    public static void isCyclic(){
        visited= new boolean[5];
        for (int i=0;i<5;i++) {
            if(!visited[i])
            isCyclic(i, -1);
        }
    }

    public static void isCyclic(int source, int parent){
        visited[source]= true;
        for(int i=0;i<graph.get(source).size();i++){
            if(!visited[graph.get(source).get(i)]){
                isCyclic(graph.get(source).get(i),source);
            }
            else if(graph.get(source).get(i)!=parent){
                cyclic=true;
            }
        }
    }
    public static void addEdge(int source, int destination){
        if(!graph.get(source).contains(destination)){
            graph.get(source).add(destination);
        }
        if(!graph.get(destination).add(source)){
            graph.get(destination).add(source);
        }
    }
}
