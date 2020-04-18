package day0417;

import org.junit.Test;

/**
 * @hurusea
 * @create2020-04-17 12:00
 */
public class Solution {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int m = array.length-1;
        if (m < 0) {
            return false;
        }
        int n = array[0].length-1;
        if (n < 0) {
            return false;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = n; j >= 0; j--) {
                if (array[i][j] == target) {
                    return true;
                } else if (array[i][j] > target) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    @Test
    public void testFind() {
        int[][] arrays = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int target = 4;
        boolean find = Find(target, arrays);
        System.out.println(find);
    }
}
