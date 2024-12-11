package org.example;

public class GasStation {
    public static void main(String[] args) {
        Pump[] pumps = {new Pump(), new Pump(), new Pump()};
        Cashier cashier = new Cashier(pumps);

        Thread[] customers = new Thread[6];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new Customer(cashier, (i + 1) * 10));
            customers[i].start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

