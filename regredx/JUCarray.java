package regredx;

import java.util.concurrent.locks.LockSupport;

public class JUCarray {
    static Thread t1=null;
    static Thread t2=null;
    public void array(int a[],int b[]){
        t1=new Thread(()->{
            for(int i:a){
                System.out.println(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2=new Thread(()->{
            for(int i:b){

                LockSupport.park();
                System.out.println(i);
                LockSupport.unpark(t1);

            }
        });
        t1.start();
        t2.start();
    }
}
