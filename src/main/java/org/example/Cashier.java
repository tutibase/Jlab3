package org.example;

public class Cashier {
    private final Pump[] pumps;

    public Cashier(Pump[] pumps) {
        this.pumps = pumps;
    }

    public synchronized void payForFuel(int fuelAmount) throws InterruptedException {
        long threadId = Thread.currentThread().threadId();
        System.out.println(Thread.currentThread().getName() + " платит за " + fuelAmount + " единиц топлива");
        Thread.sleep(100); // ждем окончания оплаты
    }

    public synchronized Pump getAvailablePump() {
        for (Pump pump : pumps) {
            if (pump.isAvailable()) {
                return pump;
            }
        }
        return null;
    }
}
