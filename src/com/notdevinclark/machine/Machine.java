package com.notdevinclark.machine;

import java.util.Scanner;
import static com.notdevinclark.machine.BeverageRecipe.*;

public class Machine {
    private Scanner scanner;
    private MachineState state;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public Machine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public void mainMenuInteract() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = scanner.next();
        switch (input) {
            case "buy" -> handlePurchase();
            case "fill" -> handleRefilling();
            case "take" -> emptyCashReserve();
            case "remaining" -> printOutCurrentStock();
            case "exit" -> powerOff();
        }
    }

    private void handlePurchase() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String input = scanner.next();
        switch (input) {
            case "1" -> sellBeverage(ESPRESSO);
            case "2" -> sellBeverage(LATTE);
            case "3" -> sellBeverage(CAPPUCCINO);
            case "back" -> {}
        }
    }
    private void handleRefilling() {
        System.out.println("Write how many ml of water you want to add: ");
        int newWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int newMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int newBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int newCups = scanner.nextInt();

        water += newWater;
        milk += newMilk;
        beans += newBeans;
        cups += newCups;
    }
    private void emptyCashReserve() {
        System.out.printf("I give you $%d%n", this.money);
        this.money = 0;
    }
    private void printOutCurrentStock() {
        System.out.println("The coffee machine has:");
        printCurrentAmountOfWater();
        printCurrentAmountOfMilk();
        printCurrentAmountOfBeans();
        printCurrentAmountOfCups();
        printCurrentAmountOfMoney();
    }

    public void powerOn() {
        this.scanner = new Scanner(System.in);
        this.state = MachineState.ON;
    }

    public boolean isPoweredOn() {
        return this.state != MachineState.OFF;
    }

    public void powerOff() {
        this.scanner.close();
        this.state = MachineState.OFF;
    }

    public void sellBeverage(BeverageRecipe recipe) {
        if (water < recipe.waterNeeded()) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < recipe.milkNeeded()) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < recipe.beansNeeded()) {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        if (cups == 0) {
            System.out.println("Sorry, not enough cups!");
            return;
        }

        water -= recipe.waterNeeded();
        milk -= recipe.milkNeeded();
        beans -= recipe.beansNeeded();
        cups--;
        money += recipe.getPrice();

        System.out.println("I have enough resources, making you a coffee!");
    }

    private void printCurrentAmountOfWater() {
        System.out.println(water + " ml of water");
    }

    private void printCurrentAmountOfMilk() {
        System.out.println(milk + " ml of milk");
    }

    private void printCurrentAmountOfBeans() {
        System.out.println(beans + " g of coffee beans");
    }

    private void printCurrentAmountOfCups() {
        System.out.println(cups + " disposable cups");
    }

    private void printCurrentAmountOfMoney() {
        System.out.println("$" + money + " of money");
    }
}
