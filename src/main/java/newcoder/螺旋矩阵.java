package newcoder;

import java.util.ArrayList;

/**
 * 描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * <p>
 * 数据范围：0≤n,m≤10，矩阵中任意元素都满足 ∣val∣≤100
 * 要求：空间复杂度 O(nm) ，时间复杂度 O(nm)
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> result = spiralOrder(matrix);
        result.forEach(v -> System.out.println(v));
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        // 定义四个指针，并且充当边界限制的作用
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            //上面  左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            //右边 上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            //下面  右到左
            for (int i = right - 1; top != bottom && i >= left; i--) {
                res.add(matrix[bottom][i]);
            }

            //左边 下到上
            for (int i = bottom - 1; left != right && i >= top + 1; i--) {
                res.add(matrix[i][left]);
            }
            // 遍历完一圈之后，所有往里面靠
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }
}
