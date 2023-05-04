/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.bstdemo_ce171000;

import java.util.Scanner;

/**
 *
 * @author ce171000 Le Quoc Vuong
 */
public class BSTdemo_CE171000 {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.addNode(15);
        tree.addNode(12);
        tree.addNode(27);
        tree.addNode(5);
        tree.addNode(13);
        tree.addNode(19);
        tree.addNode(36);
        tree.addNode(11);
        tree.addNode(14);
        tree.addNode(22);
        tree.addNode(33);
        tree.addNode(48);
        tree.addNode(25);
        tree.addNode(28);
        
        System.out.print("Pre order:  ");
        tree.preOrder();
//        System.out.print("\nin order:  ");
//        tree.inOrder();
//        System.out.print("\npost order:  ");
//        tree.postOrder(); 
        System.out.print("\nSearch: ");
        Scanner sc = new Scanner(System.in);
        
        int numberToSearch = sc.nextInt();
        tree.search(numberToSearch);
        
    }
}
