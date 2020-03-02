package com.amazingsoft;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ManagerLifturi implements CallElevator {
    private int nrEtaje;
    private int nrLifturi;
    private List<Lift> listaLift = new ArrayList<>();

    public ManagerLifturi(int nrEtaje, int nrLifturi) {
        this.nrEtaje = nrEtaje;
        this.nrLifturi = nrLifturi;
        creazaLifturi();
    }

    private void creazaLifturi() {
        for (int i = 0; i < nrLifturi; i++) {
            int etaj = (int) (Math.random() * nrEtaje + 1);
            listaLift.add(new Lift(i, etaj));
        }
    }

    @Override
    public synchronized void callElevator(int etajDestinatie) {
        Thread elevatorThread = new Thread(new ElevatorThread(cautaLift(etajDestinatie), this));
        elevatorThread.start();
    }

    public synchronized Lift cautaLift(int etajDestinatie) {
        System.out.println("\nThread-ul " + Thread.currentThread().getName() + " cauta un lift pentru a merge la etajul " + etajDestinatie);
        int count = nrEtaje;
        Lift liftApropiat = null;
        while (!esteLiftDisponibil()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Lift lift : listaLift) {
            int diferentaEtaje = Math.abs(etajDestinatie - lift.getEtajCurent());
            if (!lift.isInMiscare() && diferentaEtaje < count) {
                count = diferentaEtaje;
                liftApropiat = lift;
            }
        }
        liftApropiat.setInMiscare(true);
        liftApropiat.setEtajDestinatie(etajDestinatie);
        System.out.println("A fost ales " + liftApropiat + " sa mearga la etajul " + etajDestinatie);

        return liftApropiat;
    }

    public synchronized boolean esteLiftDisponibil() {
        boolean is = false;
        for (Lift lift : listaLift) {
            System.out.println("Liftul " + lift.getId() + " este la etajul " + lift.getEtajCurent() + " inMiscare ? " + lift.isInMiscare());
            if (!lift.isInMiscare()) {
                is = true;
            }
        }
        if (is == false) {
            System.err.println(Thread.currentThread().getName() + " Nu este nici un lift disponibil, asteptam sa se elibereze unul");
        }
        return is;
    }

    public synchronized void liftLiber() {
        notify();        //
    }

}
