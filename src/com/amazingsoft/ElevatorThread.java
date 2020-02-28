package com.amazingsoft;

public class ElevatorThread implements Runnable {
    private Lift lift;
    private int etajDestinatie;

    public ElevatorThread(Lift lift, int etajDestinatie) {
        this.lift = lift;
        this.etajDestinatie = etajDestinatie;
    }

    @Override
    public void run() {
        lift.setInMiscare(true);
//        int etajeDiferenta = Math.abs(lift.getEtajCurent() - etajDestinatie);
        if(lift.getEtajCurent() < etajDestinatie){
            for (int i = lift.getEtajCurent()+1; i <= etajDestinatie; i++) {
                System.out.println("Liftul " + lift.getId() + " a urcat la etajul " + i);
            }
        } else if (lift.getEtajCurent() > etajDestinatie){
            for (int i = lift.getEtajCurent()-1; i >= etajDestinatie; i--) {
                System.out.println("Liftul " + lift.getId() + " coboara la etajul " + i);
            }
        } else {
            System.out.println("Liftul este deja la etajul " + etajDestinatie);
        }

        lift.setEtajCurent(etajDestinatie);
        System.out.println("Liftul a ajuns la etajul " + etajDestinatie);
        lift.setInMiscare(false);
    }
}


