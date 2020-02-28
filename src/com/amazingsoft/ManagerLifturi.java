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
        int count = nrEtaje;
        Lift liftApropiat = null;
        for (Lift lift : listaLift) {
            int diferentaEtaje = Math.abs(etajCurent - lift.getEtajCurent());
            System.out.println("Liftul este la etajul " + lift.getEtajCurent());
            if (diferentaEtaje < count && diferentaEtaje != count) {
                count = diferentaEtaje;
                liftApropiat = lift;
            }
        }
        if (!liftApropiat.isInMiscare()) {
            ElevatorThread elevatorEvent = new ElevatorThread(liftApropiat, etajCurent); //etaj destinatie
            elevatorEvent.();
        }
        System.out.println("Cel mai apropiat lift este " + liftApropiat);
    }

}
