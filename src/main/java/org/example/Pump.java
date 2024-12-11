package org.example;

public class Pump {
    private final int pumpId;

    public Pump(int pumpId) {
        this.pumpId = pumpId;
    }

    public synchronized void startPumping(int fuelAmount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " начал заправлять " + fuelAmount + " единиц топлива на колонке " + pumpId);
        Thread.sleep(1000); // ждем окончания заправки
        System.out.println(Thread.currentThread().getName() + " закончил заправляться");
        notifyAll();
    }
}
