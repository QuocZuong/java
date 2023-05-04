/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bstdemo_ce171000;

/**
 *
 * @author CE171000 Le Quoc Vuong
 * constructor dùng để phục vụ chức năng cân bằng cây
 */
public class NodeData {
    private int data;
    private int count;

    /**
     *  constructor dùng để phục vụ chức năng cân bằng cây
     * @param data
     * @param count
     */
    public NodeData(int data, int count) {
        this.data = data;
        this.count = count;
    }
    
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

    
    
    
}
