package com.mycompany.myreversi;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author quoczuong
 */
public class Card extends JLabel {

    int row, col, value;
    private MouseListener mouseClicked;
    private MyReversi parent;

    public Card(MyReversi parent, int row, int col, int value) throws IOException {
        this.parent = parent;
        this.row = row;
        this.value = value;
        this.col = col;
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.mouseClicked = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cardClicked();
                } catch (IOException ex) {
                    Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        this.addMouseListener(mouseClicked);
        updateFace();
    }

    private void cardClicked() throws IOException {
        int count = parent.countAllDirection(row, col);
        if (count > 0) {
            turnOn(parent.getLuotDi());
            parent.luotDiTiepTheo();
            parent.updatePoint();
        }

    }

    public void updateFace() throws IOException {
        this.setIcon(getFace());
    }

    public ImageIcon getFace() throws IOException {
/*     thay thong cam do em xai macOS khong biet do khac he dieu hanh hay sao ma function .getResource cua em khong hoat dong
        return new ImageIcon(getClass().getResource("/src/main/java/com/mycompany/img/" + value + ".png"));
*/
        return new ImageIcon(ImageIO.read(new File("/Users/quoczuong/NetBeansProjects/MyReversi/src/main/java/com/img/" + value + ".png")));
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws IOException {
        this.value = value;
        updateFace();
    }

    public void turnOn(int luotDi) throws IOException {
        this.value = value * MyReversi.turnOnValue + luotDi;
        this.removeMouseListener(mouseClicked);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        updateFace();
    }

    public void reTurn() throws IOException {
        int bg = this.value / MyReversi.turnOnValue;

        int v1 = this.value % MyReversi.turnOnValue;
        v1 = 1 - v1;

        this.value = bg * MyReversi.turnOnValue + v1;

        updateFace();
    }
}
