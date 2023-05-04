/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.myreversi;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quoczuong
 */
public class MyReversi extends javax.swing.JFrame {

    /**
     * Creates new form MyReversi
     */
    public static final int numCols = 8;
    public static final int numRows = 8;
    public static final int redChess = 0;
    public static final int blueChess = 1;
    public static final int turnOnValue = 10;

    Card map[][];
    int luotDi; //luot di =0 la quan do, nguoc lai =1 la quan xanh duong

    public void generateBoard() throws IOException {
        map = new Card[numRows][numCols];

        pnlBoard.setLayout(new GridLayout(numRows, numCols));
        pnlBoard.removeAll();
        pnlBoard.revalidate();
        pnlBoard.repaint();
        int mau;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mau = (i % 2 + j % 2) % 2 + 1;
                map[i][j] = new Card(this, i, j, mau);
                pnlBoard.add(map[i][j]);
            }
        }

        map[3][3].turnOn(redChess);
        map[4][4].turnOn(redChess);

        map[3][4].turnOn(blueChess);
        map[4][3].turnOn(blueChess);
        luotDi = redChess;
        lblTurn.setText("Red");

    }

    public int getLuotDi() {
        return luotDi;
    }

    public void luotDiTiepTheo() {
        luotDi = 1 - luotDi;
        if (luotDi == 0) {
            lblTurn.setText("Red");
        } else {
            lblTurn.setText("Blue");
        }

    }

    public boolean coQuanCo(Card c) {
        return c.getValue() > 9;
    }

    public boolean khacMau(Card c, int luotDi) {
        return (c.getValue() % MyReversi.turnOnValue) != luotDi;
    }

    public boolean cungMau(Card c, int luotDi) {
        return (c.getValue() % MyReversi.turnOnValue) == luotDi;
    }

    public int countUp(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        for (i = row - 1; i >= 0; i--) {
            if (coQuanCo(map[i][col])
                    && khacMau(map[i][col], luotDi)) {
                count++;
            } else {
                break;
            }
        }

        if (i >= 0) {
            if (coQuanCo(map[i][col]) && cungMau(map[i][col], luotDi)) {
                for (int j = i + 1; j < row; j++) {
                    map[j][col].reTurn();
                }
                return count;
            }
        }
        return 0;
    }

    public int countDown(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        for (i = row + 1; i < numRows; ++i) {
            if (coQuanCo(map[i][col])
                    && khacMau(map[i][col], luotDi)) {
                count++;
            } else {
                break;
            }
        }
        if (i < numRows) {
            if (coQuanCo(map[i][col]) && cungMau(map[i][col], luotDi)) {
                for (int j = row + 1; j < i; j++) {
                    map[j][col].reTurn();
                }
                return count;
            }
        }
        return 0;

    }

    public int countLeft(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        for (i = col - 1; i >= 0; --i) {
            if (coQuanCo(map[row][i])
                    && khacMau(map[row][i], luotDi)) {
                count++;
            } else {
                break;
            }

        }
        if (i >= 0) {
            if (coQuanCo(map[row][i]) && cungMau(map[row][i], luotDi)) {
                for (int j = i + 1; j < col; j++) {
                    map[row][j].reTurn();

                }
                return count;
            }
        }
        return 0;

    }

    public int countRight(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        for (i = col + 1; i < numCols; ++i) {
            if (coQuanCo(map[row][i])
                    && khacMau(map[row][i], luotDi)) {
                count++;
            } else {
                break;
            }
        }

        if (i < numCols) {
            if (coQuanCo(map[row][i]) && cungMau(map[row][i], luotDi)) {
                for (int j = col + 1; j < i; j++) {
                    map[row][j].reTurn();

                }
                return count;
            }
        }
        return 0;

    }

    public int countLeftUp(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        int j = 0;
        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (coQuanCo(map[i][j])
                    && khacMau(map[i][j], luotDi)) {
                count++;
            } else {
                break;
            }
        }
        if (i >= 0 && j >= 0) {
            if (coQuanCo(map[i][j])
                    && cungMau(map[i][j], luotDi)) {
                for (int h = i + 1, k = j + 1; h < row && k < col; h++, k++) {
                    map[h][k].reTurn();
                }
                return count;
            }
        }
        return 0;

    }

    public int countRightUp(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        int j = 0;
        for (i = row - 1, j = col + 1; i >= 0 && j < numCols; i--, j++) {
            if (coQuanCo(map[i][j])
                    && khacMau(map[i][j], luotDi)) {
                count++;
            } else {
                break;
            }
        }
        if (i >= 0 && j < numCols) {
            if (coQuanCo(map[i][j])
                    && cungMau(map[i][j], luotDi)) {
                for (int h = i + 1, k = j - 1; h < row && k >= col + 1; h++, k--) {
                    map[h][k].reTurn();
                }
                return count;
            }
        }
        return 0;

    }

    public int countLeftDown(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        int j = 0;
        for (i = row + 1, j = col - 1; i < numRows && j >= 0; i++, j--) {
            if (coQuanCo(map[i][j])
                    && khacMau(map[i][j], luotDi)) {
                count++;
            } else {
                break;
            }
        }

        if (i < numRows && j >= 0) {
            if (coQuanCo(map[i][j])
                    && cungMau(map[i][j], luotDi)) {
                for (int h = i - 1, k = j + 1; h >= row + 1 && k < col; h--, k++) {
                    map[h][k].reTurn();
                }

                return count;
            }
        }
        return 0;
    }

    public int countRightDown(int row, int col) throws IOException {
        int count = 0;
        int i = 0;
        int j = 0;
        for (i = row + 1, j = col + 1; i < numRows && j < numCols; i++, j++) {
            if (coQuanCo(map[i][j])
                    && khacMau(map[i][j], luotDi)) {
                count++;
            } else {
                break;
            }
        }
        if (i < numRows && j < numCols) {
            if (coQuanCo(map[i][j])
                    && cungMau(map[i][j], luotDi)) {
                for (int h = row + 1, k = col + 1; h < i && k < j; h++, k++) {
                    map[h][k].reTurn();
                }
                return count;
            }
        }
        return 0;
    }

    public int countAllDirection(int row, int col) throws IOException {
        int up = countUp(row, col);
        int down = countDown(row, col);
        int left = countLeft(row, col);
        int right = countRight(row, col);
        int leftUp = countLeftUp(row, col);
        int rightUp = countRightUp(row, col);
        int leftDown = countLeftDown(row, col);
        int rightDown = countRightDown(row, col);

        return up + down + left + right + leftUp + rightUp + leftDown + rightDown;
    }

    public void updatePoint() {
        int countRed = 0;
        int countBlue = 0;
        int v;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (coQuanCo(map[i][j])) {
                    v = map[i][j].getValue() % MyReversi.turnOnValue;
                    if (v == redChess) {
                        countRed++;
                    } else {
                        countBlue++;
                    }
                }
            }
        }
        redPoint.setText(countRed + "");
        bluePoint.setText(countBlue + "");

    }

    public MyReversi() throws IOException {

        initComponents();

        this.setLocationRelativeTo(null); // canh giua man hinh
        generateBoard();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        redPoint = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bluePoint = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTurn = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        pnlBoard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Red");

        redPoint.setForeground(new java.awt.Color(255, 51, 51));
        redPoint.setText("2");

        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Blue");

        bluePoint.setForeground(new java.awt.Color(0, 0, 255));
        bluePoint.setText("2");

        jLabel2.setText("Turn: ");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(redPoint)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTurn))
                    .addComponent(bluePoint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(redPoint)
                    .addComponent(jLabel3)
                    .addComponent(bluePoint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTurn)
                    .addComponent(lblText))
                .addContainerGap())
        );

        pnlBoard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlBoard.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlBoard.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyReversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyReversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyReversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyReversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MyReversi().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MyReversi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bluePoint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JLabel redPoint;
    // End of variables declaration//GEN-END:variables
}
