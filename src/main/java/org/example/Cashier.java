package org.example;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Cashier {
    private final ArrayBlockingQueue<Pump> availablePumps;

    public Cashier(Pump[] pumps) {
        this.availablePumps = new ArrayBlockingQueue<>(3);
        availablePumps.addAll(Arrays.asList(pumps));
    }

    public synchronized void payForFuel(int fuelAmount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " платит за " + fuelAmount + " единиц топлива");
        Thread.sleep(100); // ждем окончания оплаты
        System.out.println(Thread.currentThread().getName() + " окончил оплату");
    }

    public Pump getAvailablePump() throws InterruptedException {
        return availablePumps.take();
    }

    public void releasePump(Pump pump) {
        availablePumps.offer(pump);
    }
}
