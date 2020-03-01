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

        Thread elevatorThread = new Thread(new ElevatorThread(cautaLift(etajDestinatie)));
        elevatorThread.start();
        if (!elevatorThread.isAlive()){
            notify();
            System.out.println("notific");
        }
    }

    public synchronized Lift cautaLift(int etajDestinatie) {
        System.out.println("\n Se cauta un lift pentru a merge la etajul " + etajDestinatie);
        System.out.println("==== Pozitia lifturilor =====");
        int count = nrEtaje;
        Lift liftApropiat = null;
        while(liftApropiat==null) {
            for (Lift lift : listaLift) {
                System.out.println("Liftul " + lift.getId() + " este la etajul " + lift.getEtajCurent() + " inMiscare?" + lift.isInMiscare());
                int diferentaEtaje = Math.abs(etajDestinatie - lift.getEtajCurent());
                if (!lift.isInMiscare() && diferentaEtaje < count) {
                    count = diferentaEtaje;
                    liftApropiat = lift;
                    System.out.println("am gasit ceva");
                }
            }
            if (liftApropiat==null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (liftApropiat != null) {
            liftApropiat.setEtajDestinatie(etajDestinatie);
            System.out.println("A fost ales liftul " + liftApropiat + " sa mearga la etajul " + etajDestinatie);
            notify();
        }
        return liftApropiat;
    }


    public int getNrEtaje() {
        return nrEtaje;
    }

    public void setNrEtaje(int nrEtaje) {
        this.nrEtaje = nrEtaje;
    }

    public int getNrLifturi() {
        return nrLifturi;
    }

    public void setNrLifturi(int nrLifturi) {
        this.nrLifturi = nrLifturi;
    }

    public List<Lift> getListaLift() {
        return listaLift;
    }

    public void setListaLift(List<Lift> listaLift) {
        this.listaLift = listaLift;
    }
}
