package com.notdevinclark.machine;

public enum BeverageRecipe {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int price;

    BeverageRecipe(int water, int milk, int beans, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }

    public int waterNeeded() {
        return this.water;
    }

    public int milkNeeded() {
        return this.milk;
    }

    public int beansNeeded() {
        return this.beans;
    }

    public int getPrice() {
        return this.price;
    }
}