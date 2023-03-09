import java.util.Arrays;

public class CustomStackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stack = new CustomStack(5);

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());


        // Using Dynamic stack
        DynamicStack dstack = new DynamicStack(3);
        dstack.push(1);
        dstack.push(2);
        dstack.push(3);
        // it will double the size to 6
        dstack.push(4);
        // size 6 stack
        System.out.println(Arrays.toString(dstack.data));

    }
}
