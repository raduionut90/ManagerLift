package com.amazingsoft;

public class ElevatorThread implements Runnable {
    Lift lift;
    int etajDestinatie;

    public ElevatorThread(Lift lift, int etajDestinatie) {
        this.lift = lift;
        this.etajDestinatie = etajDestinatie;
    }

    @Override
    public void run() {
        lift.setInMiscare(true);
        int etajeDiferenta = Math.abs(lift.getEtajCurent()-etajDestinatie);
        for (int i=0; i < etajeDiferenta; i++){
            System.out.println("Liftul " + lift.getId() + " s-a miscat un etaj");
        }

    }
}


