package org.Jlab3;

public class Customer implements Runnable {
    private final Cashier cashier;
    private final int fuelAmount;
    private int money;

    public Customer(Cashier cashier, int fuelAmount, int money) {
        this.cashier = cashier;
        this.fuelAmount = fuelAmount;
        this.money = money;
    }

    public void payMoney(int amount) {
        money -= amount;
    }

    public int getMoney(){
        return money;
    }

    @Override
    public void run() {
        try {
            cashier.payForFuel(fuelAmount, this);
            Pump pump = cashier.getAvailablePump();
            pump.startPumping(fuelAmount);
            cashier.releasePump(pump);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
