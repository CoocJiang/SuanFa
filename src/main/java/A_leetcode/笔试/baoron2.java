package A_leetcode.笔试;

public class baoron2 {


    //是否是回文串？
    public static boolean huiwen(String str){
        int left = 0;
        int right = str.length()-1;
        while (left<=right){
            if (str.charAt(left)==str.charAt(right)){
                left++;
                right--;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }


    //代理模式
    public class daili{
        dailiren dailiren;
        public daili(dailiren dailiren){
            this.dailiren = dailiren;
        }

        public void dailifangfa(){
            System.out.println("代理执行方法");
            dailiren.method();
        }
    }

    public class dailiren{

        public void method(){
            System.out.println("执行方法");
        }

    }


    //单例模式
    public static    class danli{
        public static danli danli;

        public  static danli getdanli(){
            if (danli==null){
                danli = new danli();
            }
            return danli;
        }
    }
}
