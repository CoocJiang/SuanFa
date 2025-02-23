package 自写;

public class test {
    public static void main(String[] args) {
        quene quene = new quene(10);
        quene.push(10);
        quene.push(9);
        quene.push(2);
        quene.push(1);
        stack stack = new stack(10);
        stack.push(10);
        stack.push(9);
        stack.push(2);
        stack.push(1);
        quene2 quene2 = new quene2(5);
        quene2.push(10);
        quene2.push(9);
        quene2.push(2);
        quene2.push(1);
        quene2.push(2);
        while (!quene2.isempty()){
            System.out.println(quene2.pop());
        }
        quene2.push(10);
        quene2.push(9);
        quene2.push(2);
        quene2.push(1);
        quene2.push(2);
        while (!quene2.isempty()){
            System.out.println(quene2.pop());
        }
    }
}
