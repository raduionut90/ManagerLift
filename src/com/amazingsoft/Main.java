package com.amazingsoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ManagerLifturi managerLifturi = new ManagerLifturi(10, 3);
        managerLifturi.callElevator(7);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(7);
        managerLifturi.callElevator(4);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(3);
        managerLifturi.callElevator(7);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(1);
        managerLifturi.callElevator(4);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(3);
        managerLifturi.callElevator(9);
        managerLifturi.callElevator(1);
        managerLifturi.callElevator(8);
        managerLifturi.callElevator(5);
        managerLifturi.callElevator(3);
        System.err.println("Am terminat toate task-urile");

    }
}
