package orcPresa;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Orcs extends Thread{
    String nome;
    private static Lock aLock = new ReentrantLock();
    //private Condition condVar = aLock.newCondition();

    public Orcs(String nome) {
        this.nome = nome;
        start();
    }


    public void morder(){
        System.out.println(nome+" vou tentar atacar.");
        aLock.lock();
        System.out.println(nome+ " estou atacando");
        try {
            if(Main.bode.isVivo()) {
                if (Main.bode.isAssustada()) {
                    Main.bode.setVivo(false);
                    System.out.println(nome+ " matei");
                } else {
                    Random rng = new Random();
                    int rng2 = rng.nextInt(2);
                    if (rng2 == 1) {
                        System.out.println(nome+ " matei");
                        Main.bode.setVivo(false);
                    } else {
                        gritar();
                    }
                }
            }/*else {
                System.out.println(nome+" fui tapiado");
            }*/
        } finally {
            aLock.unlock();
            //System.out.println(nome+ " ataquei.");
        }
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true){
            try{
                Thread.sleep(100+random.nextInt(100));
                if(Main.bode.isVivo()){
                    if(Main.bode.isAssustada()){
                        morder();
                    } else {
                        gritar();
                    }
                } else {
                    continue;
                }
            } catch (InterruptedException e) {
                System.out.println("ajuda deus");
            }
        }
    }

    public void gritar(){
        System.out.println(nome+ " vou gritar");
       Main.bode.setAssustada(true);

        try {
            Random random = new Random();
            Thread.sleep(10+ random.nextInt(100));
        } catch (InterruptedException e){
            //
        }
        morder();

    }
}