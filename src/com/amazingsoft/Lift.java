package com.amazingsoft;

public class Lift {
    private int id;
    private int etajCurent;
    private boolean inMiscare;
    private int etajDestinatie;

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

    public void setEtajCurent(int etajCurent) {
        this.etajCurent = etajCurent;
    }

    protected void urca() {
        for (int i = etajCurent + 1; i <= etajDestinatie; i++) {
            System.out.println("Liftul " + getId() + " a urcat la etajul " + i);
            this.setEtajCurent(i);
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        System.out.println("Am terminat de urcat");
        setInMiscare(false);
    }

    protected void coboara() {
        for (int i = etajCurent - 1; i >= etajDestinatie; i--) {
            System.out.println("Liftul " + getId() + " coboara la etajul " + i);
            this.setEtajCurent(i);
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Am terminat de coborat");
        setInMiscare(false);
    }

    public synchronized void pozitie(){
        if (etajCurent == etajDestinatie){
            System.out.println(this + " sunt la etajul " + etajDestinatie);
        }
    }

    public boolean isInMiscare () {
        return inMiscare;
    }

    public void setInMiscare ( boolean inMiscare){
        this.inMiscare = inMiscare;
    }

    public int getEtajDestinatie () {
        return etajDestinatie;
    }

    public void setEtajDestinatie ( int etajDestinatie){
        this.etajDestinatie = etajDestinatie;
    }

    @Override
    public String toString () {
        return "liftul cu id " + id + " care se afla acum la etajul " + etajCurent;
    }

}
