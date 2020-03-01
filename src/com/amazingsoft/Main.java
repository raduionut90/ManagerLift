package com.amazingsoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ManagerLifturi managerLifturi = new ManagerLifturi(1000, 5);
        managerLifturi.callElevator(700);
        managerLifturi.callElevator(900);
        managerLifturi.callElevator(744);
        managerLifturi.callElevator(422);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(3);
        managerLifturi.callElevator(70);
        managerLifturi.callElevator(900);
        managerLifturi.callElevator(144);
        managerLifturi.callElevator(40);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(300);
        managerLifturi.callElevator(944);
        managerLifturi.callElevator(1);
        managerLifturi.callElevator(444);
        managerLifturi.callElevator(5);
        managerLifturi.callElevator(3);
        System.out.println("Functioneaza");

    }
}
