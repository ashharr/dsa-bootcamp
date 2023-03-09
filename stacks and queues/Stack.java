import java.util.Stack;

class Stacks {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack();
        stack.push(34);
        stack.push(35);
        stack.push(12);
        stack.push(66);
        stack.push(12);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());  Empty Stack Exception


    }
}