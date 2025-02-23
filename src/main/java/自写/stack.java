package 自写;

public class stack {

    private int [] data;
    private int left;
    private int right;

    public stack (int size){
        this.data = new int[size];
        left=0;
        right=0;
    }

    public boolean isempty(){
        return left==right;
    }


    public void push(int num){
        data[right++] = num;
    }

    public int pop(){
        if (left==right){
            throw new NullPointerException("zhan为空");
        }
        return data[--right];
    }
}
