
package com.mycompany.bstdemo_ce171000;

/**
 *
 * @author CE171000 Le Quoc Vuong
 */
public class BSTRange {
    private int leftIndex;
    private int rightIndex;

    /**
     *
     * @return
     */
    public int getLeftIndex() {
        return leftIndex;
    }

    /**
     *
     * @param leftIndex
     */
    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    /**
     *
     * @return
     */
    public int getRightIndex() {
        return rightIndex;
    }

    /**
     *
     * @param rightIndex
     */
    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    /**
     * constructor phục vụ chức năng cân bằng cây
     * @param leftIndex
     * @param rightIndex
     */
    public BSTRange(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }
    
    
}
