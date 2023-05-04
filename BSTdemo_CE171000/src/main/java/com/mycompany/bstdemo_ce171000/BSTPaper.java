/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bstdemo_ce171000;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ce171000 Le Quoc Vuong
 */


public class BSTPaper extends JPanel {

    /**
     * class này dùng để tương tác với Frame chính => để vẽ và thêm thông tin lên màn hình
     */
    public static final int NODE_RADIUS = 12; //bán rính node

    /**
     *
     */
    public static final int FONT_SIZE = 15; //kích cỡ chữ

    BSTree tree; //tạo một cây
    int screenWidth;
    int yMin;

    Graphics2D g; //dùng để vẽ

    /**
     *  
     * @param tree
     * @param screenWidth
     * @param yMin
     */
    public BSTPaper(BSTree tree, int screenWidth, int yMin) {
        this.tree = tree;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
    }

    /**
     * add node gọi hàm addNode bên class BSTree và sau đó vẽ lại frame
     * @param data
     */
    public void addNode(int data) {
        this.tree.addNode(data);
        repaint();
    }

    /**
     *
     * @return
     */
    public BSTree getTree() {
        return tree;
    }

    /**
     *
     * @param tree
     */
    public void setTree(BSTree tree) {
        this.tree = tree;
    }

    /**
     * from stackoverflow để vẽ chữ trong nút
     * @param g
     * @param text
     * @param rect
     * @param font
     */
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

    /**
     *  vẽ node bao gồm viền ngoài cũng như hình Oval cho node kèm theo để số lần lặp lại của node
     * @param node
     */
    public void drawNode(BSTNode node) {
        if (node == null) {
            return;
        }

        int x = node.getX();
        int y = node.getY();
       

        g.setColor(Color.black);

        //draw left child link
        if (node.hasLeftChild()) {
            g.drawLine(x, y, node.getLeftChild().getX(), node.getLeftChild().getY());
        }

        //draw right child link
        if (node.hasRightChild()) {
            g.drawLine(x, y, node.getRightChild().getX(), node.getRightChild().getY());
        }

        if (node.getCount() != 1) {
            g.drawString("c = " + node.getCount(), x - NODE_RADIUS, y + NODE_RADIUS * 2); // số lần lặp lại của node
        }

        //fill the node
        g.setColor(Color.white);
        g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        //drraw outline
        g.setColor(Color.black);
        g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        drawCenteredString(g, node.getData() + "", new Rectangle(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Arial", Font.PLAIN, 10));

        drawNode(node.getLeftChild());
        drawNode(node.getRightChild());

    }

    /**
     *  phục vụ cho chức năng search => vẽ cũng như highlight khi search ra đáp án
     * @param path
     */
    public void drawPath(ArrayList<BSTNode> path) {

        if (path.isEmpty()) {
            
            return;
        }
        g.setColor(Color.yellow);
        Stroke old = new BasicStroke();
        g.setStroke(new BasicStroke(3));
        for (BSTNode node : path) {
            int x = node.getX();
            int y = node.getY();

            if (!node.isRoot()) {

                g.drawLine(x, y, node.getParent().getX(), node.getParent().getY());

            }

        }
        g.setStroke(old);
        for (BSTNode node : path) {
            int x = node.getX();
            int y = node.getY();
            int r = 15;

            g.setColor(Color.white);
            g.fillOval(x - r, y - r, r * 2, r * 2);

            //drraw outline
            g.setColor(Color.red);
            g.drawOval(x - r, y - r, r * 2, r * 2);
            g.setColor(Color.black);
            drawCenteredString(g, node.getData() + "", new Rectangle(x - r, y - r, r * 2, r * 2), new Font("Arial", Font.PLAIN, 10));

        }
        
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<BSTNode> getPath(){
        return this.tree.getPath();
    }
    
    /**
     *
     * @param path
     */
    public void setPath(ArrayList<BSTNode>path){
       this.tree.path = path;
   }
    
    /**
     *
     * @return
     */
    public String getStringPath(){
        return this.tree.getStringPath();
    }
    
    /**
     *
     * @param data
     */
    public void deleteNode(int data){
        this.tree.removeNode(data);              
        repaint();
    }
    
    /**
     *
     * @param data
     */
    public void searchNode(int data){
        this.tree.search(data);
        repaint();
    }
    
    /**
     *
     */
    public void clear(){
        this.tree.clear();
        repaint();
    }
    
    /**
     *
     * @param graph
     */
    @Override
    public void paint(Graphics graph) {
        super.paint(graph);

        this.g = (Graphics2D) graph;
        drawNode(this.tree.getRoot());
        drawPath(this.tree.getPath());
    }

    /**
     *
     */
    public void blancing() {
        this.tree.blancing();
        repaint();
    }
}
