package Stream;

public class demo2 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> demo1 = Class.forName("Stream.demo1");
        demo1 o =(demo1) demo1.newInstance();
        System.out.println(o.a());
    }
}
