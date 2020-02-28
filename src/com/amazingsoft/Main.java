package com.amazingsoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ManagerLifturi managerLifturi = new ManagerLifturi(100, 2);
        managerLifturi.callElevator(7);
        managerLifturi.callElevator(90);
        managerLifturi.callElevator(10);
        managerLifturi.callElevator(19);

    }
}
