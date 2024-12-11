package org.example;

public class Pump {
    private boolean available = true;

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void startPumping(int fuelAmount) throws InterruptedException {
        available = false;
        System.out.println(Thread.currentThread().getName() + " начал заправлять " + fuelAmount + " единиц топлива");
        Thread.sleep(1000); // ждем окончания заправки
        System.out.println(Thread.currentThread().getName() + " закончил заправляться");
        available = true;
        notifyAll();
    }
}
