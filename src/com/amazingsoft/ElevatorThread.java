package com.amazingsoft;

public class ElevatorThread implements Runnable {
    private Lift lift;
    ManagerLifturi managerLifturi;

    public ElevatorThread(Lift lift, ManagerLifturi managerLifturi) {
        this.lift = lift;
        this.managerLifturi = managerLifturi;
    }

    @Override
    public void run() {
        if(lift.getEtajCurent() < lift.getEtajDestinatie()){
            lift.urca(managerLifturi);
        } else if (lift.getEtajCurent() > lift.getEtajDestinatie()){
            lift.coboara(managerLifturi);
        } else{
            lift.pozitie(managerLifturi);
        }
    }

    @Override
    public String toString() {
        return "Ruleaza " + Thread.currentThread().getName() + " pentru " + lift;
    }
}


