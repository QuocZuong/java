
// src: https://www.spoj.com/problems/MST/
// NOTE: The src is in Sphere online judge so class Main is required to compile
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Nodes, Edges, first, second;
        long adjMatrix[][], weight;
        Nodes = sc.nextInt();
        Edges = sc.nextInt();
        adjMatrix = new long[Nodes][Nodes];
        for (long i = 0; i < Edges; i++) {
            first = sc.nextInt() - 1; // first node
            second = sc.nextInt() - 1; // second node
            weight = sc.nextLong(); // weight
            adjMatrix[first][second] = weight;
            adjMatrix[second][first] = weight;
        }

        SpanningTree(adjMatrix);
    }

    public static void SpanningTree(long[][] adjMatrix) {
        int vertices = adjMatrix.length;

        long key[] = new long[vertices];
        boolean visited[] = new boolean[vertices];
        int prev[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = Long.MAX_VALUE;
            prev[i] = -1;
        }
        key[0] = 0;// Assume every node has 1 Edge so start at Node 0
        for (long i = 0; i < vertices - 1; i++) {
            int minVertex = findMinVertex(key, visited);

            visited[minVertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && adjMatrix[minVertex][j] != 0 && adjMatrix[minVertex][j] < key[j]) {
                    key[j] = adjMatrix[minVertex][j];
                    prev[j] = minVertex;
                }
            }
        }
        long totalWeight = 0;
        // Output the spanning tree:
        for (int i = 0; i < vertices; i++) {
            if (prev[i] != -1) {
                // System.out.println(prev[i] + " --> " + i + " : " + adjMatrix[i][prev[i]]);
                totalWeight += adjMatrix[i][prev[i]];
            }
        }
        System.out.println(totalWeight);
    }

    public static int findMinVertex(long[] key, boolean visited[]) {
        int minVertex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && (minVertex == -1 || key[i] < key[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}