package 自写;

public class quene {

    int [] size;
    int left;
    int right;

    public quene(int size){
        this.size = new int[size];
        left=0;
        right=0;
    }

    public boolean isempty(){
        return left==right;
    }

    public void push(int num){
        size[right] = num;
        right++;
    }

    public int pop(){
        if (left==right){
           throw new NullPointerException("队列为空");
        }else {
            return size[left++];
        }
    }

}
