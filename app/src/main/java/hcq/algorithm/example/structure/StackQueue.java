package hcq.algorithm.example.structure;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * <p/>
 * Created by hcq0618 on 2016/1/8.
 */
public class StackQueue {
    //Stack 继承自 Vector，是线程安全的 
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public void offer(int i) {
        stack.push(i);
    }

    //栈是一种后入先出的数据容器 队列是一种先入先出的数据容器
    //把栈1的数据全部再加入栈2 这样就反序输出了
    public int peek() {

        //把栈1反序放入栈2
        while (!stack.isEmpty()) {
            //pop() 移除栈顶对象，并作为函数的值 返回该对象。
            stack2.push(stack.pop());
        }

        //peek() 查看栈顶对象而不移除它
        int result = stack2.peek();

        //此时栈1是空的 在放回去
        while (!stack2.isEmpty()) {
            //pop() 移除栈顶对象，并作为函数的值 返回该对象。
            stack.push(stack2.pop());
        }

        return result;
    }

    //移除并返问队列头部的元素
    public int poll() {
        //把栈1反序放入栈2
        while (!stack.isEmpty()) {
            //pop() 移除栈顶对象，并作为函数的值 返回该对象。
            stack2.push(stack.pop());
        }

        //pop() 移除栈顶对象，并作为函数的值 返回该对象。
        int result = stack2.pop();

        //此时栈1是空的 在放回去
        while (!stack2.isEmpty()) {
            //pop() 移除栈顶对象，并作为函数的值 返回该对象。
            stack.push(stack2.pop());
        }

        return result;
    }

    public int size() {
        return stack.size();
    }
}
