package 自写;

//循环队列
public class quene2 {

    int [] data;
    int left;
    int right;
    int size;


    public quene2(int size){
        this.data = new int[size];
        left=0;
        right=0;
        this.size = 0;
    }

    public boolean isempty(){
        return size==0;
    }

    public void push(int num){
        if (size>= data.length){
           throw  new IllegalStateException("队列已满");
        }
        data[right] = num;
        size++;
        if (right+1==data.length){
            right=0;
        }else {
            right++;
        }
    }

    public int pop(){
        if (size==0){
            throw new IllegalStateException("队列为空");
        }else {
            size--;
            if (left== data.length-1){
                int result = data[left];
                left=0;
                return result;
            }else {
                return data[left++];
            }
        }

    }
}
