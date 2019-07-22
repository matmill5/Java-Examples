/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Java_Graph_Examples;

/**
 *
 * @author Matthew
 */
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
// Graph is array of adjacency lists.
// Size of array will be V (number of vertices in graph)

    int V;
    LinkedList<Node> adjListArray[];

// Constructor
    Graph(int V) {
        this.V = V;
        // define the size of array as number of vertices
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex such that adjacent nodes can be stored
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
            adjListArray[i].addFirst(new Node(i)); //Initialize 0-100,000 nodes.
        }
    }

// Adds an edge to an undirected graph
    static void addEdge(Graph graph, int src, int dest) {
        //Ensure that we don't create redundant connections
        if (src != dest && graph.adjListArray[src].getFirst().connections < 5 && graph.adjListArray[dest].getFirst().connections < 5) {
            // Add an edge from src to dest.
            graph.adjListArray[src].add(graph.adjListArray[dest].getFirst());
            graph.adjListArray[src].getFirst().setConnections();
            // Since graph is undirected, add an edge from dest to src also
            graph.adjListArray[dest].add(graph.adjListArray[src].getFirst());
            graph.adjListArray[dest].getFirst().setConnections();
        }
    }

// Prints BFS traversal from a given source s and look for node's randNum match
    void BFS(int start, int num) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();
        if (adjListArray[start].peek().randNum == num && visited[start] != true) {
            System.out.println("\nSuccess! Found the random number at node: " + adjListArray[start].peek().id);
            int visitedCounter = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == true) {
                    visitedCounter = visitedCounter + 1;
                }
            }
            System.out.println("Found the random number in " + visitedCounter + " visits");
        }
        // Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            start = queue.poll();
            System.out.print(start + ":" + adjListArray[start].peek().randNum + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Node> i = adjListArray[start].listIterator();
            while (i.hasNext()) {
                int n = i.next().id;
                if (!visited[n]) {
                    if (adjListArray[start].peek().randNum == num) {
                        System.out.println("\nSuccess! Found the random number at node: " + adjListArray[start].peek().id);
                        int visitedCounter = 0;
                        for (int x = 0; x < visited.length; x++) {
                            if (visited[x] == true) {
                                visitedCounter = visitedCounter + 1;
                            }
                        }
                        System.out.println("Found the random number in " + visitedCounter + " visits");
                    }
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
// A function used by DFS

    void dfsRec(int start, boolean visited[], int num) {
        if (adjListArray[start].peek().randNum == num && visited[start] != true) {
            System.out.println("\nSuccess! Found the random number at node: " + adjListArray[start].peek().id);
            int visitedCounter = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == true) {
                    visitedCounter = visitedCounter + 1;
                }
            }
            System.out.println("Found the random number in " + visitedCounter + " visits");
        }
        // Mark the current node as visited and print it
        visited[start] = true;
        System.out.print(start + ":" + adjListArray[start].peek().randNum + " ");
        // Recur for all the vertices adjacent to this vertex
        Iterator<Node> i = adjListArray[start].listIterator();
        while (i.hasNext()) {
            int n = i.next().id;
            if (!visited[n]) {
                dfsRec(n, visited, num);
            }
        }
    }

// The function to do DFS traversal. It uses recursive dfsRec()
    void dfs(int start, int num) {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Call the recursive function to print DFS traversal
        dfsRec(start, visited, num);
    }

// Function to print the adjacency list representation of graph
    static void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Node pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl.id);
            }
            System.out.print("\n" + graph.adjListArray[v].getFirst().connections);
            System.out.println("\n");
        }
    }

// Dij. Algo. Min. Dist. Running out of time, couldn't get it all to work.
    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int start = 0; start < V; start++) {
            if (sptSet[start] == false && dist[start] <= min) {
                min = dist[start];
                minIndex = start;
            }
        }

        return minIndex;
    }

    // Funtion to implement Dijkstra's single source shortest path algorithm
    void dijkstra(Graph graph, int src) {
        int dist[] = new int[V]; // The output array. dist[i] will hold the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++){
                if (!sptSet[v] && graph.adjListArray[u].contains(new Node(v)) && dist[u] != Integer.MAX_VALUE && dist[u] + graph.adjListArray[u].get(v).weight < dist[v]) {
                    dist[v] = dist[u] + graph.adjListArray[u].get(v).weight;
                }
            }
        }
    }
}
