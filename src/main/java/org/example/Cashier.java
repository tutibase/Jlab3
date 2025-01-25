package org.example;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Cashier {
    private final ArrayBlockingQueue<Pump> availablePumps;
    private int totalMoney;

    public Cashier(Pump[] pumps) {
        this.availablePumps = new ArrayBlockingQueue<>(3);
        availablePumps.addAll(Arrays.asList(pumps));
        this.totalMoney = 0;
    }

    public synchronized void payForFuel(int fuelAmount) throws InterruptedException {
        int payment = fuelAmount * 10;
        System.out.println(Thread.currentThread().getName() + " платит " + payment + " за " + fuelAmount + " единиц топлива");
        Thread.sleep(100);
        totalMoney += payment;
        System.out.println(Thread.currentThread().getName() + " окончил оплату. Сейчас в кассе " + totalMoney);
    }

    public Pump getAvailablePump() throws InterruptedException {
        return availablePumps.take();
    }

    public void releasePump(Pump pump) {
        availablePumps.offer(pump);
    }
}
