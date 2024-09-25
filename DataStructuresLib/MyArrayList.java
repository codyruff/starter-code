package DataStructuresLib;

import java.util.Arrays;

public class MyArrayList<T> extends DataStructuresLib.MyList<T> {
    int end;
    Object data[];
    public MyArrayList(){
        this.data = new Object[10];
        this.end = -1;
    }
    public MyArrayList(int size){
        this.data = new Object[size];
        this.end = -1;
    }



    @Override
    void add(T value) {
        end++;
        this.data[end] = value;
        if(end >= this.data.length){
            Object[] newData = new Object[this.data.length * 2];
            for(int i= 0; i< end; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    void add(T value, int position) {
        end++;

        if(end >= this.data.length){ // if list too long resize
            Object[] newData = new Object[this.data.length * 2];
            for(int i= 0; i< end; i++){
                newData[i] = this.data[i];
            }
            this.data = newData; // replace old array with new
        }// end if

        for (int i = end; i > position; i--) { // slide everything down one
            data[i] = this.data[i-1];
        }
        data[position] = value;

        //throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    T remove(int position) {
        Object result = data[position];

        for (int i = position; i <= end; i++) { // slide everything down one
            data[i] = this.data[i+1];
        }
        data[end] = null;
        end--;

        return (T) result;
        //throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    T get(int position) {
        return (T) data[position];
        //throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    T set(int position, T newValue) {
        if(position > this.end){
            throw new IndexOutOfBoundsException();
        }
        Object result = this.data[position];
        this.data[position] = newValue;
        return (T) result;
    }

    @Override
    int size() {
        return end;
        //throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    boolean contains(T value) {
        for (int i = 0; i < end; i++) {
            if(data[i].equals(value)){
                return true;
            }
        }
        return false;
        //throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    boolean isEmpty() {
        return (end == 0);
        //throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    void clear() {
        Object[] newData = new Object[this.data.length];
        data = newData;
        //throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList testList = new MyArrayList(20);
        int test = 22;
        testList.add(test);
        testList.add("test add spot", 6);
        System.out.println(testList);
    }
}
