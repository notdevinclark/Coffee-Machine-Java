package com.notdevinclark.machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine coffeeMachine = new Machine();
        coffeeMachine.powerOn();

        while (coffeeMachine.isPoweredOn()) {
            coffeeMachine.mainMenuInteract();
        }
    }
}
