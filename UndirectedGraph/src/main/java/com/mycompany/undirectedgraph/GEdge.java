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
public class GEdge {

    public static final int PADDING_X = 12;
    public static final int PADDING_Y = 8;
    public static final int LABEL_W = PADDING_X * 2;
    public static final int LABEL_H = PADDING_Y * 2;
    public static final int LABEL_R = 10;
    public static final Font FONT = new Font("Arial", Font.PLAIN, 10);

    private int value;
    private GVertex start;
    private GVertex end;
    private boolean isSelected = false;
    private int x, y;

    public GEdge(int value, GVertex start, GVertex end) {
        this.value = value;
        this.start = start;
        this.end = end;
        calculateCenterLocation();
    }

    private void calculateCenterLocation() {
        this.x = (start.getX() + end.getX()) / 2;
        this.y = (start.getY() + end.getY()) / 2;
        
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public GVertex getStart() {
        return start;
    }

    public void setStart(GVertex start) {
        this.start = start;
    }

    public GVertex getEnd() {
        return end;
    }

    public void setEnd(GVertex end) {
        this.end = end;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
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

    public GEdge() {
    }

    public boolean isInside(int mouseX, int mouseY) {
        int x1 = this.x - PADDING_X;
        int y1 = this.y - PADDING_Y;
        int x2 = this.x + PADDING_X;
        int y2 = this.y + PADDING_Y;
        return x1 <= mouseX && mouseX <= x2 && y1 <= mouseY && mouseY <=y2;
    }
    
        public void  drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
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
    
     public void draw(Graphics2D g){
        g.setColor(isSelected ? Color.red:Color.black);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
        
        calculateCenterLocation();
        
        g.setColor(isSelected ? Color.yellow:Color.white);
        g.fillRoundRect(this.x -  PADDING_X, this.y - PADDING_Y, LABEL_W, LABEL_H, LABEL_R, LABEL_R);
        
        g.setColor(isSelected ? Color.red:Color.black);
        GVertex.drawCenteredString(g, value + "",new Rectangle(this.x -  PADDING_X, this.y - PADDING_Y, LABEL_W, LABEL_H), FONT);
        
    }
}
