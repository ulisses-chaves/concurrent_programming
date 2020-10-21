package numPrimo;

import java.math.BigInteger;


public class EhPrimoThread extends Thread {
    public int threadNumber;
    private BigInteger inicio;
    private BigInteger fim;
    private BigInteger N;
    public boolean isPrime;

    public EhPrimoThread(int threadNumber, BigInteger inicio, BigInteger fim, BigInteger N) {
        this.threadNumber = threadNumber;
        this.inicio = inicio;
        this.fim = fim;
        this.N = N;
        System.out.println("Thread criada #" + threadNumber);
    }

    public void run() {
        isPrime = ehPrimo(N);
    }

    public boolean ehPrimo(BigInteger n) {
        for (BigInteger i = inicio; i.compareTo(fim) < 0; i = i.add(BigInteger.ONE)) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                //System.out.println("Fator: " + i);
                return false;
            }
        }

        return true;
    }
}