package org.example;

public class Pump {
    private boolean available = true;
    private final int pumpId;

    public Pump(int pumpId) {
        this.pumpId = pumpId;
    }

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void startPumping(int fuelAmount) throws InterruptedException {
        available = false;
        System.out.println(Thread.currentThread().getName() + " начал заправлять " + fuelAmount + " единиц топлива на колонке " + pumpId);
        Thread.sleep(1000); // ждем окончания заправки
        System.out.println(Thread.currentThread().getName() + " закончил заправляться");
        available = true;
        notifyAll();
    }
}
