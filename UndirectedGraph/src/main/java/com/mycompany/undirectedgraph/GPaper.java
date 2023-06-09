package com.mycompany.undirectedgraph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ce171000 Le Quoc Vuong thay oi vi li do MacOS khong xai duoc
 * getResouce() method khong xai duoc nen em khong set icon thay thong cam neu
 * thay khong run duoc vi no bao loi maven thi thay tao project moi roi copy
 * file em dan vao nha thay (loi nay thinh thoang moi bi vi file pom.xml) cam on
 * thay rat nhieu
 */
public class GPaper extends JPanel {

    public static final int MAX_VERTEX = 50;
    public static final String SEPARATOR = " ";

    private JTextArea txtGraphInfo = null;

    private int graphType = 0;

    private int NumberOfVertices = 0;
    private int[][] graph;
    private ArrayList<GVertex> vertices;
    private ArrayList<GEdge> edges;
    private int startIndex = -1, stopIndex = -1;
    private int edgeValue = 1;

    private Graphics2D g = null;
    private int mouseX, mouseY, selectedVertexIndex = -1, selectedEdgeIndex = -1;
    private boolean isShift = false, isCtrl = false, isALT = false, isRightClicked = false;

    private String result = ""; //luu ket qua bfs dfs
    private boolean[] isVisited; //check xem da duyet hay chua
    private Queue<Integer> q; //luu cac dinh cua do thi
    private Stack<Integer> s; //luu cac dinh cua do thi

    public GPaper() {
        distance = new int[MAX_VERTEX];
        theVertexBefore = new int[MAX_VERTEX];
        q = new LinkedList<Integer>();
        s = new Stack<Integer>();
        isVisited = new boolean[MAX_VERTEX];

        traversalReset();

        this.graph = new int[MAX_VERTEX][MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                this.graph[i][j] = 0;
            }
        }
        this.NumberOfVertices = 0;
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();

        this.mouseX = 0;
        this.mouseY = 0;
        this.selectedVertexIndex = -1;
        this.selectedEdgeIndex = -1;
        this.addMouseMotionListener(new MouseMotionAdapter() { //dung de luu toa do chuot

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                mouseX = e.getX();
                mouseY = e.getY();
                moveVertex_dragged();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                mouseX = me.getX();
                mouseY = me.getY();

                isCtrl = me.isControlDown();
                isShift = me.isShiftDown();
                isALT = me.isAltDown();
                isRightClicked = me.getModifiers() == MouseEvent.BUTTON3_MASK;
                checkMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                super.mousePressed(me);
                mouseX = me.getX();
                mouseY = me.getY();
                moveVertex_start();
            }
        });
    }

    private void traversalReset() {
        result = "";
        for (int i = 0; i < MAX_VERTEX; i++) {
            isVisited[i] = false;
        }
        q.clear();
        s.clear();
    }

    private void moveVertex_start() {
        selectedVertexIndex = findVertexByLocation(mouseX, mouseY);

    }

    private void moveVertex_dragged() {
        if (selectedVertexIndex > -1) { // co dinh duoc chon
            this.vertices.get(selectedVertexIndex).setX(mouseX);    //cap nhat x y theo toa do con chuot
            this.vertices.get(selectedVertexIndex).setY(mouseY);
            repaint();
        }
    }

    public int findVertexByLocation(int mouseX, int mouseY) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).isInside(mouseX, mouseY)) { // di qua cac dinh cua arraylist va kiem tra xem toa do x, y co nam trong dinh nao do k
                return i;
            }
        }
        return -1;
    }

    public int findVertexByValue(int v) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getValue() == v) {
                return i;
            }
        }
        return -1;
    }

    public int findEdgeByVertex(int from, int to) {
        GEdge edge;
        for (int i = 0; i < edges.size(); i++) {
            edge = edges.get(i);
            if ((edge.getStart().getValue() == from && edge.getEnd().getValue() == to)
                    || edge.getStart().getValue() == to && edge.getEnd().getValue() == from) {
                return i;
            }
        }
        return -1;
    }

    public int findEdgeByLocation(int mouseX, int mouseY) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).isInside(mouseX, mouseY)) {
                return i;
            }
        }
        return -1;
    }

    public int getNumberOfVertices() {
        return NumberOfVertices;
    }

    public void setNumberOfVertices(int NumberOfVertices) {
        this.NumberOfVertices = NumberOfVertices;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

    public ArrayList<GVertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<GVertex> vertices) {
        this.vertices = vertices;
    }

    public void clear() {
        for (int i = 0; i < NumberOfVertices; i++) {
            for (int j = 0; j < NumberOfVertices; j++) {
                graph[i][j] = 0;
            }
        }
        this.vertices.clear();
        this.edges.clear();
        NumberOfVertices = 0;
        updateGraphInfo();
        repaint();
    }

    public void setGraphType(int type) {
        this.graphType = type;
        updateGraphInfo();
    }

    private void updateGraphInfo() { //dung de display len graph information
        String giStr = "";
        if (this.graphType == 0) { //matrix
            giStr += this.NumberOfVertices + "";
            for (int i = 0; i < this.NumberOfVertices; i++) {
                giStr += "\n" + graph[i][0];
                for (int j = 1; j < this.NumberOfVertices; j++) {
                    giStr += SEPARATOR + graph[i][j];
                }
            }
        } else { //list
            int countEdge = 0;
            for (int i = 0; i < this.NumberOfVertices; i++) {
                for (int j = i + 1; j < this.NumberOfVertices; j++) {
                    if (graph[i][j] > 0) {
                        giStr += "\n" + vertices.get(i).getLabel() + " " + vertices.get(j).getLabel() + " " + graph[i][j];
                        ++countEdge;
                    }
                }
            }
            giStr = this.NumberOfVertices + " " + countEdge + giStr;
        }
        this.txtGraphInfo.setText(giStr);
    }

    public void addVertex() { //add dinh
        this.vertices.add(new GVertex(this.NumberOfVertices, mouseX, mouseY));
        NumberOfVertices++;
        for (int i = 0; i < this.NumberOfVertices; i++) {
            graph[i][this.NumberOfVertices - 1] = 0;
            graph[this.NumberOfVertices - 1][i] = 0; //tao ra hang moi cot moi
        }

        updateGraphInfo(); //update so tren ma tran
    }

    public void addEdge() { //add canh
        selectedEdgeIndex = findEdgeByVertex(startIndex, stopIndex);
        if (selectedEdgeIndex == -1) {
            this.edgeValue = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter the value for this edge ", "1"));
            this.edges.add(new GEdge(edgeValue, this.vertices.get(startIndex), this.vertices.get(stopIndex)));

            graph[startIndex][stopIndex] = edgeValue;
            graph[stopIndex][startIndex] = edgeValue;
        }

        startIndex = stopIndex = - 1;
        updateGraphInfo();
    }

    public void selectVertex() {
        selectedVertexIndex = findVertexByLocation(mouseX, mouseY);
        if (selectedVertexIndex > -1) {
            if (startIndex == -1) { //truong hop no chua chon vao dinh nao
                startIndex = selectedVertexIndex;
                this.vertices.get(startIndex).setSelected(true);
            } else if (startIndex == selectedVertexIndex) {
                this.vertices.get(startIndex).setSelected(false);
                startIndex = -1;
            } else {
                this.vertices.get(startIndex).setSelected(false);
                stopIndex = selectedVertexIndex;
                addEdge();
            }
        }
    }

    public void updateEdge() {
        GEdge edge = this.edges.get(selectedEdgeIndex);
        this.startIndex = edge.getStart().getValue();
        this.stopIndex = edge.getEnd().getValue();

        try {
            this.edgeValue = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter new value for this edge", edge.getValue() + ""));
            edge.setValue(this.edgeValue);
            graph[startIndex][stopIndex] = this.edgeValue;
            graph[stopIndex][startIndex] = this.edgeValue;
            startIndex = stopIndex = -1;
            updateGraphInfo();
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
    }

    public void selectEdge() {
        selectedEdgeIndex = findEdgeByLocation(mouseX, mouseY);
        if (selectedEdgeIndex > -1) {
            this.edges.get(selectedEdgeIndex).setSelected(true);
            repaint();
            updateEdge(); //cap nhat trong so cua canh
            this.edges.get(selectedEdgeIndex).setSelected(false);
            selectedEdgeIndex = -1;

        }
    }

    public void removeEdge(int index) {

        GEdge edge = this.edges.get(index);
        int from = edge.getStart().getValue();
        int to = edge.getEnd().getValue();

        graph[from][to] = 0;
        graph[to][from] = 0;
        this.edges.remove(index);
        updateGraphInfo();
    }

    public void removeEdge() {
        int edgeIndex = findEdgeByLocation(mouseX, mouseY);
        if (edgeIndex > -1) {
            GEdge edge = this.edges.get(edgeIndex);
            String edgeLabel = edge.getStart().getLabel() + "-" + edge.getEnd().getLabel();

            edge.setSelected(true);
            repaint();
            if (JOptionPane.showConfirmDialog(this, "Do you really want to delete the edge ' " + edgeLabel + " ' ?",
                    "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.removeEdge(edgeIndex);

            } else {
                edge.setSelected(false);
            }
        }
    }

    public void removeVertex(int index) {
        //remove all edge that has start vertex or end vertex equal to the remove vertex input
        for (int from = index; from < this.NumberOfVertices - 1; from++) {
            for (int to = 0; to < this.NumberOfVertices; to++) {
                if (from !=  to) {
                    graph[from][to] = graph[from + 1][to];
                    graph[to][from] = graph[to][from + 1];
                }
            }
        }
        this.NumberOfVertices--;

        GEdge edge;
        for (int i = this.edges.size() - 1; i >= 0; i--) {
            edge = this.edges.get(i);
            if (edge.getStart().getValue() == index || edge.getEnd().getValue() == index) {
                this.edges.remove(i);
            }
        }

        this.vertices.remove(index);
        for (int i = index; i < this.NumberOfVertices; i++) {
            this.vertices.get(i).setValue(this.vertices.get(i).getValue() - 1);
        }
        updateGraphInfo();
    }

    public void removeVertex() {
        int vertexIndex = findVertexByLocation(mouseX, mouseY);
        if (vertexIndex > -1) {
            String vertexLabel = this.vertices.get(vertexIndex).getLabel();
            vertices.get(vertexIndex).setSelected(true);
            repaint();

            if (JOptionPane.showConfirmDialog(this, "Do you really want to delete the vertex ' " + vertexLabel + " ' ?",
                    "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.removeVertex(vertexIndex);
            } else {
                vertices.get(vertexIndex).setSelected(false);
            }
        }
    }

    public void checkMouseClicked() {
        if (isCtrl) {
            addVertex();
        } else if (isShift) {
            removeVertex();
            removeEdge();
        } else if (isALT) {
            traversalReset();
            PrimeReset();
            dijkstraReset();
        } else if (isRightClicked) {
            nextPath();
        } else {
            selectVertex();
            selectEdge();
        }
        repaint();
    }

    public void setTxtGraphInfo(JTextArea txtGraphInfo) {
        this.txtGraphInfo = txtGraphInfo;
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        this.g = (Graphics2D) grphcs;

        this.g.setColor(Color.white);
        this.g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (int i = 0; i < edges.size(); i++) {
            edges.get(i).draw(g);
        }
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).draw(g);
        }

        if (result != "") {
            g.setColor(Color.red);
            grphcs.drawString(result, 10, 20);
        }

        if (dijkstraMessage != "") {
            g.setColor(Color.red);
            grphcs.drawString(dijkstraMessage, 10, 20);

            if (dijkstraPath.size() > 0) {
                for (int i = 0; i < dijkstraPath.size(); i++) {
                    g.drawString("#" + (i + 1) + ". " + dijkstraPath.get(i), 10, 40 + i * 20);
                }

                String[] v = dijkstraPath.get(pathIndex).split(" -> ");
                int fromVertex, toVertex, edgeIndex, vertexIndex;

                for (int i = 1; i < v.length; i++) {
                    fromVertex = Integer.parseInt(v[i - 1]);
                    toVertex = Integer.parseInt(v[i]);
                    edgeIndex = findEdgeByVertex(fromVertex, toVertex);

                    this.edges.get(edgeIndex).setSelected(true);
                    this.edges.get(edgeIndex).draw(g);
                    this.edges.get(edgeIndex).setSelected(false);
                }

                for (int i = 0; i < v.length; i++) {
                    vertexIndex = Integer.parseInt(v[i]);
                    this.vertices.get(vertexIndex).setSelected(true);
                    this.vertices.get(vertexIndex).draw(g);
                    this.vertices.get(vertexIndex).setSelected(false);

                }

            }

        }

        //spanning tree
        if (isDrawPrimPath == true) {
            String str = "";
            if (isGraphOK) {
                int sum = 0;
                for (int i = 0; i < NumberOfVertices; i++) {
                    sum += distance[i];
                }
                str = "The value of minimum spanning tree  is " + sum;

                int fromVertex;
                int toVertex;
                int edgeIndex;
                for (int i = 0; i < NumberOfVertices; i++) {
                    fromVertex = theVertexBefore[i];
                    toVertex = i;

                    if (fromVertex != toVertex) {
                        edgeIndex = findEdgeByVertex(fromVertex, toVertex);
                        if (edgeIndex != -1) {
                            edges.get(edgeIndex).setSelected(true);
                            edges.get(edgeIndex).draw(g);
                        }
                    }
                }
                for (int j = 0; j < vertices.size(); j++) {
                    vertices.get(j).setSelected(true);
                    vertices.get(j).draw(g);

                }

                //reset lai
                for (int i = 0; i < NumberOfVertices; i++) {
                    fromVertex = theVertexBefore[i];
                    toVertex = i;

                    if (fromVertex != toVertex) {
                        edgeIndex = findEdgeByVertex(fromVertex, toVertex);
                        if (edgeIndex != -1) {
                            edges.get(edgeIndex).setSelected(false);
                        }
                    }
                }
                for (int j = 0; j < vertices.size(); j++) {
                    vertices.get(j).setSelected(false);
                }
            } else {
                str = "The graph is not connected";
            }
            g.setColor(Color.red);
            grphcs.drawString(str, 10, 20);

            isDrawPrimPath = false;
        }
    }

    public void BFS() {
        traversalReset();
        int count = 0;
        int startVertex = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Please enter the start vertex", "0"));
        isVisited[startVertex] = true;
        int fromVertex;
        q.add(startVertex);
        result = "The BFS traversal from the vertex " + startVertex + " is: ";
        while (!q.isEmpty()) {
            fromVertex = q.poll();
            if (count == 0) {
                result += fromVertex;
            } else {
                result += ", " + fromVertex;
            }
            for (int toVertex = 0; toVertex < NumberOfVertices; toVertex++) {
                if (isVisited[toVertex] == false && graph[fromVertex][toVertex] > 0) {
                    q.add(toVertex);
                    isVisited[toVertex] = true;
                }
            }
            count++;
        }
        repaint();

    }

    public void DFS() {
        traversalReset();
        int count = 0;
        int startVertex = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Please enter the start vertex", "0"));
        isVisited[startVertex] = true;
        int fromVertex;
        s.push(startVertex);
        result = "The DFS traversal from the vertex " + startVertex + " is: ";
        while (!s.isEmpty()) {
            fromVertex = s.pop();
            if (count == 0) {
                result += fromVertex;
            } else {
                result += ", " + fromVertex;
            }
            for (int toVertex = NumberOfVertices - 1; toVertex >= 0; toVertex--) {
                if (isVisited[toVertex] == false && graph[fromVertex][toVertex] > 0) {
                    s.push(toVertex);
                    isVisited[toVertex] = true;
                }
            }
            count++;
        }
        repaint();
    }

    int[] distance;
    int[] theVertexBefore; //beforeVertex -> currentVertex
    public static final int Infinity = 1000000000;
    boolean isGraphOK;
    boolean isDrawPrimPath = false;

    ArrayList<Integer> dijkstra_theVertexBefore[];
    ArrayList<String> dijkstraPath;
    String dijkstraMessage = "";
    int pathIndex = 0;

    public void PrimeReset() {
        for (int i = 0; i < MAX_VERTEX; i++) {
            distance[i] = Infinity;
            theVertexBefore[i] = 1;
            isVisited[i] = false;

        }
        isDrawPrimPath = true;

    }

    public int findNearestVertex() { //tim dua tren trong so giua cac dinh
        int minIndex = -1, minValue = Infinity;
        for (int i = 0; i < NumberOfVertices; i++) {
            if (isVisited[i] == false && distance[i] < minValue) {
                minValue = distance[i];
                minIndex = i;
            }
        }
        return minIndex;

    }

    public void Prim() {

        PrimeReset();
        distance[0] = 0;
        isGraphOK = true;
        int currentVertex;
        for (int i = 0; i < NumberOfVertices; i++) {
            currentVertex = findNearestVertex();
            if (currentVertex == -1) { //do thi khong lien thong => khong tim thay cay khung co trong so nho nhat
                isGraphOK = false;
                return;
            } else {
                isVisited[currentVertex] = true;
                for (int toVertex = 0; toVertex < NumberOfVertices; toVertex++) {
                    if (isVisited[toVertex] == false && graph[currentVertex][toVertex] > 0 && graph[currentVertex][toVertex] < distance[toVertex]) {
                        distance[toVertex] = graph[currentVertex][toVertex];
                        theVertexBefore[toVertex] = currentVertex;
                    }
                }
            }
        }
        repaint();
    }

    public void dijkstraReset() {
        dijkstra_theVertexBefore = new ArrayList[MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            distance[i] = Infinity;
            dijkstra_theVertexBefore[i] = new ArrayList<>();
            dijkstra_theVertexBefore[i].add(i);
            isVisited[i] = false;

        }
        dijkstraPath = new ArrayList<>();
        dijkstraMessage = "";
        pathIndex = 0;
    }

    public void Dijkstra() {
        int startVertex = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Please enter the start vertex", "0"));
        int endVertex = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Please enter the end vertex", NumberOfVertices - 1));

        dijkstraReset();

        distance[startVertex] = 0;

        int currentVertex;
        isGraphOK = true;
        for (int i = 0; i < NumberOfVertices; i++) {
            currentVertex = findNearestVertex();
            if (currentVertex == -1) { //do thi khong lien thong => khong tim thay cay khung co trong so nho nhat
                isGraphOK = false;
                break;
            } else {
                isVisited[currentVertex] = true;
                for (int toVertex = 0; toVertex < NumberOfVertices; toVertex++) {
                    if ((isVisited[toVertex] == false || toVertex == endVertex) && graph[currentVertex][toVertex] > 0 && distance[currentVertex] + graph[currentVertex][toVertex] <= distance[toVertex]) { // graph[currentVertex][toVertex] la trong so

                        if (distance[currentVertex] + graph[currentVertex][toVertex] < distance[toVertex]) {
                            dijkstra_theVertexBefore[toVertex].clear();
                        }
                        distance[toVertex] = distance[currentVertex] + graph[currentVertex][toVertex];
                        dijkstra_theVertexBefore[toVertex].add(currentVertex);
                    }
                }
            }
        }
        if (isGraphOK) {
            dijkstraPath.clear();
            String path = "" + endVertex;
            currentVertex = endVertex;
            Dijkatra_displayPath(path, currentVertex, startVertex, endVertex);
            dijkstraMessage = "The length of the shortest path from " + startVertex + " to " + endVertex + " is " + distance[endVertex];

        } else {
            dijkstraMessage = "Can't find path from " + startVertex + " to " + endVertex + "!";
        }
        isDrawPrimPath = false;

        repaint();
    }

    public void Dijkatra_displayPath(String path, int vertex, int startvertex, int endVertex) { //vertex mean current vertex
        if (vertex != endVertex) {
            path = vertex + " -> " + path;
        }

        if (vertex == startvertex) {
            dijkstraPath.add(path);
        } else {
            for (int i = 0; i < dijkstra_theVertexBefore[vertex].size(); i++) { 
                Dijkatra_displayPath(path, dijkstra_theVertexBefore[vertex].get(i), startvertex, endVertex);
            }

        }

    }

    
    public void readMatrixDataFile(File openFile) {
        try ( Scanner sc = new Scanner(openFile)) {
            this.edges.clear();
            this.vertices.clear();
            this.NumberOfVertices = sc.nextInt();
            int x, y;
            for (int i = 0; i < this.NumberOfVertices; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                this.vertices.add(new GVertex(i, x, y));
            }
            for (int i = 0; i < this.NumberOfVertices; i++) {
                for (int j = 0; j < this.NumberOfVertices; j++) {
                    this.graph[i][j] = sc.nextInt();
                    if (i < j && this.graph[i][j] > 0) {
                        this.edges.add(new GEdge(this.graph[i][j], this.vertices.get(i), this.vertices.get(j)));
                    }
                }
            }
            dijkstraMessage = "";
            isDrawPrimPath = false;
            updateGraphInfo();
            repaint();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void readListDataFile(File openFile) {
        try ( Scanner sc = new Scanner(openFile)) {
            this.edges.clear();
            this.vertices.clear();
            this.NumberOfVertices = sc.nextInt();
            int countEdge = sc.nextInt();
            int x, y;
            for (int i = 0; i < this.NumberOfVertices; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                this.vertices.add(new GVertex(i, x, y));
            }

            for (int i = 0; i < this.NumberOfVertices; i++) {
                for (int j = 0; j < this.NumberOfVertices; j++) {
                    this.graph[i][j] = 0;
                }
            }

            int start, end, value;
            for (int i = 0; i < countEdge; i++) {
                start = sc.nextInt();
                end = sc.nextInt();
                value = sc.nextInt();
                this.edges.add(new GEdge(value, this.vertices.get(start), this.vertices.get(end)));
                this.graph[start][end] = this.graph[end][start] = value;
            }
            dijkstraMessage = "";
            isDrawPrimPath = false;

            updateGraphInfo();
            repaint();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void nextPath() {
        pathIndex = (pathIndex + 1) % dijkstraPath.size();
        repaint();
    }

}
