/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caro;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author quoczuong
 */
public class chess extends JLabel {

    int row, col, value;
    private MouseListener mouseClicked;
    private TicTacToe parent;

    public chess(TicTacToe parent, int row, int col, int value) throws IOException {
        this.parent = parent;
        this.row = row;
        this.value = value;
        this.col = col;
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.mouseClicked = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    try {
                        cardClicked();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(chess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        this.addMouseListener(mouseClicked);
        updateFace();

    }

    private void cardClicked() throws IOException, InterruptedException {
        turnOn(parent.getLuotDi());

        parent.checkWin(this.row, this.col);
            

        parent.luotDiTiepTheo(); //chuyen luot di

    }

    public void updateFace() throws IOException {
        
        this.setIcon(getFace());
    }

    public ImageIcon getFace() throws IOException {
        /*     thay thong cam do em xai macOS khong biet do khac he dieu hanh hay sao ma function .getResource cua em khong hoat dong
        return new ImageIcon(getClass().getResource("/src/main/java/com/mycompany/img/" + value + ".png"));
         */
        return new ImageIcon(ImageIO.read(new File("/Users/quoczuong/NetBeansProjects/Caro/src/main/java/com/img/" + value + ".png")));
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
        this.value = luotDi;
        this.removeMouseListener(mouseClicked);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        updateFace();

    }

}
