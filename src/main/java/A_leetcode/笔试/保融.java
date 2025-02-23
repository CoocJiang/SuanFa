package A_leetcode.笔试;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 保融 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread A = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    System.out.print("A");
                    conditionB.signal(); // 唤醒B线程
                    if (i < 9) {
                        conditionA.await(); // 等待下次唤醒
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread B = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    System.out.print("B");
                    conditionC.signal(); // 唤醒C线程
                    if (i < 9) {
                        conditionB.await(); // 等待下次唤醒
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread C = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    System.out.println("C");
                    conditionA.signal(); // 唤醒A线程
                    if (i < 9) {
                        conditionC.await(); // 等待下次唤醒
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        A.start();
        B.start();
        C.start();
    }

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


    //开启三个线ABC程输出ABC10次按顺序
    public static void thread() throws InterruptedException {
       ReentrantLock lock = new ReentrantLock();
       Condition condition = lock.newCondition();
       Thread A = new Thread(()->{
           for (int i=0;i<10;i++){
               lock.lock();
               System.out.print("A");
               try {
                   condition.signal();
                   condition.await();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       });
        Thread B =  new Thread(()->{
            for (int i=0;i<10;i++){
                lock.lock();
                System.out.print("B");
                try {
                    condition.signal();
                    condition.await();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread C = new Thread(()->{
            for (int i=0;i<10;i++){
                lock.lock();
                System.out.println("C");
                try {
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        A.start();
        Thread.sleep(1);
        B.start();

        C.start();
    }


}
