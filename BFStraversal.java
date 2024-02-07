import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {
    private int v;
    private ArrayList<ArrayList<Integer>> graph;
    
    Graph(int v) {
        this.v = v;
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    
    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("Adjacent vertices of vertex " + i + ": ");
            for (Integer vertex : graph.get(i)) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int source)
    {
        boolean[] visited= new boolean[v + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[source] = true;
        queue.add(source);

        while(queue.size() !=0)
        {
            int s = queue.poll();
            System.out.print(s + " ");
            for(Integer v : graph.get(s))
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

    }
}

public class BFStraversal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter vertices: ");
        int n = s.nextInt();
        Graph graph = new Graph(n);
        System.out.println("Enter -1 to stop adding edges");
        System.out.println("Enter pair of vertices");

        while (true) {
            System.out.println("\nEntering edge :");
            System.out.println("Enter source vertex : ");
            int u = s.nextInt();
            System.out.println("Enter destination vertex : ");
            int v = s.nextInt();
            if (u == -1 || v == -1) {
                break;
            }

            if (u <= 0 || u >n || v <= 0 || v >n)
            {
                System.out.println("Invalid edge!");
                continue;
            }
            graph.addEdge(u, v);
        }
        graph.print();
        System.out.println("Enter the vertex for bfs traversal :");
        int source = s.nextInt();
        if (source >= 1 && source <= n) {
            System.out.println("BFS traversal starting from vertex " + source + ":");
            graph.bfs(source);
        } else {
            System.out.println("Invalid source vertex!");
        }
    }
}
