package Thread;

/**
 * @ClassName StopThread
 * @Description TODO
 * @Auther danni
 * @Date 2019/11/5 11:34]
 * @Version 1.0
 **/

public class StopThread {
    public static class stopThread implements Runnable{
     private volatile boolean flag=false;
        @Override
        public void run() {
            while(!flag){
                System.out.println("开始.....");
                try {
                    System.out.println("执行.....");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("退出.....");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        stopThread stopthread=new stopThread();
        Thread thread=new Thread(stopthread);
        thread.start();
        System.out.println("请求中断....");
        Thread.sleep(1000);
        stopthread.flag=true;
        System.out.println("响应开始....");
        thread.join(10);
        System.out.println("响应结束....");
    }
}
