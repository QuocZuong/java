/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.undirectedgraph;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author ce171000 Le Quoc Vuong
 */
public class GVertex {

    private int x, y;
    private int value;
    private boolean isSelected = false;

    public static final int RADIUS = 12;
    public static final int DIAMETER = RADIUS * 2;
    public static final Font FONT = new Font("Arial", Font.PLAIN, 12);

    public GVertex(int value, int x, int y) {
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return value + "";
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        int x = x1 - x2;
        int y = y1 - y2;
        return Math.sqrt((x * x + y * y));
    }

    public boolean isInside(int mouseX, int mouseY) {
        return distance(x, y, mouseX, mouseY) <= RADIUS;
    }

    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
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

    public void draw(Graphics2D g) {
        g.setColor(isSelected ? Color.red : Color.white);
        g.fillOval(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);

        g.setColor(isSelected ? Color.yellow : Color.black);
        g.drawOval(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);

        drawCenteredString(g, this.getLabel(), new Rectangle(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER), FONT);

    }
}
