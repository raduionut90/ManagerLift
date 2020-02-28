package com.amazingsoft;

import java.util.ArrayList;
import java.util.List;

public class ManagerLifturi implements CallElevator {
    private int nrEtaje;
    private int nrLifturi;
    private List<Lift> listaLift = new ArrayList<>();

    public ManagerLifturi(int nrEtaje, int nrLifturi) {
        this.nrEtaje = nrEtaje;
        this.nrLifturi = nrLifturi;
        creazaLifturi(nrLifturi);
    }

    private void creazaLifturi(int nr) {
        for (int i = 0; i < nrLifturi; i++) {
            int etaj = (int) (Math.random() * nrEtaje + 1);
            listaLift.add(new Lift(i, etaj));
        }
    }

    @Override
    public void callElevator(int etajCurent) {
        System.out.println("\n ==== Pozitia initiala a lifturilor =====");
        int count = nrEtaje;
        Lift liftApropiat = null;
        for (Lift lift : listaLift) {
            int diferentaEtaje = Math.abs(etajCurent - lift.getEtajCurent());
            System.out.println("Liftul "+ lift.getId() +" este la etajul " + lift.getEtajCurent());
            if (diferentaEtaje < count) {
                count = diferentaEtaje;
                liftApropiat = lift;
            }
        }
        System.out.println("Cel mai apropiat lift de etajul " + etajCurent + " este " + liftApropiat);

        if(!liftApropiat.isInMiscare()) {
            Thread elevatorThread = new Thread(new ElevatorThread(liftApropiat, etajCurent)); //etaj destinatie
            elevatorThread.start();
        } else {
            System.out.println("Liftul este deja in miscare");
        }

    }

}
