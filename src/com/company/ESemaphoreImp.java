package com.company;

import java.util.concurrent.Semaphore;

public class ESemaphoreImp {

    private int n;
    private Semaphore fooLock = new Semaphore(1);
    private Semaphore barLock = new Semaphore(0);

    public ESemaphoreImp(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooLock.acquire();
            printFoo.run();
            barLock.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            barLock.acquire();
            printBar.run();
            fooLock.release();
        }
    }
}
