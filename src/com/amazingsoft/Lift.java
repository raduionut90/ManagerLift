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

    protected void urca(ManagerLifturi managerLifturi) {
        for (int i = etajCurent + 1; i <= etajDestinatie; i++) {
            System.out.println(Thread.currentThread().getName() + " Liftul " + getId() + " a urcat la etajul " + i);
            this.setEtajCurent(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Lift " + getId() + " am terminat taskul, sunt disponibil");
        setInMiscare(false);
        managerLifturi.liftLiber(); //notific ca a devenit lift disponibil
    }

    protected void coboara(ManagerLifturi managerLifturi) {
        for (int i = etajCurent - 1; i >= etajDestinatie; i--) {
            System.out.println(Thread.currentThread().getName() + " Liftul " + getId() + " coboara la etajul " + i);
            this.setEtajCurent(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Lift " + getId() + " am terminat taskul, sunt disponibil");
        setInMiscare(false);
        managerLifturi.liftLiber();
    }

    public synchronized void pozitie(ManagerLifturi managerLifturi) {
        if (etajCurent == etajDestinatie) {
            System.out.println("Lift " + getId() + " sunt la etajul " + etajDestinatie);
        }
        managerLifturi.liftLiber();
    }

    public boolean isInMiscare() {
        return inMiscare;
    }

    public void setInMiscare(boolean inMiscare) {
        this.inMiscare = inMiscare;
    }

    public int getEtajDestinatie() {
        return etajDestinatie;
    }

    public void setEtajDestinatie(int etajDestinatie) {
        this.etajDestinatie = etajDestinatie;
    }

    @Override
    public String toString() {
        return "lift " + id + " care se afla acum la etajul " + etajCurent;
    }

}
