import java.util.Stack;

/**
 * 小招手上有2个数组，nums和values数组。现在小招每次可以从nums数组的头部或者尾部取走一个数。
 * 假设第 i 次取的数字为x，那么第 i 次取的价值为 values[i-1] * x。
 * 小招现在要把所有的nums数组里的数字取完，求小招可以取到的最大价值？
 */
public class 最大价值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4};
        int[] value = {1, 2, 3, 4, 5};

        int sum = getMaxValue(nums, value);
        System.out.println(sum);
    }

    public static int getMaxValue(int[] nums, int[] values) {
        Stack<Integer> numsStack = new Stack<>();
        Stack<Integer> valuesStack = new Stack<>();
        // 每次都从头部或者尾部取一个最小的值
        int sum = 0;
        int beginIndex = 0;
        int endIndex = nums.length - 1;
        int i = nums.length;
        while (i > 0) {
            int head = nums[beginIndex];
            int tail = nums[endIndex];
            numsStack.push(head < tail ? head : tail);
            if (head < tail) {
                beginIndex++;
            } else {
                endIndex--;
            }
            i--;
        }

        int beginIndex2 = 0;
        int endIndex2 = values.length - 1;
        int i2 = values.length;
        while (i2 > 0) {
            int head2 = values[beginIndex2];
            int tail2 = values[endIndex2];
            valuesStack.push(head2 < tail2 ? head2 : tail2);
            if (head2 < tail2) {
                beginIndex2++;
            } else {
                endIndex2--;
            }
            i2--;
        }

        while (!numsStack.empty()) {
            sum += numsStack.pop() * valuesStack.pop();
        }
        return sum;
    }

}
