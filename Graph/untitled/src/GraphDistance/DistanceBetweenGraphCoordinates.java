package GraphDistance;

import java.util.*;

public class DistanceBetweenGraphCoordinates {
    static List<ArrayList<Integer>> graph = new ArrayList();
    static int count;
    static ArrayList<ArrayList<Integer>> listOfPaths = new ArrayList<>();
    static HashMap<Integer, Coordinate> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(1, new Coordinate(8, 0));
        map.put(2, new Coordinate(0, 2));
        map.put(3, new Coordinate(-3, 0));
        map.put(4, new Coordinate(0, -3));
        map.put(5, new Coordinate(0, 0));
        map.put(6, new Coordinate(-4, -4));

        for (int i = 0; i <= 6; i++) {
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

        System.out.println("------------------Adjacency Network List-----------");
        for (int i = 0; i <= 6; i++){
            System.out.println(i + "---> " + graph.get(i));
        }

        System.out.println("-----------------path between 1 to 6 ----------------------");
        findPath(1, 6, new ArrayList<>());
        ArrayList<Integer> minPath = new ArrayList<>();
        ArrayList<Integer> maxPath = new ArrayList<>();
        double minDistance = Integer.MAX_VALUE;
        double maxDistance = Integer.MIN_VALUE;

        for (ArrayList<Integer> path : listOfPaths) {
            System.out.println(path + " --> " + calculateDistance(path));
            if (calculateDistance(path) <= minDistance) {
                minDistance = calculateDistance(path);
                minPath = path;
            }
            if (calculateDistance(path) >= maxDistance) {
                maxDistance = calculateDistance(path);
                maxPath = path;
            }
        }

        System.out.println("------------MAX/MIN PATH-between 1 to 6 --------------");
        System.out.println("shortest path : " + minPath + " distance : " + minDistance);
        System.out.println("longest path : " + maxPath + " distance : " + maxDistance);
    }

    private static double calculateDistance(ArrayList<Integer> path) {
        double distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            distance += Math.sqrt(Math.pow((map.get(path.get(i)).getX() - map.get(path.get(i + 1)).getX()), 2) + Math.pow((map.get(path.get(i)).getY() - map.get(path.get(i + 1)).getY()), 2));
        }
        return distance;
    }

    public static void addEdge(int source, int destination) {
        if (!graph.get(source).contains(destination))
            graph.get(source).add(destination);

        if (!graph.get(destination).contains(source))
            graph.get(destination).add(source);
    }

    public static void findPath(int source, int destination, ArrayList<Integer> path) {
        if (source == destination) {
            path.add(destination);
            listOfPaths.add((ArrayList<Integer>) path.clone());
            path.remove(path.size() - 1);
        } else if (path.contains(source)) {
            return;
        } else {
            path.add(source);
            for (int i = 0; i < graph.get(source).size(); i++) {
                findPath(graph.get(source).get(i), destination, path);
            }
            path.remove(path.size() - 1);
        }

    }
}

class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}