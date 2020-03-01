package com.amazingsoft;

public class ElevatorThread implements Runnable {
    private Lift lift;

    public ElevatorThread(Lift lift) {
        this.lift = lift;
    }

    @Override
    public void run() {
        System.out.println(this.toString());
        if(lift.getEtajCurent() < lift.getEtajDestinatie()){
            lift.urca();
        } else if (lift.getEtajCurent() > lift.getEtajDestinatie()){
            lift.coboara();
        } else{
            lift.pozitie();
        }
    }


}


