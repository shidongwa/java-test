package com.stone.thread;

public class ProducerConsumer {
    static Object key = new Object();
    private static int[] buffer;
    private static int currentSize;

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        currentSize = 0;

        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        Runnable prodRunn = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    producer.produce(x);
                }
                System.out.println("Produced...");
            }
        };

        Runnable consRunn = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    consumer.consume();
                }
                System.out.println("Consumer...");
            }
        };

        Thread prodThread = new Thread(prodRunn);
        Thread consThread = new Thread(consRunn);

        prodThread.start();
        consThread.start();

        prodThread.join();
        consThread.join();

        System.out.println("Buffer size : " + currentSize);
    }

    static class Producer {
        void produce(int x) {
            synchronized (key) {
                if (currentSize == buffer.length) {
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("produce buf[" + currentSize +"]=" + x);
                buffer[currentSize++] = x;
                key.notifyAll();
            }
        }
    }

    static class Consumer {
        void consume() {
            synchronized (key) {
                if (currentSize == 0) {
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x = buffer[--currentSize];
                System.out.println("consume buf[" + currentSize + "]=" + x);
                key.notifyAll();
            }
        }
    }
}
