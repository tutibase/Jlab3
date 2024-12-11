package org.example;

public class Customer implements Runnable {
    private final Cashier cashier;
    private final int fuelAmount;

    public Customer(Cashier cashier, int fuelAmount) {
        this.cashier = cashier;
        this.fuelAmount = fuelAmount;
    }

    @Override
    public void run() {
        try {
            cashier.payForFuel(fuelAmount);
            Pump pump = cashier.getAvailablePump();
            pump.startPumping(fuelAmount);
            cashier.releasePump(pump);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
