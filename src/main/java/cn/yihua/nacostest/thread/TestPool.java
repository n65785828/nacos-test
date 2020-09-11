package cn.yihua.nacostest.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestPool {

    public static void main(String[] args) throws InterruptedException {
        TestPool testPool = new TestPool();
        Thread t1 = new Thread(testPool.runnable);
        Thread t2 = new Thread(testPool.runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("unsafeCounter=" + testPool.safeCounter.toString());

    }

    private int increment = 10000;
    private AtomicInteger safeCounter = new AtomicInteger(0);
    private void unsafeIncrease() {
        int idx = 0;
        while (idx++ < increment) {
            safeCounter.incrementAndGet();
        }
    }
    // 多个线程执行不安全的非原子性操作
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            unsafeIncrease();
        }
    };

}
