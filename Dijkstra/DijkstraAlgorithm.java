
//src: https://oj.vnoi.info/problem/FLOYD
import java.util.Scanner;
import java.util.Stack;

public class DijkstraAlgorithm {
    final static int Inf = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, K;
        N = sc.nextInt(); // so node
        M = sc.nextInt(); // so canh
        K = sc.nextInt(); // so cau hoi
        int adjMatrix[][] = new int[N][N];
        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            int weight = sc.nextInt();
            adjMatrix[first - 1][second - 1] = weight;
            adjMatrix[second - 1][first - 1] = weight;
        }
        while (K-- != 0) {
            int type = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            dijkstra(adjMatrix, start - 1, end - 1, type);
        }
    }

    public static void dijkstra(int[][] adjMatrix, int start, int end, int type) {
        int vertices = adjMatrix.length;
        int prev[] = new int[vertices]; // luu tru nut truoc no
        boolean visited[] = new boolean[vertices];
        int dist[] = new int[vertices]; // luu tru khoang cach ngan nhat tu nut xuat phat den moi nut

        for (int i = 0; i < vertices; i++) {
            if (i != start) {
                dist[i] = Inf;
            }
            prev[i] = -1;
        }
        for (int i = 0; i < vertices; i++) {
            int minVerTex = findMinVertex(dist, visited);
            visited[minVerTex] = true;

            // Update the distance between vertices
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && adjMatrix[minVerTex][j] != 0 && dist[minVerTex] != Inf) {
                    int newDist = dist[minVerTex] + adjMatrix[minVerTex][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                        prev[j] = minVerTex;
                    }
                }
            }
        }

        // Output
        if (type == 0) {
            System.out.print(dist[end]);
        } else if (type == 1) {
            Stack<Integer> stack = new Stack<>();
            while (end != -1) {
                stack.push(end + 1);
                end = prev[end];
            }
            System.out.print(stack.size());
            while (!stack.isEmpty()) {
                System.out.print(" " + stack.pop());
            }
        }
        System.out.println();
    }

    public static int findMinVertex(int dist[], boolean visited[]) {
        int minVerTex = -1;
        int len = dist.length;
        for (int i = 0; i < len; i++) {
            if (!visited[i] && (minVerTex == -1 || dist[i] < dist[minVerTex])) {
                minVerTex = i;
            }
        }
        return minVerTex;
    }

}