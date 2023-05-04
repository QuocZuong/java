/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bstdemo_ce171000;

import java.security.spec.NamedParameterSpec;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author quoczuong
 */
public class BSTree {

    BSTNode root;
    String result;
    int countForDisplay = 0;
    
    ArrayList<NodeData> treeData;
    ArrayList<BSTNode> path;

    int screenWidth;
    int yMin;

    /**
     * tạo cây 
     */
    public BSTree() {
        root = null;
        this.screenWidth = 0;
        this.yMin = 0;
        treeData = new ArrayList<>();
        path = new ArrayList();
    }

    /**
     *  tạo cây với tham số để vẽ
     * @param screenWidth
     * @param yMin
     */
    public BSTree(int screenWidth, int yMin) {
        root = null;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
        treeData = new ArrayList<>();
        path = new ArrayList();
    }

    /**
     *
     * @return
     */
    public BSTNode getRoot() {
        return this.root;
    }

    /**
     *
     * @return
     */
    public String getTraversalResult() {
        return this.result;
    }

    /**
     * chức năng thêm nút dựa vào input từ người dùng
     * @param data
     */
    public void addNode(int data) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
        } else {
            boolean isAdded = false;
            BSTNode node = root;
            while (!isAdded) {
                if (data < node.getData()) { //ben trai
                    if (node.hasLeftChild()) {
                        node = node.getLeftChild(); // neu nut co con trai thi di qua trai
                    } else {
                        node.setLeftChild(new BSTNode(data));
                        isAdded = true;
                    }
                } else if (data > node.getData()) { //ben phai
                    if (node.hasRightChild()) {
                        node = node.getRightChild(); // neu nut co con trai thi di qua trai
                    } else {
                        node.setRightChild(new BSTNode(data));
                        isAdded = true;

                    }
                } else {
                    node.setCount(node.getCount() + 1);
                    isAdded = true;
                }
            }
        }
    }
    
    /**
     *  chức năng add nút custom lại dùng để phục vụ cho cân bằng cây với việc thêm tham số count
     * @param data
     * @param count
     */
    public void addNode(int data, int count) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
        } else {
            boolean isAdded = false;
            BSTNode node = root;
            while (!isAdded) {
                if (data < node.getData()) { //ben trai
                    if (node.hasLeftChild()) {
                        node = node.getLeftChild(); // neu nut co con trai thi di qua trai
                    } else {
                        node.setLeftChild(new BSTNode(data, count));
                        isAdded = true;
                    }
                } else if (data > node.getData()) { //ben phai
                    if (node.hasRightChild()) {
                        node = node.getRightChild(); // neu nut co con trai thi di qua trai
                    } else {
                        node.setRightChild(new BSTNode(data, count));
                        isAdded = true;

                    }
                } else {
                    node.setCount(node.getCount() + 1);
                    isAdded = true;
                }
            }
        }
    }

    //preorder

    /**
     * duyệt cây theo tiền tự với hai hàm một private và một public để class khác gọi
     * root -> left child -> right child
     */
    public void preOrder() {
        result = "Pre-order: ";
        countForDisplay = 0;
        preOrder(root);
    }

    private void preOrder(BSTNode node) {

        if (node == null) {
            return;
        }
        for (int i = 0; i < node.getCount(); i++) {
            if (countForDisplay == 0) {
                result += node.getData();
                System.out.print(node.getData());
                countForDisplay++;

            } else {
                result += ", " + node.getData();
                System.out.print(", " + node.getData());
                countForDisplay++;
            }

        }

        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());

    }

    // inorder

    /**
     * duyệt cây theo trung tự với hai hàm một private và một public để class khác gọi
     * left child -> root -> right child
     */
    public void inOrder() {
        result = "In-order: ";
        countForDisplay = 0;
        inOrder(root);
    }

    private void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        for (int i = 0; i < node.getCount(); i++) {
            if (countForDisplay == 0) {
                result += node.getData();
                System.out.print(node.getData());
                countForDisplay++;
            } else {
                result += ", " + node.getData();
                System.out.print(", " + node.getData());
                countForDisplay++;
            }
        }

        inOrder(node.getRightChild());

    }

    // post order

    /**
     * duyệt cây theo hậu tự với hai hàm một private và một public để class khác gọi
     * left child -> right child -> root
     */
    public void postOrder() {
        result = "Post-order: ";
        countForDisplay = 0;
        postOrder(root);

    }

    private void postOrder(BSTNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());

        for (int i = 0; i < node.getCount(); i++) {
            if (countForDisplay == 0) {
                result += node.getData();
                countForDisplay++;

            } else {
                result += ", " + node.getData();
                countForDisplay++;
            }
        }

    }

    /**
     * chức năng search theo input là số do người dùng nhập
     * @param data
     */
    public void search(int data) {
        int count = 0;
        path.clear();
        search(data, root);
        for (BSTNode node : path) {
            if (node.getData() == data) {
                count++;
            }
        }

        if (count == 0) {
            path.clear();
        }
    }

    private void search(int data, BSTNode root) {

        if (root == null) {
            return;
        }
        path.add(root);

        if (root.getData() < data) {
            search(data, root.getRightChild());
        } else if (root.getData() > data) {
            search(data, root.getLeftChild());
        }
    }

    /**
     *  chức năng dùng cho mục đích trả về đường dẫn khi duyệt cây theo kiểu String
     * @return
     */
    public String getStringPath() {
        String pathString = "Path: ";
        countForDisplay = 0;
        for (int i = 0; i < path.size(); i++) {
            if (countForDisplay == 0) {
                pathString += path.get(i).getData();

            } else {
                pathString += " -> " + path.get(i).getData();
            }
            countForDisplay++;

        }
        if (path.isEmpty()) {
            pathString += "Not found!";
        }
        return pathString;
    }

    /**
     *  trả về mảng lưu các giá trị đường đi sau khi duyệt cây
     * @return
     */
    public ArrayList<BSTNode> getPath() {

        return this.path;
    }

    /**
     *
     * @param path
     */
    public void setPath(ArrayList<BSTNode> path) {
        this.path = path;
    }

    /**
     *  kiểm tra xem đường đi có trống k. Và dựa vào mảng để trả về giá trị khi search 
     * @return
     */
    public BSTNode getSearchNode() {
        if (path.isEmpty()) {
            return null;
        }
        return this.path.get(path.size() - 1);
    }

    /**
     *  chức năng xoá node dựa vào mảng lưu đường đi khi search (xoá giá trị cuối)
     * @param data
     * @return
     */
    public boolean removeNode(int data) {

        BSTNode node = path.get(path.size() - 1);
        return removeNode(node);
    }

    /**
     *  
     * @param node
     * @return
     */
    private boolean removeNode(BSTNode node) {
        if (node == null) {
            return false;
        }
        node.setCount(node.getCount() - 1);
        if (node.getCount() == 0) {
            if (node.isLeaf()) {
                node.getParent().removeLeafChild(node);
                return true;
            } else {
                BSTNode incomer = null;
                if (node.hasLeftChild()) {
                    incomer = node.getLeftChild().findMaxNode();
                } else {
                    incomer = node.getRightChild().findMinNode();
                }
                node.setData(incomer.getData());
                node.setCount(incomer.getCount());

                incomer.setCount(1);
                return removeNode(incomer);
            }
        } else {
            return true;
        }
    }

    /**
     * chức năng xoá BST
     */
    public void clear() {
        clear(this.root);
        this.root = null;
    }

    /**
     *
     * @param node
     */
    public void clear(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            node.getParent().removeLeafChild(node);
        } else {
            clear(node.getLeftChild());
            clear(node.getRightChild());
        }

    }

    /**
     * chức năng duyệt cây BFS dựa vào việc sử dụng Queue
     * lưu ý trình tự của queue là first in first out => muốn xử lí con bên trái thì thêm con bên trái vào trước
     */
    public void BFS() {
        countForDisplay = 0;
        this.result = "";
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        BSTNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node != null) {
                for (int i = 0; i < node.getCount(); i++) {
                    if (countForDisplay == 0) {
                        System.out.println(node.getData());
                        result += node.getData();
                    } else {
                        System.out.println(", " + node.getData());
                        result += ", " + node.getData();
                    }
                    countForDisplay++;
                }
                q.add(node.getLeftChild());
                q.add(node.getRightChild());

            }

        }
    }

    /**
     * chức năng duyệt cây BFS dựa vào việc sử dụng Stack
     * lưu ý trình tự của Stack là first in last out => muốn xử lí con bên trái thì thêm con bên phải vào trước
     */
    public void DFS() {
        this.result = "";
        countForDisplay=0;
        Stack<BSTNode> s = new Stack<>();
        s.add(root);
        BSTNode node;
        while (!s.isEmpty()) {
            node = s.pop();
            if (node != null) {
                for (int i = 0; i < node.getCount(); i++) {
                    if (countForDisplay == 0) {
                        System.out.println(node.getData());
                        result += node.getData();
                    } else {
                        System.out.println(", " + node.getData());
                        result += ", " + node.getData();
                    }
                    countForDisplay++;
                }
                s.add(node.getRightChild());
                s.add(node.getLeftChild());
            }

        }
    }
    
    /**
     * tạo mảng lưu lại giá trị và count của mỗi nút
     */
    private void BST2Array(BSTNode node) {
        if (node == null) {
            return;
        }
        BST2Array(node.getLeftChild());
        treeData.add(new NodeData(node.getData(), node.getCount()));
        BST2Array(node.getRightChild());
    }
    
    /**
     * chức năng cân bằng cây. Dựa vào việc sử dụng duyệt trung tự để cây theo thứ tự tăng dần và sử dụng queue để lưu index đầu và index đuôi của mảng.
     * tạo left, mid, right index của mảng.
     * lấy ra và xoá giá trị của queue chứa range của mảng và gán vào các biến
     * ý tưởng là dựa vào một mảng đã sắp xếp để lấy ra thằng ở giữa rồi thêm nó vào cây mới 
     */
    public void blancing(){
        treeData.clear();
        BST2Array(this.root); //storage BST into ascending order array
        
        this.clear(); //remove all node from this BST
        Queue<BSTRange> q = new LinkedList<>();
        q.add(new BSTRange(0, treeData.size()-1));
        BSTRange range;
        NodeData nodeData;
        int middleIndex,leftIndex, rightIndex;
        
        while(!q.isEmpty()){
            range = q.poll();
            leftIndex = range.getLeftIndex();
            rightIndex = range.getRightIndex();
            if(leftIndex<= rightIndex){
                middleIndex = (leftIndex + rightIndex)/2;
                nodeData = treeData.get(middleIndex);
                this.addNode(nodeData.getData(), nodeData.getCount());
                q.add(new BSTRange(leftIndex,middleIndex - 1)); // ở đây là vì đã lấy giá trị ở giữa ra nên sẽ tạo ra 2 range mới (như kiểu chia đôi mảng)
                q.add(new BSTRange(middleIndex + 1,rightIndex));
            }
        }
      
    }
    
}
