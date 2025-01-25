package org.Jlab3;

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

    public synchronized void payForFuel(int fuelAmount, Customer customer) throws InterruptedException {
        int payment = fuelAmount * 10;
        System.out.println(Thread.currentThread().getName() + " платит " + payment + " за " + fuelAmount +
                " единиц топлива, до оплаты у него есть " + customer.getMoney());
        Thread.sleep(100);
        totalMoney += payment;
        customer.payMoney(payment);
        System.out.println(Thread.currentThread().getName() + " окончил оплату. Сейчас в кассе " + totalMoney +
                ", а у клиента осталось " + customer.getMoney());
    }

    public Pump getAvailablePump() throws InterruptedException {
        return availablePumps.take();
    }

    public void releasePump(Pump pump) {
        availablePumps.offer(pump);
    }
}
