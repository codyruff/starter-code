package DataStructuresLib;

public class ArrayStack<T> extends DataStructuresLib.MyStack {

    T[] stack;
    int size;

    public ArrayStack(){
        stack = new T [10];
        size = 0;
    }

    public ArrayStack(int size){
        stack = new T [size];
        this.size = 0;
    }

    @Override
    void push(Object value) {
        size++;
        if (size > stack.length){
            T[] newStack = new T[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        } else {
            stack[(size - 1)] = (T) value;
        }
    }

    @Override
    Object pop() {
        T result = null;
        if (size == 0) {
            System.out.println("Removing from an empty stack");
        } else {
            result = stack[size - 1];
            stack[size - 1] = null;
        }
        return result;
    }

    @Override
    Object peek() {
        if (size == 0){
            System.out.println("Stack is Empty, Returned null");
            return null;
        } else {
            return stack[size-1];
        }

    }

    @Override
    int size() {
        return size;
    }

    @Override
    boolean isEmpty() {
        return (size == 0);
    }

    @Override
    void clear() {
        T[] newStack = new T[stack.length];
        stack = newStack;
    }
}
