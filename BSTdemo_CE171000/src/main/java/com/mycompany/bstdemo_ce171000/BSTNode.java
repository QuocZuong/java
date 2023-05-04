/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bstdemo_ce171000;

/**
 *
 * @author ce1710000 Le Quoc Vuong
 */
public class BSTNode {

    private int data;
    private int count; // xu li truong hop trung gia tri tren cay BST
    private BSTNode leftChild;
    private BSTNode rightChild;
    private BSTNode parent;

    private int level;
    private int order;

    /**
     *
     */
    public enum NodeType {

        /**
         *
         */
        LEFT_CHILD,

        /**
         *
         */
        RIGHT_CHILD
    }
    // for drawing 

    /**
     *
     */
    public static final int LEVEL_DY = 60; // khoang cach giua cac level
    private int x;
    private int y;
    private int width; // 

    /**
     *  tạo node
     * @param data
     */
    public BSTNode(int data) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        //for drawing
        this.x = 0;
        this.y = 0;
        this.width = 0;

    }

    /**
     * for blancing BST
     * @param data
     * @param count
     */
    public BSTNode(int data, int count) { 
        this.data = data;
        this.count = count;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        //for drawing
        this.x = 0;
        this.y = 0;
        this.width = 0;

    }
    
    /**
     *
     * @param data
     * @param y
     * @param screenWidth
     */
    public BSTNode(int data, int y, int screenWidth) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;
        this.level = 0;
        this.order = 0;

        //for drawing
        this.x = this.width = screenWidth / 2;
        this.y = y;

    }

    /**
     *  check lá
     * @return
     */
    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    /**
     *  check xem node có con không
     * @return
     */
    public boolean hasChild() {
        return !isLeaf();
    }

    /**
     *  check xem có con trái không
     * @return
     */
    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    /**
     * check xem có con phải không
     * @return
     */
    public boolean hasRightChild() {
        return this.rightChild != null;

    }

    /**
     * check xem có phải rễ không
     * @return
     */
    public boolean isRoot() {
        return this.parent == null;
    }

    /**
     *  check xem nút có phải nút trong không
     * @return
     */
    public boolean isInside() {
        return !isLeaf() && !isRoot();
    }

    // set and get

    /**
     *
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     */
    public BSTNode getLeftChild() {
        return leftChild;
    }

    /**
     * set con trái theo hai chiều
     * @param leftChild
     */
    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild; //set a (this) có con trái là b (leftChild chuyền vào)
        if (leftChild != null) {
            this.leftChild.setParent(this, NodeType.LEFT_CHILD); //set b (con) có cha là a (this)
        }
    }

    /**
     * set con phải theo hai chiều
     * @param rightChild
     */
    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            this.rightChild.setParent(this, NodeType.RIGHT_CHILD);
        }
    }

    /**
     *
     * @return
     */
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     *
     * @return
     */
    public BSTNode getParent() {
        return parent;
    }

    /**
     *  set cha của node hiên tại
     * @param parent
     * @param type
     */
    public void setParent(BSTNode parent, NodeType type) {
        this.parent = parent;
        this.level = parent.getLevel() + 1;
        if (type == NodeType.LEFT_CHILD) {
            this.order = parent.getOrder() * 2 + 1; // con trái thì bằng nút cha nhân 2 + 1
        } else {
            this.order = parent.getOrder() * 2 + 2; // con phải thì bằng nút cha nhân 2 + 2
        }

        //for drawing
        this.width = parent.getWidth() / 2; // dung de canh cho nut con can doi
        if (type == NodeType.LEFT_CHILD) {
            this.x = parent.getX() - (this.width + 5 - this.level);
        } else {
            this.x = parent.getX() + this.width;
        }
        this.y = parent.getY() + LEVEL_DY;

    }

    /**
     *  tìm node lớn nhất (đi qua node con phải ngoài cùng)
     * @return
     */
    public BSTNode findMaxNode() {
        BSTNode node = this;
        while (node.hasRightChild()) {
            node = node.getRightChild();
        }
        return node;
    }

    /**
     * tìm node nhỏ nhất (đi qua node con trái ngoài cùng )
     * @return
     */
    public BSTNode findMinNode() {
        BSTNode node = this;
        while (node.hasLeftChild()) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     *  chức năng remove nút lá dựa vào việc truyền vào node con. Check xem con đó là con trái hay phải và xoá.
     * @param node
     * @return
     */
    public boolean removeLeafChild(BSTNode child) {
        if (child == null) {
            return false;
        }
        if (child.isLeaf()) {
            if (this.hasLeftChild()) {
                if (this.getLeftChild().getData() == child.getData()) {
                    this.setLeftChild(null);
                    return true;
                }
            }
            if (this.hasRightChild()) {
                if (this.getRightChild().getData() == child.getData()) {
                    this.setRightChild(null);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     * @return
     */
    public int getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    //set
}
