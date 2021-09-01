import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunmengyuan
 * @date 2021-09-01
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。FreqStack 有两个函数： push(int x)，将整数 x 推入栈中。pop()，
 * 它移除并返回栈中出现最频繁的元素。如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * ◼ 示例： push [5,7,5,7,4,5] pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。 pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。 栈变成 [5,7,5,4]。 pop() -> 返回 5 。
 * 栈变成 [5,7,4]。 pop() -> 返回 4 。 栈变成 [5,7]。
 * https://github.com/0voice/interview_internal_reference/blob/master/01.%E9%98%BF%E9%87%8C%E7%AF%87/1.3.1%20%E6%9C%80%E5%A4%A7%E9%A2%91%E7%8E%87%E6%A0%88.md
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) {
            maxfreq = f;
        }
        group.computeIfAbsent(f, z -> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }

    public static void main(String[] args) {
        FreqStack f = new FreqStack();
        f.push(5);
        f.push(7);
        f.push(5);
        f.push(7);
        f.push(4);
        f.push(5);
        System.out.println(f);
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
    }

}
