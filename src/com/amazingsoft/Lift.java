package com.amazingsoft;

public class Lift{
    private int id;
    private int etajCurent;
    private boolean inMiscare;

    public Lift(int id, int etajCurent) {
        this.id = id;
        this.etajCurent = etajCurent;
        inMiscare = false;
    }

    public int getId() {
        return id;
    }

    public int getEtajCurent() {
        return etajCurent;
    }

    public boolean isInMiscare() {
        return inMiscare;
    }

    public void setInMiscare(boolean inMiscare) {
        this.inMiscare = inMiscare;
    }

    @Override
    public String toString() {
        return "Liftul cu id " + id + " care se afla acum la etajul " + etajCurent;
    }

}
