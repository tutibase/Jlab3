package org.Jlab3;

public class Pump implements Runnable {
    private final int pumpId;
    private int fuelAmount;

    public Pump(int pumpId) {
        this.pumpId = pumpId;
    }

    public void startPumping(int fuelAmount) throws InterruptedException {
        this.fuelAmount = fuelAmount;
        System.out.println(Thread.currentThread().getName() + " начал заправлять " + fuelAmount + " единиц топлива на колонке " + pumpId);

        Thread pumpingThread = new Thread(this);
        pumpingThread.start();
        pumpingThread.join();

        System.out.println(Thread.currentThread().getName() + " закончил заправляться");

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < fuelAmount; i++) {
                Thread.sleep(100); // Имитация передачи топлива
                //System.out.println(Thread.currentThread().getName() + " передал 1 единицу топлива на колонке " + pumpId);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
